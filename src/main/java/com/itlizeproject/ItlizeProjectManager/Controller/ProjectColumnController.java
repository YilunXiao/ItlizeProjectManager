package com.itlizeproject.ItlizeProjectManager.Controller;

//import com.itlizeproject.ItlizeProjectManager.Config.LimitConfig;
import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.ProjectColumn;
import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectColumnService;
import com.itlizeproject.ItlizeProjectManager.Service.UserService;
import com.itlizeproject.ItlizeProjectManager.Service.Impl.UserServiceImp;
import com.itlizeproject.ItlizeProjectManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
//import sun.misc.Request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ProjectColumnController {

    @Autowired
    private ProjectColumnService service;

    // get all ProjectColumns
    @GetMapping("/project_columns")
    public List<ProjectColumn> list() {
        return service.findAll();
    }

    // get a ProjectColumn by id
    @GetMapping("/project_columns/project_column")
    public ProjectColumn findById(@RequestParam("id") Integer id) {
        return service.findById(id);
    }

    // get all ProjectColumns with projectId
    @GetMapping("/project_columns/project")
    public List<ProjectColumn> findByProjectId(@RequestParam("id") Integer id) {
        return service.findByProjectId(id);
    }

    // create a ProjectColumn
    @PostMapping("/project_columns")
    public ProjectColumn create(@RequestParam("name") String name,
                                @RequestParam("type") ProjectColumn.Type type) {
        ProjectColumn projectColumn = new ProjectColumn();
        projectColumn.setColumnName(name);
        projectColumn.setType(type);

        return service.save(projectColumn);
    }

    // update a ProjectColumn
    @PutMapping("/project_columns")
    public ProjectColumn update(@RequestParam("id") Integer id,
                                @RequestParam("name") String name,
                                @RequestParam("formula") String formula) {
        return service.update(id, name, formula);
    }

    // delete a ProjectColumn
    @DeleteMapping("/project_columns")
    public void delete(@RequestParam("id") Integer id) {
        service.deleteById(id);
    }
}
