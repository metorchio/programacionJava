package ar.com.maxo.springBootExample;


import ar.com.maxo.springBootExample.domain.Quote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
public class SpringBootApp {

    //private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);
    private static final Logger log = LogManager.getLogger(SpringBootApp.class);

	public static void main(String[] args) {
        log.info(">>> Starting app...");
		SpringApplication.run(SpringBootApp.class, args);
	}


}