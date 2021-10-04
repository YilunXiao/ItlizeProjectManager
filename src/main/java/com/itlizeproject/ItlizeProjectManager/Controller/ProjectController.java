package com.itlizeproject.ItlizeProjectManager.Controller;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.ProjectResource;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectResourceService;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectResourceService projectResourceService;

    public ProjectController(ProjectService projectService, ProjectResourceService projectResourceService) {
        this.projectService = projectService;
        this.projectResourceService = projectResourceService;
    }

    //Get all projects in database
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> projectList() {
        return new ResponseEntity<> (projectService.findAll(), HttpStatus.OK);
    }

    //Get project by Id
    @GetMapping("/projects/project")
    public ResponseEntity<Project> projectById(@RequestParam Integer id) throws Exception {
        return new ResponseEntity<> (projectService.findOne(id), HttpStatus.OK);
    }

    //Update project name by id
    @PutMapping("/projects")
    public ResponseEntity<Project> updateProject(@RequestParam Integer id, @RequestParam String name) throws Exception {
        projectService.updateName(id, name);
        return new ResponseEntity<> (projectService.findOne(id), HttpStatus.OK);
    }

    //Create a new project
    @PostMapping("/projects")
    public ResponseEntity<Project> addProject(@RequestParam String name) throws Exception {
        projectService.addOne(name);
        return new ResponseEntity<> (projectService.findName(name), HttpStatus.OK);
    }

    //add a resource to a project
    @PostMapping("/addResource")
    public ResponseEntity<ProjectResource> assignResource(@RequestParam Integer projectId, @RequestParam Integer resourceId) throws Exception {
        projectResourceService.addOne(projectId, resourceId);
        Integer id = projectResourceService.findId(projectId, resourceId);
        return new ResponseEntity<> (projectResourceService.findOne(id), HttpStatus.OK);
    }

    //delete a project
    @DeleteMapping("/projects")
    public ResponseEntity<Project> deleteProject(@RequestParam Integer id) throws Exception {
        Project p = projectService.findOne(id);
        projectService.deleteOne(id);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }

    //remove a resource to a project
    @DeleteMapping("/removeResource")
    public void removeResource(@RequestParam Integer projectId, @RequestParam Integer resourceId) throws Exception {
        Integer id = projectResourceService.findId(projectId, resourceId);
        projectResourceService.deleteOne(id);
        //return new ResponseEntity<> (projectResourceService.findOne(id), HttpStatus.OK);
    }
}
