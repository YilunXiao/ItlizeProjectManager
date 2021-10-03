package com.itlizeproject.ItlizeProjectManager.Service.Impl;

import com.itlizeproject.ItlizeProjectManager.Entity.ProjectColumn;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectColumnRepository;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectColumnServiceImp implements ProjectColumnService {
    @Autowired
    private ProjectColumnRepository repository;

    @Override
    public ProjectColumn findById(Integer Id) {
        return repository.getById(Id);
    }

    @Override
    public List<ProjectColumn> findByProjectId(Integer projectId) {
        return null;
        // return repository.findByProjectId(projectId);
    }

    @Override
    public List<ProjectColumn> findAll() {
        return repository.findAll();
    }

    @Override
    public ProjectColumn save(ProjectColumn projectColumn) {
        return repository.save(projectColumn);
    }
}
