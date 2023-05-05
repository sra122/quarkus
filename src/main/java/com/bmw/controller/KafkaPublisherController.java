package com.bmw.controller;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import com.bmw.domain.Project;

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
    Emitter<Project> messageEmitter;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void publishMessage(Project project) {
        messageEmitter.send(project);
    }

}
