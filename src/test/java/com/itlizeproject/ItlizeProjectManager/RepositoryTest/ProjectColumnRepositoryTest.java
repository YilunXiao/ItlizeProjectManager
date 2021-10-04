package com.itlizeproject.ItlizeProjectManager.RepositoryTest;

import com.itlizeproject.ItlizeProjectManager.Entity.ProjectColumn;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectColumnRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectColumnRepositoryTest {

    @Autowired
    private ProjectColumnRepository repository;

    @Test
    public void saveTest() {
        ProjectColumn projectColumn = new ProjectColumn();
        projectColumn.setId(12);
        projectColumn.setColumnName("Test Column");
        projectColumn.setFormulaText("A + B = C");
        projectColumn.setType(ProjectColumn.Type.Text);

        ProjectColumn result = repository.save(projectColumn);
        Assert.assertNotNull(result);
    }

}

