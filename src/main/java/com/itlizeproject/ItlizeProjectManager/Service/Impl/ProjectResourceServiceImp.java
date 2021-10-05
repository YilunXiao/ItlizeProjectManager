package com.itlizeproject.ItlizeProjectManager.Service.Impl;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.ProjectResource;
import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectRepository;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectResourceRepository;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceRepository;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectResourceServiceImp implements ProjectResourceService {
    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    public Boolean addOne(Integer projectId, Integer resourceId) throws Exception{

        Project project = projectRepository.findProjectById(projectId);
        Resource resource = resourceRepository.findResourceById(resourceId);
        if (project == null || resource == null) {
            throw new Exception("Project or resource doesn't exist.");
        }
        if (findId(projectId, resourceId) != null){
            throw new Exception("The record exists.");
        }

        ProjectResource pr = new ProjectResource(project,resource);
        //Set<ProjectResource> pList = project.getResources();
        //pList.add(pr);
        //project.setResources(pList);
        //List<ProjectResource> rList = resource.getProjectResources();
        //rList.add(pr);
        //resource.setProjectResources(rList);
        resourceRepository.saveAndFlush(resource);
        projectRepository.saveAndFlush(project);
        projectResourceRepository.saveAndFlush(pr);
        return true;
    }
    public Integer findId(Integer projectId, Integer resourceId) throws Exception{
        Resource resource = resourceRepository.findResourceById(resourceId);
        Project project = projectRepository.findProjectById(projectId);
        if (project == null || resource == null) {
            throw new Exception("Project or resource doesn't exist.");
        }
        ProjectResource pr = projectResourceRepository.findProjectResourceByProjectAndResource(project, resource);
        if (pr == null) {
            return null;
        }else{
            return pr.getId();
        }
    }

    public ProjectResource findOne(Integer id) throws Exception{
        ProjectResource pr = projectResourceRepository.findProjectResourceById(id);
        if(pr == null){
            throw new Exception("No record with the Id.");
        }
        return pr;
    }

    public Boolean updateAmount(Integer projectId, Integer resourceId, Integer amount) throws Exception{
        Integer id = findId(projectId, resourceId);
        if (id == null){
            throw new Exception("The record doesn't exists.");
        }
        ProjectResource pr = projectResourceRepository.findProjectResourceById(id);
        pr.setResourceAmount(amount);
        projectResourceRepository.save(pr);
        return true;
    }
    public Boolean deleteOne(Integer id) throws Exception{
        ProjectResource pr = projectResourceRepository.findProjectResourceById(id);
        if (pr == null){
            throw new Exception ("Failed. The project-resource relation doesn't exist.");
        }

        //Project project = pr.getProject();
        //Resource resource = pr.getResource();
        //List<ProjectResource> pList = project.getResources();
        //pList.remove(pr);
        //project.setResources(pList);
        //List<ProjectResource> rList = resource.getProjectResources();
        //rList.remove(pr);
        //resource.setProjectResources(rList);
        //resourceRepository.save(resource);
        //projectRepository.save(project);
        projectResourceRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ProjectResource> findByProject (Project project) throws Exception {
        if(project == null)
            throw new Exception("The project doesn't exist.");
        return projectResourceRepository.findProjectResourcesByProject(project);
    }

}
