package com.itlizeproject.ItlizeProjectManager.Controller;

import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceDetailService;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ResourceController {

    private final ResourceService resourceService;
    private final ResourceDetailService resourceDetailService;

    public ResourceController(ResourceService resourceService, ResourceDetailService resourceDetailService) {
        this.resourceService = resourceService;
        this.resourceDetailService = resourceDetailService;
    }

    //Get all resources in database
    @GetMapping("/resources")
    public ResponseEntity<List<Resource>> resourceList() {
        return new ResponseEntity<> (resourceService.findAll(), HttpStatus.OK);
    }

    //Get resource by Id
    @GetMapping("/resources/resource")
    public ResponseEntity<Resource> resourceById(@RequestParam Integer id) throws Exception {
        return new ResponseEntity<> (resourceService.findOne(id), HttpStatus.OK);
    }

    //Update resource name and code by id
    @PutMapping("/resources")
    public ResponseEntity<Resource> updateResource(@RequestParam Integer id, @RequestParam String name, @RequestParam String code) throws Exception {
        if(name != null) {
            resourceService.updateName(id, name);
        }
        if(code != null){
            resourceService.updateCode(id, code);
        }
        return new ResponseEntity<> (resourceService.findOne(id), HttpStatus.OK);
    }

    //Create a new resource
    @PostMapping("/resources")
    public ResponseEntity<Resource> addResource(@RequestParam String name) throws Exception {
        resourceService.addOne(name);
        return new ResponseEntity<> (resourceService.findName(name), HttpStatus.OK);
    }

    //delete a resource
    @DeleteMapping("/resources")
    public ResponseEntity<Resource> deleteResource(@RequestParam Integer id) throws Exception {
        Resource r = resourceService.findOne(id);
        resourceService.deleteOne(id);
        return new ResponseEntity<> (r, HttpStatus.OK);
    }

    //add a resource detail to a resource
    @PostMapping("/addDetail")
    public ResponseEntity<ResourceDetail> addDetail(@RequestParam Integer resourceId, @RequestParam Integer detailId) throws Exception {
        Resource resource = resourceService.findOne(resourceId);
        if (resource == null){
            throw new Exception("The resource doesn't exist.");
        }
        ResourceDetail resourceDetail = resourceDetailService.findById(detailId);
        if (resourceDetail == null){
            throw new Exception("The resource detail doesn't exist.");
        }
        //Set<ResourceDetail> list = resource.getResourceDetails();
        //if(list.contains(resourceDetail)){
        //    throw new Exception("The detail has been added to the list.");
        //}else{
        //    list.add(resourceDetail);
        //    resource.setResourceDetails(list);
            resourceDetail.setResource(resource);
        //   resourceService.addDetail(resource);
        //}
        return new ResponseEntity<> (resourceDetail, HttpStatus.OK);
    }

    //add a resource detail to a resource
    @DeleteMapping("/removeDetail")
    public ResponseEntity<ResourceDetail> removeDetail(@RequestParam Integer resourceId, @RequestParam Integer detailId) throws Exception {
        Resource resource = resourceService.findOne(resourceId);
        if (resource == null){
            throw new Exception("The resource doesn't exist.");
        }
        ResourceDetail resourceDetail = resourceDetailService.findById(detailId);
        if (resourceDetail == null){
            throw new Exception("The resource detail doesn't exist.");
        }
        //Set<ResourceDetail> list = resource.getResourceDetails();
        //if(!list.contains(resourceDetail)){
        //    throw new Exception("The detail isn't in the list.");
        //}else{
        //    list.remove(resourceDetail);
        //    resource.setResourceDetails(list);
            resourceDetail.setResource(null);
        //    resourceService.addDetail(resource);
        //}
        return new ResponseEntity<> (resourceDetail, HttpStatus.OK);
    }
}
