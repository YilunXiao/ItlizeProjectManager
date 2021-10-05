package com.itlizeproject.ItlizeProjectManager.Controller;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectResourceService;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectService;
import com.itlizeproject.ItlizeProjectManager.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectResourceService projectResourceService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, ProjectResourceService projectResourceService, UserService userServce) {
        this.projectService = projectService;
        this.projectResourceService = projectResourceService;
        this.userService = userServce;
    }

    //Get all projects in database
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> projectList() {
        return new ResponseEntity<> (projectService.findAll(), HttpStatus.OK);
    }

    //Get project by Id
    @GetMapping("/projects/project")
    public ResponseEntity<?> projectById(@RequestParam Integer id) {
        try{
            return new ResponseEntity<> (projectService.findOne(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Update project name by id
    @PutMapping("/projects")
    public ResponseEntity<?> updateProject(@RequestParam Integer id, @RequestParam String name) {
        try {
            projectService.updateName(id, name);
            return new ResponseEntity<>(projectService.findOne(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Create a new project
    @PostMapping("/projects")
    public ResponseEntity<?> addProject(@RequestParam String name) {
        try {
            projectService.addOne(name);
            return new ResponseEntity<>(projectService.findName(name), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //add a resource to a project
    @PostMapping("/addResource")
    public ResponseEntity<?> assignResource(@RequestParam Integer projectId, @RequestParam Integer resourceId) {
        try {
            projectResourceService.addOne(projectId, resourceId);
            Integer id = projectResourceService.findId(projectId, resourceId);
            return new ResponseEntity<>(projectResourceService.findOne(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //delete a project
    @DeleteMapping("/projects")
    public ResponseEntity<?> deleteProject(@RequestParam Integer id) {
        try{
            Project p = projectService.findOne(id);
            projectService.deleteOne(id);
            return new ResponseEntity<> (p, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //remove a resource to a project
    @PostMapping("/removeResource")
    public ResponseEntity<?> removeResource(@RequestParam Integer projectId, @RequestParam Integer resourceId) {
        try {
            Integer id = projectResourceService.findId(projectId, resourceId);
            projectResourceService.deleteOne(id);
            return new ResponseEntity<>("Success.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //assign a project to a user
    @PostMapping("/assignProject")
    public ResponseEntity<?> assignProject(@RequestParam Integer projectId, @RequestParam Integer userId) {
        try {
            Project project = projectService.findOne(projectId);
            User user = userService.findById(userId);
            project.setUser(user);
            projectService.save(project);
            return new ResponseEntity<>(project, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/removeProject")
    public ResponseEntity<?> removeProject(@RequestParam Integer id) {
        try {
            Project project = projectService.findOne(id);
            project.setUser(null);
            projectService.save(project);
            return new ResponseEntity<>(project, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<> (e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
