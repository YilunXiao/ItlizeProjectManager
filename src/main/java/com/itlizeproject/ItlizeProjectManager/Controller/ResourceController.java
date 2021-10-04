package com.itlizeproject.ItlizeProjectManager.Controller;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectService;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    //Get all resources in database
    @GetMapping("/resources")
    public ResponseEntity<List<Resource>> resourceList() {
        return new ResponseEntity<> (resourceService.findAll(), HttpStatus.OK);
    }

    //Get resource by Id
    @GetMapping("/resources/")
    public ResponseEntity<Resource> resourceById(@RequestParam Integer id) throws Exception {
        return new ResponseEntity<> (resourceService.findOne(id), HttpStatus.OK);
    }

    //Update resource name and code by id
    @PutMapping("/updateResource/")
    public ResponseEntity<Resource> updateResource(@RequestParam Integer id, @RequestParam String name, @RequestParam String code) throws Exception {
        if(name != null) {
            resourceService.updateName(id, name);
        }
        if(code != null){
            resourceService.updateCode(id, name);
        }
        return new ResponseEntity<> (resourceService.findOne(id), HttpStatus.OK);
    }

    //Create a new project
    @PostMapping("/addResource")
    public ResponseEntity<Resource> addResource(@RequestParam String name) throws Exception {
        resourceService.addOne(name);
        return new ResponseEntity<> (resourceService.findName(name), HttpStatus.OK);
    }

    //add a resource detail to a resource

}
