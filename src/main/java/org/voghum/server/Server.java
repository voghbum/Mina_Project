package org.voghum.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.security.*;
import java.security.cert.CertificateException;

public class Server implements IoHandler{
    private String password = "Test12345*";
    private String serverIp = "localhost";
    private int serverPort = 5061;
    private KeyManagerFactory kmf;
    private TrustManagerFactory tmf;
    private InputStream keyStoreFile;
    private InputStream trustStoreFile;
    private SSLContext sslContext;
    private String serverMsg = "server request: ";
    private int messageCnt = 0;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        initFiles();
        createTrustManagerKeyFactory();
        createSSLContext();
        createSocket();
    }

    private void initFiles() {
        try {
            keyStoreFile = new FileInputStream("C:\\Users\\husey\\repos\\Mina_Project\\src\\lib\\keystore");
            trustStoreFile = new FileInputStream("C:\\Users\\husey\\repos\\Mina_Project\\src\\lib\\truststore");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTrustManagerKeyFactory() {
        var passArr = password.toCharArray();

        try {
            KeyStore ksStore = KeyStore.getInstance("PKCS12");
            ksStore.load(keyStoreFile, passArr);

            var ksTrust = KeyStore.getInstance("PKCS12");
            ksTrust.load(trustStoreFile, passArr);

            kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ksStore, passArr);

            tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ksStore);

        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException |
                 UnrecoverableKeyException ex) {
            throw new RuntimeException("Interrupted exception in createTrustManagerKeyFactory()", ex);
        }
    }

    private void createSSLContext() {
        try {
            sslContext = SSLContext.getInstance("TLSv1.3");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        } catch (NoSuchAlgorithmException | KeyManagementException ex) {
            throw new RuntimeException("Interrupted exception in createSSLContext()", ex);
        }
    }

    private void createSocket() {
        var nsa = new NioSocketAcceptor();
        var sslFilter = new SslFilter(sslContext);
        nsa.getFilterChain().addFirst("sslFilter", sslFilter);
        nsa.getFilterChain().addLast("logger", new LoggingFilter());
        nsa.setHandler(this);

        try {
            nsa.bind(new InetSocketAddress(serverPort));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sessionCreated(IoSession ioSession) throws Exception {
        System.out.println("sessionCreated");
    }

    @Override
    public void sessionOpened(IoSession ioSession) throws Exception {
        System.out.println("sessionOpened");
    }

    @Override
    public void sessionClosed(IoSession ioSession) throws Exception {
        System.out.println("sessionClosed");
    }

    @Override
    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {
        System.out.println("sessionIdle");
    }

    @Override
    public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {
        System.out.println("exceptionCaught");
    }

    @Override
    public void messageReceived(IoSession ioSession, Object o) throws Exception {
        var rcvd = ((IoBuffer)o).buf();
        var bArr = rcvd.array();
        var msgrcvd = new String(bArr);
        msgrcvd = msgrcvd.substring(0, rcvd.limit());
        System.out.println("Server bytes recieved: " + rcvd.limit() + ":" + msgrcvd);

        var iobuff = IoBuffer.allocate((serverMsg + messageCnt).length());
        iobuff.put((serverMsg + messageCnt).getBytes());
        iobuff.flip();
        ioSession.write(iobuff);

        messageCnt++;
    }

    @Override
    public void messageSent(IoSession ioSession, Object o) throws Exception {
        var rcvd = ((IoBuffer)o).buf();
        var bArr = rcvd.array();
        var msgrcvd = new String(bArr);
        msgrcvd = msgrcvd.substring(0, rcvd.limit());
        System.out.println("Server bytes sent: " + rcvd.limit() + ":" + msgrcvd);
    }

    @Override
    public void inputClosed(IoSession ioSession) throws Exception {
        System.out.println("inputClosed");
    }

    @Override
    public void event(IoSession ioSession, FilterEvent filterEvent) throws Exception {
        System.out.println("event");
    }
}
