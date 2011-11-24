package com.copperykeenclaws;

import java.io.File;

import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;

public class EmbeddedWebServer {

	private static final long serialVersionUID = -6777759990550225380L;

	public static void main(String[] args) throws Exception{
        String appBase = "../*.war";
        File appBaseDir = new File(appBase);
        
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.parseInt(webPort));
     
        tomcat.setBaseDir(".");
        tomcat.getHost().setAppBase(appBaseDir.getAbsolutePath());
        
        // Add AprLifecycleListener
        StandardServer server = (StandardServer) tomcat.getServer();
        AprLifecycleListener listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);
        
        String contextPath = "/";
        
        tomcat.addWebapp(contextPath, appBaseDir.getAbsolutePath());
        
        // Start server
        tomcat.start();
        tomcat.getServer().await();
    }
}
