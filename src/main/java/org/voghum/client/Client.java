package org.voghum.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.voghum.server.Server;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.security.*;
import java.security.cert.CertificateException;

public class Client implements IoHandler {
    private String password = "Test12345*";
    private String serverIp = "localhost";
    private int serverPort = 5061;
    private KeyManagerFactory kmf;
    private TrustManagerFactory tmf;
    private InputStream keyStoreFile;
    private InputStream trustStoreFile;
    private SSLContext sslContext;
    private String serverMsg = "client response: ";
    private int messageCnt = 0;
    private IoSession session;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        initFiles();
        createTrustManagerKeyFactory();
        createSSLContext();
        createSocket();
    }

    private void initFiles() {
        keyStoreFile = Server.class.getResourceAsStream("src/lib/keystore");
        trustStoreFile = Server.class.getResourceAsStream("src/lib/truststore");
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
        var nsa = new NioSocketConnector();
        var sslFilter = new SslFilter(sslContext);

        sslFilter.setUseClientMode(true);
        nsa.getFilterChain().addFirst("sslFilter", sslFilter);
        nsa.getFilterChain().addLast("logger", new LoggingFilter());
        nsa.setHandler(this);
        var sendTime = 2000;
        Timer t = new Timer(sendTime, e -> timerInAction());

        t.start();

        ConnectFuture future = nsa.connect(new InetSocketAddress(serverIp, serverPort));
        future.awaitUninterruptibly();
    }

    private void timerInAction() {
        if(session != null) {
            var iobuff = IoBuffer.allocate((serverMsg + messageCnt).length());
            iobuff.put((serverMsg + messageCnt).getBytes());
            iobuff.flip();
            session.write(iobuff);
        }
    }

    @Override
    public void sessionCreated(IoSession ioSession) throws Exception {
        System.out.println("sessionCreated");
    }

    @Override
    public void sessionOpened(IoSession ioSession) throws Exception {
        System.out.println("sessionOpened");
        this.session = ioSession;
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
        System.out.println("client bytes recieved: " + rcvd.limit() + ":" + msgrcvd);
    }

    @Override
    public void messageSent(IoSession ioSession, Object o) throws Exception {
        var rcvd = ((IoBuffer)o).buf();
        var bArr = rcvd.array();
        var msgrcvd = new String(bArr);
        msgrcvd = msgrcvd.substring(0, rcvd.limit());
        System.out.println("client bytes sent: " + rcvd.limit() + ":" + msgrcvd);
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
