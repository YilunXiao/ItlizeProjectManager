package com.itlizeproject.ItlizeProjectManager.Controller;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //Get all projects in database
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> projectList() {
        return new ResponseEntity<> (projectService.findAll(), HttpStatus.OK);
    }

    //Get project by Id
    @GetMapping("/projects/")
    public ResponseEntity<Project> projectById(@RequestParam Integer id) throws Exception {
        return new ResponseEntity<> (projectService.findOne(id), HttpStatus.OK);
    }

    //Update project name by id
    @PutMapping("/updateProject/")
    public ResponseEntity<Project> updateProject(@RequestParam Integer id, @RequestParam String name) throws Exception {
        projectService.updateName(id, name);
        return new ResponseEntity<> (projectService.findOne(id), HttpStatus.OK);
    }

    //Create a new project
    @PostMapping("/addProject")
    public ResponseEntity<Project> addProject(@RequestParam String name) throws Exception {
        projectService.addOne(name);
        return new ResponseEntity<> (projectService.findName(name), HttpStatus.OK);
    }

    //add a resource to a project

}
