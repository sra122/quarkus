package com.bmw.controller;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import com.bmw.domain.Project;

@ApplicationScoped
public class KafkaConsumerController {


    @Incoming("data-input")
    public void receive(Project project) {
    	System.out.println("New project " + project.getTitle());    	
    }

    /*@Outgoing("data-output")
    @Incoming("data-input")
    public String modifyMessage(String info) {
        System.out.println("hello modifying info");
        return "Modified " + info;
    }*/
}
