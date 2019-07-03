package ar.com.maxo.springBootExample;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootApp {

    private static final Logger log = LogManager.getLogger(SpringBootApp.class);

	public static void main(String[] args) {
        log.info(">>> Starting app...");
		SpringApplication.run(SpringBootApp.class, args);
	}


}