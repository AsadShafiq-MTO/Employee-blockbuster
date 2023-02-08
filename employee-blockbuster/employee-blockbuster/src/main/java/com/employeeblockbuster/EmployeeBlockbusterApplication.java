package com.employeeblockbuster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@EnableAutoConfiguration
@ComponentScan(basePackages={"com.employeeblockbuster"})
@EnableJpaRepositories(basePackages="com.employeeblockbuster.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.employeeblockbuster.entity")*/


@SpringBootApplication
public class EmployeeBlockbusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeBlockbusterApplication.class, args);
	}

}
