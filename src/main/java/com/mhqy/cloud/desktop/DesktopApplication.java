package com.mhqy.cloud.desktop;

import com.mhqy.cloud.desktop.controller.desktop.MessageController.MessageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DesktopApplication {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DesktopApplication.class);
		ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
		//解决WebSocket不能注入的问题
		MessageController.setApplicationContext(configurableApplicationContext);
	}
}