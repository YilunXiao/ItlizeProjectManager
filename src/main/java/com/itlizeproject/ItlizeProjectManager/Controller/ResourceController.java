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
    public ResponseEntity<?> resourceById(@RequestParam Integer id) {
        try {
            return new ResponseEntity<>(resourceService.findOne(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Update resource name and code by id
    @PutMapping("/resources")
    public ResponseEntity<?> updateResource(@RequestParam Integer id, @RequestParam String name, @RequestParam String code) {
        try {
            if (name != null) {
                resourceService.updateName(id, name);
            }
            if (code != null) {
                resourceService.updateCode(id, code);
            }
            return new ResponseEntity<>(resourceService.findOne(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Create a new resource
    @PostMapping("/resources")
    public ResponseEntity<?> addResource(@RequestParam String name) {
        try {
            resourceService.addOne(name);
            return new ResponseEntity<>(resourceService.findName(name), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //delete a resource
    @DeleteMapping("/resources")
    public ResponseEntity<?> deleteResource(@RequestParam Integer id) {
        try {
            Resource r = resourceService.findOne(id);
            resourceService.deleteOne(id);
            return new ResponseEntity<>(r, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //add a resource detail to a resource
    @PostMapping("/addDetail")
    public ResponseEntity<?> addDetail(@RequestParam Integer resourceId, @RequestParam Integer detailId) {
        try {
            Resource resource = resourceService.findOne(resourceId);
            ResourceDetail resourceDetail = resourceDetailService.findById(detailId);

            //Set<ResourceDetail> list = resource.getResourceDetails();
            //if(list.contains(resourceDetail)){
            //    throw new Exception("The detail has been added to the list.");
            //}else{
            //    list.add(resourceDetail);
            //    resource.setResourceDetails(list);
            resourceDetail.setResource(resource);
            //   resourceService.addDetail(resource);
            //}
            resourceDetailService.save(resourceDetail);
            return new ResponseEntity<>(resourceDetail, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //add a resource detail to a resource
    @PostMapping("/removeDetail")
    public ResponseEntity<?> removeDetail(@RequestParam Integer id) {
        try {
            ResourceDetail resourceDetail = resourceDetailService.findById(id);
            //Set<ResourceDetail> list = resource.getResourceDetails();
            //if(!list.contains(resourceDetail)){
            //    throw new Exception("The detail isn't in the list.");
            //}else{
            //    list.remove(resourceDetail);
            //    resource.setResourceDetails(list);
            resourceDetail.setResource(null);
            resourceDetailService.save(resourceDetail);
            //    resourceService.addDetail(resource);
            //}
            return new ResponseEntity<>(resourceDetail, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
