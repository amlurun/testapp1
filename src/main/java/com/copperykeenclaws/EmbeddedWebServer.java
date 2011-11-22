package com.copperykeenclaws;

import javax.servlet.http.HttpServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedWebServer extends HttpServlet {

	private static final long serialVersionUID = -6777759990550225380L;

	public static void main(String[] args) throws Exception{
        String webappDirLocation = "src/main/webapp/";
        
        Server server = new Server(9001);
        WebAppContext root = new WebAppContext();
     
        root.setContextPath("/");
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
     
        root.setParentLoaderPriority(true);
     
        server.setHandler(root);
     
        server.start();
        server.join();
    }
}
