package com.itlizeproject.ItlizeProjectManager.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "time_created")
    private Date timeCreated;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "project",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ProjectResource> resources;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "project",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ProjectColumn> columns;

    public Project() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = user;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public List<ProjectResource> getResources() {
        return resources;
    }

    public List<ProjectColumn> getColumns() {
        return columns;
    }


    public void setResources(List<ProjectResource> resources) {
        this.resources = resources;
    }

    public void setColumns(List<ProjectColumn> columns) {
        this.columns = columns;
    }
}

