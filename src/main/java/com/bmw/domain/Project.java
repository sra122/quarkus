package com.bmw.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Project extends PanacheEntity {
    private Long id;
    @Column(length = 40, unique = true)
    private String title;
    private int durationInMonths;
}
