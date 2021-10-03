package com.itlizeproject.ItlizeProjectManager.Repository;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.ProjectColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Integer>{
    ProjectColumn findProjectColumnById(Integer id);
    ProjectColumn findProjectColumnByProjectId(Integer id);
    ProjectColumn findProjectColumnByProject(Project project);
}
