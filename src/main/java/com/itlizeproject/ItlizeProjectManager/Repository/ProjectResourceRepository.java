package com.itlizeproject.ItlizeProjectManager.Repository;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.ProjectResource;
import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer> {
    ProjectResource findProjectResourceById(Integer id);
    ProjectResource findProjectResourceByProjectAndResource(Project project, Resource resource);
    List<ProjectResource> findProjectResourcesByProject(Project project);
    List<ProjectResource> findProjectResourcesByResource(Resource resource);
}
