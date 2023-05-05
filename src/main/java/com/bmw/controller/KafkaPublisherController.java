package com.bmw.controller;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/kafka")
@ApplicationScoped
public class KafkaPublisherController {

    @Inject
    @Channel("data-output")
    Emitter<String> messageEmitter;


    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void publishMessage(String info) {
        messageEmitter.send(info);
    }
    
}
