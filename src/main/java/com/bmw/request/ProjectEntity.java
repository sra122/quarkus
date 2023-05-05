package com.bmw.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProjectEntity {
    @Column(length = 40, unique = true)
    private String title;
    private int durationInMonths;
}
