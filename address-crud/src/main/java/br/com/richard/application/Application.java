package br.com.richard.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author richard
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "br.com.richard" })
@EnableAutoConfiguration
@EntityScan(basePackages = { "br.com.richard.model" })
@EnableJpaRepositories(basePackages = { "br.com.richard.repository" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
