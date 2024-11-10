package com.runtally.runtally;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaAuditing
@EnableJpaRepositories
public class RuntallyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuntallyApplication.class, args);
	}

}
