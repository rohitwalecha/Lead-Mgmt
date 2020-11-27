package org.codejudge.sb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.codejudge.sb"})
@EnableJpaRepositories("org.codejudge.sb.repo") 
@EntityScan("org.codejudge.sb")
@Slf4j
public class Application {

    public static void main(String[] args) {
       // log.info("Starting Application...");
        SpringApplication.run(Application.class, args);
    }
}
