package ar.com.maxo.springBootExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootExampleApplication {

	private static final Logger logger = LogManager.getLogger(SpringBootExampleApplication.class);

	public static void main(String[] args) {
		logger.info(">>> Starting app...");
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Startup Date: " + ctx.getStartupDate() );
			System.out.println("Environment: " + ctx.getEnvironment() );
			System.out.println("Class loader: " + ctx.getClassLoader() );
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
}



