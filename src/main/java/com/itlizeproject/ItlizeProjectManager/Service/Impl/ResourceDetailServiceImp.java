package com.itlizeproject.ItlizeProjectManager.Service.Impl;

import com.itlizeproject.ItlizeProjectManager.Entity.ProjectColumn;
import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectColumnRepository;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceDetailRepository;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceRepository;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceDetailServiceImp implements ResourceDetailService {
    @Autowired
    private ResourceDetailRepository repository;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ProjectColumnRepository projectColumnRepository;

    @Override
    public ResourceDetail findById(Integer Id) {
        return repository.findById(Id).orElse(null);
    }

    @Override
    public List<ResourceDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public ResourceDetail assignResource(Integer resourceDetailId, Integer resourceId) {
        ResourceDetail resourceDetail = repository.getById(resourceDetailId);
        Resource resource = resourceRepository.getById(resourceId);
        resourceDetail.setResource(resource);
        return repository.save(resourceDetail);
    }

    @Override
    public ResourceDetail assignProjectColumn(Integer resourceDetailId, Integer projectColumnId) {
        ResourceDetail resourceDetail = repository.getById(resourceDetailId);
        ProjectColumn projectColumn = projectColumnRepository.getById(projectColumnId);
        resourceDetail.setProjectColumn(projectColumn);
        return repository.save(resourceDetail);
    }

    @Override
    public List<ResourceDetail> findByResource(Integer resourceId) {
        return repository.findResourceDetailByResourceId(resourceId);
    }

    @Override
    public List<ResourceDetail> findByProjectColumn(Integer projectColumnId) {
        return repository.findResourceDetailByProjectColumnId(projectColumnId);
    }

    @Override
    public ResourceDetail update(Integer id, String description, Integer cost) {
        ResourceDetail resourceDetail = repository.findById(id).orElse(null);
        resourceDetail.setDescription(description);
        resourceDetail.setCost(cost);
        return repository.save(resourceDetail);
    }


    @Override
    public ResourceDetail save(ResourceDetail resourceDetail) {
        return repository.save(resourceDetail);
    }

    @Override
    public ResourceDetail create(String description, Integer cost) {
        ResourceDetail resourceDetail = new ResourceDetail();
        resourceDetail.setDescription(description);
        resourceDetail.setCost(cost);
        return repository.save(resourceDetail);
    }

    @Override
    public void delete(ResourceDetail resourceDetail) {
        repository.delete(resourceDetail);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}