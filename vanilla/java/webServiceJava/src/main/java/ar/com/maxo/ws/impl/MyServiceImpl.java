package ar.com.maxo.ws.impl;

import ar.com.maxo.ws.MyService;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "ar.com.maxo.ws.MyService")
public class MyServiceImpl implements MyService {

    @Override
    public String getHelloWorldAsString(String name) {
        System.out.println("Entre al endpoint");
        return "Hello World JAX-WS " + name;
    }

}
