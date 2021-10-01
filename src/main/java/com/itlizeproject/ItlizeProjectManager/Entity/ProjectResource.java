package com.itlizeproject.ItlizeProjectManager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "project_resource")
public class ProjectResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Column(name = "resource_amount")
    private Integer resourceAmount;

    public ProjectResource() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourceAmount() {
        return resourceAmount;
    }

    public void setResourceAmount(Integer resourceAmount) {
        this.resourceAmount = resourceAmount;
    }

    public Project getProject() {
        return project;
    }

    public Resource getResource() {
        return resource;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }



}
