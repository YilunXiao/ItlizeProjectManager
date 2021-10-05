package com.itlizeproject.ItlizeProjectManager.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "time_created")
    @DateTimeFormat(pattern = "MM/DD/YYYY")
    private Date timeCreated;

    @Column(name = "time_modified")
    @DateTimeFormat(pattern = "MM/DD/YYYY")
    private Date timeModified;


    //@OneToMany(
            //fetch = FetchType.LAZY,
            //mappedBy = "project",
            //cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    //private Set<ProjectResource> resources;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "project",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<ProjectColumn> columns;

    public Project() {
    }

    public Project(String projectName) {
        this.name = projectName;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Date timeModified) {
        this.timeModified = timeModified;
    }

    public Set<ProjectColumn> getColumns() {
        return columns;
    }

    //public Set<ProjectResource> getResources() {
    //    return resources;
    //}

    //public void setResources(Set<ProjectResource> resources) {
    //    this.resources = resources;
    //}

    public void setColumns(Set<ProjectColumn> columns) {
        this.columns = columns;
    }
}

