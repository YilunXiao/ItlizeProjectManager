package com.itlizeproject.ItlizeProjectManager.RepositoryTest;

import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceDetailRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceDetailRepositoryTest {

    @Autowired
    private ResourceDetailRepository repository;

    @Test
    public void saveTest() {
        ResourceDetail resourceDetail = new ResourceDetail();
        resourceDetail.setId(12);
        resourceDetail.setCost(14);
        resourceDetail.setDescription("test resource");


        ResourceDetail result = repository.save(resourceDetail);
        Assert.assertNotNull(result);
    }

}
