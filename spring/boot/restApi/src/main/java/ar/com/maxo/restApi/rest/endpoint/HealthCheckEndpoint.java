package ar.com.maxo.restApi.rest.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health")
public class HealthCheckEndpoint {

    @GetMapping("/isAlive")
    public @ResponseBody String isAlive() {
        return "alive.";
    }
}
