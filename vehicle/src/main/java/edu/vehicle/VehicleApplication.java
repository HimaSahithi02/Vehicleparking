package edu.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({ "edu.vehicle", "edu.vehicle.controller", "edu.vehicle.dao", "edu.vehicle.service", "edu.vehicle.model",
		"edu.vehicle.config" })
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
public class VehicleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(VehicleApplication.class);
	}
}
