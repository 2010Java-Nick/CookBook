package com.revature.CookBook;

import java.io.File;

import javax.servlet.ServletException;

import com.revature.CookBook.config.AppConfig;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ServerDriver {

    public static void main(String[] args) throws LifecycleException, ServletException {

        Tomcat server = new Tomcat();
        server.setPort(9091);
        server.getConnector();
        server.addWebapp("", new File("./").getAbsolutePath());
        server.start();
        server.getServer().await();

    }
}
