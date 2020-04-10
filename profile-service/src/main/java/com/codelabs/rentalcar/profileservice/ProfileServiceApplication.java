package com.codelabs.rentalcar.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//we have added models classes in different project.
//And we are including that project as dependency in this service. 
//So if we don't tell main class which packages to scan in that project It will give below error 
//Not a managed type: class com.codelabs.rentalcar.commons.models.Customer
//To avoid that error we have to add give basePackage name of entity classes to scan.
@EntityScan(basePackages = "com.codelabs.rentalcar.commons.models")
@EnableResourceServer
//This is to enable method level security. To give Permission/Role based access to method
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

}
