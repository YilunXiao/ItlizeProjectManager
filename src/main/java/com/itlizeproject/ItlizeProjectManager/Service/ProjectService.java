package com.itlizeproject.ItlizeProjectManager.Service;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;

import java.util.List;

public interface ProjectService {
    Project findOne(Integer id) throws Exception;
    List<Project> findAll();
    Project findName(String projectName) throws Exception;
    Boolean addOne(String projectName) throws Exception;
    Boolean updateName(Integer id, String projectName) throws Exception;
    Boolean deleteOne(Integer id) throws Exception;
    void save(Project project);
}
