package com.redblue.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.redblue.data.repository")
public class DemoShardingsphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoShardingsphereApplication.class, args);
	}

}
