package com.copperykeenclaws;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.ProtectionDomain;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class EmbeddedWebServer {

	private static final long serialVersionUID = -6777759990550225380L;

	public static void main(String[] args) throws Exception{
//        String appBase = "../*.war";
//        File appBaseDir = new File(appBase);
        
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.parseInt(webPort));
     
		// Load the war (assumes this class in in root of war file)
		final ProtectionDomain domain = EmbeddedWebServer.class.getProtectionDomain();
		final URL location = domain.getCodeSource().getLocation();
		tomcat.addWebapp("/", location.toURI().getPath());
		
        //tomcat.setBaseDir(".");
        //tomcat.getHost().setAppBase(appBaseDir.getAbsolutePath());
        
        // Add AprLifecycleListener
//        StandardServer server = (StandardServer) tomcat.getServer();
//        AprLifecycleListener listener = new AprLifecycleListener();
//        server.addLifecycleListener(listener);
//        
//        String contextPath = "/";
//        
//        tomcat.addWebapp(contextPath, appBaseDir.getAbsolutePath());
        
        // Start server
        tomcat.start();
        tomcat.getServer().await();
    }
	
	private static void addConnector(final int port, final boolean https, 
			final Tomcat tomcat, final File[] certificateStores) 
				throws IOException {
		final Connector connector = new Connector();
		connector.setScheme((https) ? "https" : "http");
		connector.setPort(port);
		connector.setProperty("maxPostSize", "0");  // unlimited
		connector.setProperty("xpoweredBy", "true");
		if(https) {
			connector.setSecure(true);
			connector.setProperty("SSLEnabled","true");
			connector.setProperty("keyPass", "123456");
			connector.setProperty("keystoreFile", certificateStores[0].getCanonicalPath());
			connector.setProperty("keystorePass", "123456");
			connector.setProperty("truststoreFile", certificateStores[1].getCanonicalPath());
			connector.setProperty("truststorePass", "123456");
		}
		tomcat.getService().addConnector(connector);
	}
}
