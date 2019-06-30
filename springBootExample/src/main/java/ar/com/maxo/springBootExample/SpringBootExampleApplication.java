package ar.com.maxo.springBootExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {

	private static final Logger logger = LogManager.getLogger(SpringBootExampleApplication.class);

	public static void main(String[] args) {
		logger.info(">>> Starting app...");
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

}



