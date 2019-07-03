package ar.com.maxo.springBootExample.endpoint.impl;

import ar.com.maxo.springBootExample.endpoint.BaseEndpoint;
import ar.com.maxo.springBootExample.endpoint.HealthCheckEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckEndpointImpl implements HealthCheckEndpoint {

    @Override
    @RequestMapping("/check")
    public boolean isAlive() {
        return true;
    }
}
