package ar.com.maxo.endpoint;

/**
 * Created by enano on 2/19/2019.
 */
import javax.xml.ws.Endpoint;

import ar.com.maxo.ws.impl.MyServiceImpl;


//Endpoint publisher
public class MyServicePublisher {

    public static void main(String[] args) {
        System.out.println("Escuchando en 'localhost:9999'...");
        System.out.println("Consultar WSDL en 'http://localhost:9999/ws/hello?wsdl'...");
        Endpoint.publish("http://localhost:8080/ws/hello", new MyServiceImpl() );
    }

}

