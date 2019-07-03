package ar.com.maxo.springBootExample.endpoint;

import ar.com.maxo.springBootExample.domain.ChuckNorrisQuote;
import ar.com.maxo.springBootExample.domain.Quote;
import org.springframework.web.client.RestTemplate;

public interface QuotesEndpoint {

    Quote getRandomSprintQuote(RestTemplate restTemplate);

    ChuckNorrisQuote getRandomChuckNorrisQuote(RestTemplate restTemplate);
}
