package com.revature.CookBook.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.revature.CookBook.util.SessionFactoryUtil;

//configuration can also be done in a spring-beans.xml file
@Configuration
@ComponentScan(value = "com.revature.CookBook")
@EnableAspectJAutoProxy
@EnableWebMvc
public class AppConfig implements WebApplicationInitializer, WebMvcConfigurer {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void onStartup(ServletContext container) {
		//create the 'root' Spring Application Context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		
		//Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));
		
		//create dispatcher servlet's context
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		
		//register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
	
	@Bean()
	@Scope(value = "singleton")
	public SessionFactory sessionFactory() {
		return SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE");
	}
}
