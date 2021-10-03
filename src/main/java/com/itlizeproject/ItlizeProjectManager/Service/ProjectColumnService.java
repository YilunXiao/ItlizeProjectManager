package com.itlizeproject.ItlizeProjectManager.Service;

import com.itlizeproject.ItlizeProjectManager.Entity.ProjectColumn;

import java.util.List;

public interface ProjectColumnService {
    public ProjectColumn findById(Integer Id);
    List<ProjectColumn> findByProjectId(Integer projectId);
    List<ProjectColumn> findAll();
    public ProjectColumn save(ProjectColumn projectColumn);
}
