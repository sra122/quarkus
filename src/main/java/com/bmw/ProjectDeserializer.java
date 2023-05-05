package com.bmw;

import com.bmw.domain.Project;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class ProjectDeserializer extends JsonbDeserializer<Project> {
 
    public ProjectDeserializer() {
        super(Project.class);
    }
}
