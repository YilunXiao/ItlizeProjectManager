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
        return repository.findById(Id).orElse(null);
    }

    @Override
    public List<ProjectColumn> findByProjectId(Integer projectId) {
        return repository.findProjectColumnsByProjectId(projectId);
    }

    @Override
    public List<ProjectColumn> findAll() {
        return repository.findAll();
    }

    @Override
    public ProjectColumn update(Integer id, String columnName, String formula) {
        ProjectColumn projectColumn = repository.findById(id).orElse(null);
        projectColumn.setColumnName(columnName);
        projectColumn.setFormulaText(formula);
        return repository.save(projectColumn);
    }

    @Override
    public ProjectColumn save(ProjectColumn projectColumn) {
        return repository.save(projectColumn);
    }

    @Override
    public ProjectColumn create(String columnName, String formulaText, ProjectColumn.Type type) {
        ProjectColumn projectColumn = new ProjectColumn();
        projectColumn.setColumnName(columnName);
        projectColumn.setFormulaText(formulaText);
        projectColumn.setType(type);
        return repository.save(projectColumn);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
