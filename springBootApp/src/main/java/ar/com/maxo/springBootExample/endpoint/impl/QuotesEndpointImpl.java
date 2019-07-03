package ar.com.maxo.springBootExample.endpoint.impl;

import ar.com.maxo.springBootExample.SpringBootApp;
import ar.com.maxo.springBootExample.domain.ChuckNorrisQuote;
import ar.com.maxo.springBootExample.domain.Quote;
import ar.com.maxo.springBootExample.endpoint.QuotesEndpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/api/quotes")
public class QuotesEndpointImpl implements QuotesEndpoint {

    private static final Logger log = LogManager.getLogger(SpringBootApp.class);
    private static final String randomSpringQuoteUrl = "https://gturnquist-quoters.cfapps.io/api/random";
    private static final String randomChuckNorrisQuoteUrl = "https://gturnquist-quoters.cfapps.io/api/random";


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    @RequestMapping("/spring/random")
    public Quote getRandomSprintQuote(RestTemplate restTemplate) {
        log.info("Quote from " + randomSpringQuoteUrl +"...");
        return restTemplate.getForObject(randomSpringQuoteUrl, Quote.class);
    }

    @Override
    @RequestMapping("/chuck/random")
    public ChuckNorrisQuote getRandomChuckNorrisQuote(RestTemplate restTemplate) {
        log.info("Quote from " + randomChuckNorrisQuoteUrl +"...");
        return restTemplate.getForObject(randomChuckNorrisQuoteUrl, ChuckNorrisQuote.class);
    }

}
