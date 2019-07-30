package ar.com.maxo.helloSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloSpringConfig {

    @Bean
    public HelloWorld getHelloWorld(){
        return new HelloWorld("Pepe!");
    }
}
