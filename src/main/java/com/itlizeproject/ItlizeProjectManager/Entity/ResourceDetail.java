package com.itlizeproject.ItlizeProjectManager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "resource_detail")
public class ResourceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "project_column_id")
    private ProjectColumn projectColumn;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Integer cost;

    public ResourceDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectColumn getProjectColumn() {
        return projectColumn;
    }

    public Resource getResource() {
        return resource;
    }

    public void setProjectColumn(ProjectColumn projectColumn) {
        this.projectColumn = projectColumn;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
