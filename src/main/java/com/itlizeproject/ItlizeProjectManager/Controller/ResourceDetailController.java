package com.itlizeproject.ItlizeProjectManager.Controller;

//import com.itlizeproject.ItlizeProjectManager.Config.LimitConfig;
import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import sun.misc.Request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ResourceDetailController {

    @Autowired
    private ResourceDetailService service;

    // get all ResourceDetails
    @GetMapping("/resource_details")
    public ResponseEntity<List<ResourceDetail>> list() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // get a ResourceDetail by id
    @GetMapping("/resource_details/resource_detail")
    public ResponseEntity<ResourceDetail> findById(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    // get all ResourceDetails with projectColumnsId
    @GetMapping("/resource_details/project_column")
    public ResponseEntity<List<ResourceDetail>> findByColumnId(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(service.findByProjectColumn(id), HttpStatus.OK);
    }

    // get all ResourceDetails with resourceId
    @GetMapping("/resource_details/resource")
    public ResponseEntity<List<ResourceDetail>> findByResourceId(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(service.findByResource(id), HttpStatus.OK);
    }

    // create a ResourceDetail
    @PostMapping("/resource_details")
    public ResponseEntity<ResourceDetail> create(@RequestParam("description") String description,
                                 @RequestParam("cost") Integer cost) {
        ResourceDetail resourceDetail = new ResourceDetail();
        resourceDetail.setDescription(description);
        resourceDetail.setCost(cost);
        return new ResponseEntity<>(service.save(resourceDetail), HttpStatus.OK);
    }

    // update a ResourceDetail
    @PutMapping("/resource_details")
    public ResponseEntity<ResourceDetail> update(@RequestParam("id") Integer id,
                                 @RequestParam("description") String description,
                                 @RequestParam("cost") Integer cost) {
        return new ResponseEntity<>(service.update(id, description, cost), HttpStatus.OK);
    }

    // delete a ResourceDetail
    @DeleteMapping("/resource_details")
    public void delete(@RequestParam("id") Integer id) {
        service.deleteById(id);
    }

}
