package com.itlizeproject.ItlizeProjectManager.Service;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.ProjectResource;

import java.util.List;

public interface ProjectResourceService {
    Boolean addOne(Integer projectId, Integer resourceId) throws Exception;
    Integer findId(Integer projectId, Integer resourceId) throws Exception;
    ProjectResource findOne(Integer Id) throws Exception;
    Boolean updateAmount(Integer projectId, Integer resourceId, Integer amount) throws Exception;
    Boolean deleteOne(Integer id) throws Exception;
    List<ProjectResource> findByProject (Project project) throws Exception;
}
