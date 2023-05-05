package com.bmw.controller;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumerController {


    @Incoming("data-input")
    public void receive(String message) {
    	System.out.println("Inside the consumer " + message);    	
    }

    
    
}
