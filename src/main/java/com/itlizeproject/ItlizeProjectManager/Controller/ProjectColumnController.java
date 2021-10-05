package com.itlizeproject.ItlizeProjectManager.Controller;

//import com.itlizeproject.ItlizeProjectManager.Config.LimitConfig;
import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.ProjectColumn;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
//import sun.misc.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@RestController
public class ProjectColumnController {

    @Autowired
    private ProjectColumnService service;

    // get all ProjectColumns
    @GetMapping("/project_columns")
    public ResponseEntity<List<ProjectColumn>> list() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // get a ProjectColumn by id
    @GetMapping("/project_columns/project_column")
    public ResponseEntity<ProjectColumn> findById(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    // get all ProjectColumns with projectId
    @GetMapping("/project_columns/project")
    public ResponseEntity<List<ProjectColumn>> findByProjectId(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(service.findByProjectId(id), HttpStatus.OK);
    }

    // create a ProjectColumn
    @PostMapping("/project_columns")
    public ResponseEntity<ProjectColumn> create(@RequestParam("name") String name,
                                @RequestParam("formula") String formula,
                                @RequestParam("type") ProjectColumn.Type type) {
        return new ResponseEntity<>(service.create(name, formula, type), HttpStatus.OK);
    }

    // update a ProjectColumn
    @PutMapping("/project_columns")
    public ResponseEntity<ProjectColumn> update(@RequestParam("id") Integer id,
                                @RequestParam("name") String name,
                                @RequestParam("formula") String formula) {
        return new ResponseEntity<>(service.update(id, name, formula), HttpStatus.OK);
    }

    // delete a ProjectColumn
    @DeleteMapping("/project_columns")
    public void delete(@RequestParam("id") Integer id) {
        service.deleteById(id);
    }
}
