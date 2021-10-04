package com.itlizeproject.ItlizeProjectManager.Service.Impl;

import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceDetailRepository;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceDetailServiceImp implements ResourceDetailService {
    @Autowired
    private ResourceDetailRepository repository;

    @Override
    public ResourceDetail findById(Integer Id) {
        return repository.findById(Id).orElse(null);
    }

    @Override
    public List<ResourceDetail> findAll() {
        return repository.findAll();
    }

    //TODO
    @Override
    public List<ResourceDetail> findByResource(Integer resourceId) {
        // return repository.findByResourceId(resourceId);
        return null;
    }
    //TODO
    @Override
    public List<ResourceDetail> findByProjectColumn(Integer projectColumnId) {
        // return repository.findByProjectColumnId(projectColumnId);
        return null;
    }

    @Override
    public ResourceDetail save(ResourceDetail resourceDetail) {
        return repository.save(resourceDetail);
    }
}