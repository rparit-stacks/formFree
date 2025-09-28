package com.form.free.formfree.model;

import jakarta.persistence.*;

@Entity
public class FromSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long projectId;

    @Lob
    private String submissions;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getSubmissions() {
        return submissions;
    }

    public void setSubmissions(String submissions) {
        this.submissions = submissions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
