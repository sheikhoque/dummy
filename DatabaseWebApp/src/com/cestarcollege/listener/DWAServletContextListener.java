package com.cestarcollege.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cestarcollege.util.DatabaseUtil;

/**
 * Application Lifecycle Listener implementation class DWAServletContextListener
 *
 */
@WebListener
public class DWAServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DWAServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	try {
			DatabaseUtil.getInstance().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        Connection conn = DatabaseUtil.getInstance().getConnection();
        System.out.println("hello");
    }
	
}
