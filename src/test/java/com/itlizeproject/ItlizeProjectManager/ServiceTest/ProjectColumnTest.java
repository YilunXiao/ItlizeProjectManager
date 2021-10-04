package com.itlizeproject.ItlizeProjectManager.ServiceTest;

import com.itlizeproject.ItlizeProjectManager.Entity.ProjectColumn;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectColumnRepository;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectColumnService;
import com.mysql.cj.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectColumnTest {
    @Autowired
    private ProjectColumnService service;

    @Test
    public void updateTest() {
        Integer id = 1;
        String columnName = "Test Name";
        String formula = "A + B = Test";
        service.update(id, columnName, formula);

        ProjectColumn actual = service.findById(id);

        Assert.assertEquals(columnName, actual.getColumnName());
        Assert.assertEquals(formula, actual.getFormulaText());
    }
}
