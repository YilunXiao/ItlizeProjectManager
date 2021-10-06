package com.itlizeproject.ItlizeProjectManager.Service.Impl;

import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceDetailRepository;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceRepository;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ResourceServiceImp implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceDetailRepository resourceDetailRepository;

    @Override
    public Resource findOne(Integer id) throws Exception{
        Resource resource = resourceRepository.findResourceById(id);
        if (resource == null){
            throw new Exception ("No resource found by id " + id);
        }
        return resource;
    }

    @Override
    public List<Resource> findAll(){
        return resourceRepository.findAll();
    }

    @Override
    public List<Resource> findName(String resourceName) throws Exception{
        List<Resource> resources = resourceRepository.findResourcesByName(resourceName);
        if (resources == null){
            throw new Exception ("No resource found by name " + resourceName);
        }
        return resources;
    }

    @Override
    public List<Resource> findCode(String resourceCode) throws Exception{
        List<Resource> resources = resourceRepository.findResourcesByResourceCode(resourceCode);
        if (resources == null){
            throw new Exception ("No resource found by code " + resourceCode);
        }
        return resources;
    }

    @Override
    public Boolean addOne(String resourceName){
        Resource newResource = new Resource(resourceName);
        resourceRepository.saveAndFlush(newResource);
        return true;
    }

    @Override
    public Boolean updateName(Integer id, String resourceName) throws Exception{
        Resource resource = resourceRepository.findResourceById(id);
        if (resource == null){
            throw new Exception ("The resource doesn't exist.");
        }
        resource.setName(resourceName);
        resourceRepository.saveAndFlush(resource);
        return true;
    }

    @Override
    public Boolean updateCode(Integer id, String resourceCode) throws Exception{
        Resource resource = resourceRepository.findResourceById(id);
        if (resource == null){
            throw new Exception ("The resource doesn't exist.");
        }
        resource.setResourceCode(resourceCode);
        resourceRepository.saveAndFlush(resource);
        return true;
    }

    @Override
    public Boolean deleteOne(Integer id) throws Exception{
        Resource resource = resourceRepository.findResourceById(id);
        if (resource == null){
            throw new Exception ("Failed. The resource doesn't exist.");
        }
        resourceRepository.deleteById(id);
        return true;
    }

    @Override
    public void addDetail(Resource resource){
        resourceRepository.save(resource);
    }

    //@Override
    //public Boolean removeDetail(Integer resourceId, Integer resourceDetailId) throws Exception{
        //Resource resource = resourceRepository.findResourceById(resourceId);
        //ResourceDetail resourceDetail = resourceDetailRepository.findById(resourceDetailId).orElse(null);
        //if (resource == null){
        //    throw new Exception("The resource doesn't exist.");
        //}
        //if (resourceDetail == null){
        //    throw new Exception("The resource detail doesn't exist.");
        //}
        //Set<ResourceDetail> list = resource.getResourceDetails();
        //if(list.contains(resourceDetail)){
        //    list.remove(resourceDetail);
        //resource.setResourceDetails(list);
         //   resourceRepository.save(resource);
        //}else{
        //    throw new Exception("The detail has been added to the list.");
        //}
        //return true;
    //}
}
