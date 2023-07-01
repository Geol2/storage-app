package com.geol.storage;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		String connectPath = "/data/**";

		String os = System.getProperty("os.name").toLowerCase();

		String resourcePath = null;

		if( os.contains("win") ) {
			resourcePath = "file:///D:/Project/data/";
		} else {
			resourcePath = "file:///home/data/";
		}

		registry.addResourceHandler(connectPath)
				.addResourceLocations(resourcePath);
	}
}
