package com.bmw.repository;

import com.bmw.domain.Project;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjectRepository implements PanacheRepositoryBase<Project, Long> {
    
}
