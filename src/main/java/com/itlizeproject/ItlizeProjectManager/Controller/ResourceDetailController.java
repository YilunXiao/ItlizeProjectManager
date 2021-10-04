package com.itlizeproject.ItlizeProjectManager.Controller;

//import com.itlizeproject.ItlizeProjectManager.Config.LimitConfig;
import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceDetailService;
import com.itlizeproject.ItlizeProjectManager.Service.Impl.UserServiceImp;
import com.itlizeproject.ItlizeProjectManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public List<ResourceDetail> list() {
        return service.findAll();
    }

    // get a ResourceDetail by id
    @GetMapping("/resource_details/resource_detail")
    public ResourceDetail findById(@RequestParam("id") Integer id) {
        return service.findById(id);
    }

    // get all ResourceDetails with projectColumnsId
    @GetMapping("/resource_details/project_column")
    public List<ResourceDetail> findByColumnId(@RequestParam("id") Integer id) {
        return service.findByProjectColumn(id);
    }

    // get all ResourceDetails with resourceId
    @GetMapping("/resource_details/resource")
    public List<ResourceDetail> findByResourceId(@RequestParam("id") Integer id) {
        return service.findByResource(id);
    }

    // create a ResourceDetail
    @PostMapping("/resource_details")
    public ResourceDetail create(@RequestParam("description") String description,
                                 @RequestParam("cost") Integer cost) {
        ResourceDetail resourceDetail = new ResourceDetail();
        resourceDetail.setDescription(description);
        resourceDetail.setCost(cost);
        return service.save(resourceDetail);
    }

    // update a ResourceDetail
    @PutMapping("/resource_details")
    public ResourceDetail update(@RequestParam("id") Integer id,
                                 @RequestParam("description") String description,
                                 @RequestParam("cost") Integer cost) {
        return service.update(id, description, cost);
    }

    // delete a ResourceDetail
    @DeleteMapping("/resource_details")
    public void delete(@RequestParam("id") Integer id) {
        service.deleteById(id);
    }

}
