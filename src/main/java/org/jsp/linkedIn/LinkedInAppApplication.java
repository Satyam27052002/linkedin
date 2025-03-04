package org.jsp.linkedIn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LinkedInAppApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(LinkedInAppApplication.class, args);
	}
}
