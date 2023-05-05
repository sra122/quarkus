package com.bmw.controller;

import java.util.List;
import java.util.Optional;

import com.bmw.domain.Project;
import com.bmw.repository.ProjectRepository;
import com.bmw.request.ProjectEntity;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/projects")
@Produces("application/json")
@Consumes("application/json")
public class ProjectController {

    @Inject
    ProjectRepository projectRepository;

    @POST
    @Transactional
    public Response createProject(@Valid ProjectEntity project) {
        Project projectInfo = new Project();
        projectInfo.setTitle(project.getTitle());
        projectInfo.setDurationInMonths(project.getDurationInMonths());
        projectRepository.persist(projectInfo);
        return Response.status(201).entity(projectInfo).build();
    }

    @GET
    public List<Project> getProjects() {
        return projectRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Project getSpecificProjectDetails(@PathParam("id") Long projectId) {
        return projectRepository.findById((projectId));
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateProject(@Valid ProjectEntity projectEntity, @PathParam("id") Long projectId) {
        Optional<Project> projectInfo = projectRepository.findByIdOptional(projectId);
        if (projectInfo.isPresent()) {
            Project projectDetails = projectInfo.get();
            projectDetails.setTitle(projectEntity.getTitle());
            projectDetails.setDurationInMonths(projectEntity.getDurationInMonths());
            projectRepository.persist(projectDetails);
            return Response.status(201).entity(projectDetails).build();
        }
        return Response.status(401).build();
        
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteProject(@PathParam("id") Long projectId) {
        Optional<Project> projectInfo = projectRepository.findByIdOptional(projectId);
        if (projectInfo.isPresent()) {
            projectRepository.delete(projectInfo.get());
            return Response.status(204).build();
        }
        return Response.status(401).build();
    }
}
