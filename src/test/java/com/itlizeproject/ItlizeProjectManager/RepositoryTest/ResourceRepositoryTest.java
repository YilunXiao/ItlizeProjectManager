package com.itlizeproject.ItlizeProjectManager.RepositoryTest;

import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceRepositoryTest {

    @Autowired
    private ResourceRepository repository;

    @Test
    public void saveTest() {
        Resource resource = new Resource();
        resource.setId(12);
        resource.setName("Test Resource");
        resource.setResourceCode("C123");

        Resource result = repository.save(resource);
        Assert.assertNotNull(result);
    }

}

