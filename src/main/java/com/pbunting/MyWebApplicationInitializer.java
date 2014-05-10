package com.pbunting;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.pbunting.webapp.WebConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
                appContext.register(WebConfig.class);
		//appContext.scan("com.pbunting.webapp"); // scans com.pbunting and
												// subpackages for beans
												// including @Configuration
												// beans
		//appContext.refresh();

		ServletRegistration.Dynamic registration = container.addServlet(
				"dispatcher", new DispatcherServlet(appContext));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}

}
