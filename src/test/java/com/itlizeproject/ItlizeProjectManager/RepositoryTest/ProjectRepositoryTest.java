package com.itlizeproject.ItlizeProjectManager.RepositoryTest;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository repository;

    @Test
    public void saveTest() {
        Project project = new Project();
        project.setId(12);
        Date now = new Date(System.currentTimeMillis());
        project.setTimeCreated(now);
        project.setName("Test Project");

        Project result = repository.save(project);
        Assert.assertNotNull(result);
    }

}
