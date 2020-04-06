package com.laon.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.laon.common.encrypt.AESEncrypt;

/**
 * Application Lifecycle Listener implementation class InitAESEncryptListener
 *
 */
@WebListener
public class InitAESEncryptListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitAESEncryptListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	String path = arg0.getServletContext().getRealPath("/WEB-INF");
//    	new AESEncrypt(path);
    }
	
}
