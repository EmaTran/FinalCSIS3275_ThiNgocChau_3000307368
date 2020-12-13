package com.studentfinal.webUI.listeners;

import com.studentfinal.data_access.sample_databases.SampleDatabase;

import javax.servlet.ServletContextEvent;

public class ServletListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SampleDatabase.initializeDatabase();
    }
}
