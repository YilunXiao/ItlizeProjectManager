package com.itlizeproject.ItlizeProjectManager.RepositoryTest;

import com.itlizeproject.ItlizeProjectManager.Entity.ProjectResource;
import com.itlizeproject.ItlizeProjectManager.Repository.ProjectResourceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectResourceRepositoryTest {

    @Autowired
    private ProjectResourceRepository repository;

    @Test
    public void saveTest() {
        ProjectResource projectResource = new ProjectResource();
        projectResource.setId(12);
        projectResource.setResourceAmount(100);

        ProjectResource result = repository.save(projectResource);
        Assert.assertNotNull(result);
    }

}

