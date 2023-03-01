# Mina_Project

# cient 
C:\Users\husey\.jdks\openjdk-19.0.1\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2022.2.1\lib\idea_rt.jar=4345:C:\Program Files\JetBrains\IntelliJ IDEA 2022.2.1\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\husey\repos\Mina_Project\target\classes;C:\Users\husey\.m2\repository\org\apache\mina\mina-core\2.1.3\mina-core-2.1.3.jar;C:\Users\husey\.m2\repository\org\apache\mina\mina-filter-ssl\1.1.7\mina-filter-ssl-1.1.7.jar;C:\Users\husey\.m2\repository\org\slf4j\slf4j-api\2.0.6\slf4j-api-2.0.6.jar;C:\Users\husey\.m2\repository\org\slf4j\slf4j-simple\2.0.6\slf4j-simple-2.0.6.jar org.voghum.client.Client
[NioProcessor-2] INFO org.apache.mina.filter.logging.LoggingFilter - CREATED
[NioProcessor-2] INFO org.apache.mina.filter.logging.LoggingFilter - OPENED
sessionCreated
sessionOpened
event
exceptionCaught
sessionClosed
[NioProcessor-2] WARN org.apache.mina.filter.logging.LoggingFilter - EXCEPTION :
javax.net.ssl.SSLHandshakeException: SSL handshake failed.
	at org.apache.mina.filter.ssl.SslFilter.messageReceived(SslFilter.java:536)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain.callNextMessageReceived(DefaultIoFilterChain.java:650)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain.access$1300(DefaultIoFilterChain.java:49)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain$EntryImpl$1.messageReceived(DefaultIoFilterChain.java:1128)
	at org.apache.mina.core.filterchain.IoFilterAdapter.messageReceived(IoFilterAdapter.java:122)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain.callNextMessageReceived(DefaultIoFilterChain.java:650)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain.fireMessageReceived(DefaultIoFilterChain.java:643)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor.read(AbstractPollingIoProcessor.java:539)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor.access$1200(AbstractPollingIoProcessor.java:68)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor$Processor.process(AbstractPollingIoProcessor.java:1222)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor$Processor.process(AbstractPollingIoProcessor.java:1211)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor$Processor.run(AbstractPollingIoProcessor.java:683)
	at org.apache.mina.util.NamePreservingRunnable.run(NamePreservingRunnable.java:64)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1589)
Caused by: javax.net.ssl.SSLHandshakeException: No trusted certificate found
	at java.base/sun.security.ssl.Alert.createSSLException(Alert.java:130)
	at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:371)
	at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:314)
	at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:309)
	at java.base/sun.security.ssl.CertificateMessage$T13CertificateConsumer.checkServerCerts(CertificateMessage.java:1351)
	at java.base/sun.security.ssl.CertificateMessage$T13CertificateConsumer.onConsumeCertificate(CertificateMessage.java:1226)
	at java.base/sun.security.ssl.CertificateMessage$T13CertificateConsumer.consume(CertificateMessage.java:1169)
	at java.base/sun.security.ssl.SSLHandshake.consume(SSLHandshake.java:396)
	at java.base/sun.security.ssl.HandshakeContext.dispatch(HandshakeContext.java:480)
	at java.base/sun.security.ssl.SSLEngineImpl$DelegatedTask$DelegatedAction.run(SSLEngineImpl.java:1273)
	at java.base/sun.security.ssl.SSLEngineImpl$DelegatedTask$DelegatedAction.run(SSLEngineImpl.java:1260)
	at java.base/java.security.AccessController.doPrivileged(AccessController.java:712)
	at java.base/sun.security.ssl.SSLEngineImpl$DelegatedTask.run(SSLEngineImpl.java:1205)
	at org.apache.mina.filter.ssl.SslHandler.doTasks(SslHandler.java:813)
	at org.apache.mina.filter.ssl.SslHandler.handshake(SslHandler.java:588)
	at org.apache.mina.filter.ssl.SslHandler.messageReceived(SslHandler.java:355)
	at org.apache.mina.filter.ssl.SslFilter.messageReceived(SslFilter.java:517)
	... 15 more
Caused by: sun.security.validator.ValidatorException: No trusted certificate found
	at java.base/sun.security.validator.SimpleValidator.buildTrustedChain(SimpleValidator.java:416)
	at java.base/sun.security.validator.SimpleValidator.engineValidate(SimpleValidator.java:140)
	at java.base/sun.security.validator.Validator.validate(Validator.java:256)
	at java.base/sun.security.ssl.X509TrustManagerImpl.checkTrusted(X509TrustManagerImpl.java:285)
	at java.base/sun.security.ssl.X509TrustManagerImpl.checkServerTrusted(X509TrustManagerImpl.java:144)
	at java.base/sun.security.ssl.CertificateMessage$T13CertificateConsumer.checkServerCerts(CertificateMessage.java:1329)
	... 27 more
[NioProcessor-2] INFO org.apache.mina.filter.logging.LoggingFilter - CLOSED

# Server

C:\Users\husey\.jdks\openjdk-19.0.1\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2022.2.1\lib\idea_rt.jar=4341:C:\Program Files\JetBrains\IntelliJ IDEA 2022.2.1\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\husey\repos\Mina_Project\target\classes;C:\Users\husey\.m2\repository\org\apache\mina\mina-core\2.1.3\mina-core-2.1.3.jar;C:\Users\husey\.m2\repository\org\apache\mina\mina-filter-ssl\1.1.7\mina-filter-ssl-1.1.7.jar;C:\Users\husey\.m2\repository\org\slf4j\slf4j-api\2.0.6\slf4j-api-2.0.6.jar;C:\Users\husey\.m2\repository\org\slf4j\slf4j-simple\2.0.6\slf4j-simple-2.0.6.jar org.voghum.server.Server
[NioProcessor-2] INFO org.apache.mina.filter.logging.LoggingFilter - CREATED
[NioProcessor-2] INFO org.apache.mina.filter.logging.LoggingFilter - OPENED
sessionCreated
sessionOpened
[NioProcessor-2] WARN org.apache.mina.filter.logging.LoggingFilter - EXCEPTION :
javax.net.ssl.SSLHandshakeException: SSL handshake failed.
	at org.apache.mina.filter.ssl.SslFilter.messageReceived(SslFilter.java:536)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain.callNextMessageReceived(DefaultIoFilterChain.java:650)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain.access$1300(DefaultIoFilterChain.java:49)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain$EntryImpl$1.messageReceived(DefaultIoFilterChain.java:1128)
	at org.apache.mina.core.filterchain.IoFilterAdapter.messageReceived(IoFilterAdapter.java:122)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain.callNextMessageReceived(DefaultIoFilterChain.java:650)
	at org.apache.mina.core.filterchain.DefaultIoFilterChain.fireMessageReceived(DefaultIoFilterChain.java:643)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor.read(AbstractPollingIoProcessor.java:539)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor.access$1200(AbstractPollingIoProcessor.java:68)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor$Processor.process(AbstractPollingIoProcessor.java:1222)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor$Processor.process(AbstractPollingIoProcessor.java:1211)
	at org.apache.mina.core.polling.AbstractPollingIoProcessor$Processor.run(AbstractPollingIoProcessor.java:683)
	at org.apache.mina.util.NamePreservingRunnable.run(NamePreservingRunnable.java:64)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1589)
Caused by: javax.net.ssl.SSLHandshakeException: Received fatal alert: certificate_unknown
	at java.base/sun.security.ssl.Alert.createSSLException(Alert.java:130)
	at java.base/sun.security.ssl.Alert.createSSLException(Alert.java:117)
	at java.base/sun.security.ssl.TransportContext.fatal(TransportContext.java:358)
	at java.base/sun.security.ssl.Alert$AlertConsumer.consume(Alert.java:286)
	at java.base/sun.security.ssl.TransportContext.dispatch(TransportContext.java:204)
	at java.base/sun.security.ssl.SSLTransport.decode(SSLTransport.java:172)
	at java.base/sun.security.ssl.SSLEngineImpl.decode(SSLEngineImpl.java:736)
	at java.base/sun.security.ssl.SSLEngineImpl.readRecord(SSLEngineImpl.java:691)
	at java.base/sun.security.ssl.SSLEngineImpl.unwrap(SSLEngineImpl.java:506)
	at java.base/sun.security.ssl.SSLEngineImpl.unwrap(SSLEngineImpl.java:482)
	at java.base/javax.net.ssl.SSLEngine.unwrap(SSLEngine.java:679)
	at org.apache.mina.filter.ssl.SslHandler.unwrap(SslHandler.java:774)
	at org.apache.mina.filter.ssl.SslHandler.unwrapHandshake(SslHandler.java:710)
	at org.apache.mina.filter.ssl.SslHandler.handshake(SslHandler.java:596)
	at org.apache.mina.filter.ssl.SslHandler.messageReceived(SslHandler.java:355)
	at org.apache.mina.filter.ssl.SslFilter.messageReceived(SslFilter.java:517)
	... 15 more
[NioProcessor-2] INFO org.apache.mina.filter.logging.LoggingFilter - CLOSED
exceptionCaught
sessionClosed
