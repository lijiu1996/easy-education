package com.lijiawei.education.serviceedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = {"com.lijiawei.education.serviceedu",
		"com.lijiawei.education.commonbase.config"})
public class ServiceEduApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEduApplication.class, args);
	}

}
