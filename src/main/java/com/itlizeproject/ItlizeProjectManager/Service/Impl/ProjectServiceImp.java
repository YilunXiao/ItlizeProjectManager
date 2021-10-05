package com.itlizeproject.ItlizeProjectManager.Service.Impl;


import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectRepository;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project findOne(Integer id) throws Exception {
        Project project = projectRepository.findProjectById(id);
        if (project == null) {
            throw new Exception("No project found by id " + id);
        }
        return project;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findName(String projectName) throws Exception {
        Project project = projectRepository.findProjectByName(projectName);
        if (project == null) {
            throw new Exception("No project found by name " + projectName);
        }
        return project;
    }

    @Override
    public Boolean addOne(String projectName) throws Exception {
        if (projectRepository.findProjectByName(projectName) != null)
            throw new Exception("The project name already exists.");
        Project newProject = new Project(projectName);
        newProject.setTimeCreated(new Date());
        newProject.setTimeModified(new Date());
        projectRepository.saveAndFlush(newProject);
        return true;
    }

    @Override
    public Boolean updateName(Integer id, String projectName) throws Exception {
        Project project = projectRepository.findProjectById(id);
        if (project == null) {
            throw new Exception("The project doesn't exist.");
        }
        project.setName(projectName);
        project.setTimeModified(new Date());
        projectRepository.saveAndFlush(project);
        return true;
    }

    @Override
    public Boolean deleteOne(Integer id) throws Exception {
        Project project = projectRepository.findProjectById(id);
        if (project == null)
            throw new Exception("The project doesn't exist.");
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public void save(Project project){projectRepository.save(project);}
}
