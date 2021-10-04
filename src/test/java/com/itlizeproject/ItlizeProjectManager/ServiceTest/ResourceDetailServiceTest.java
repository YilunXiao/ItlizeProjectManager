package com.itlizeproject.ItlizeProjectManager.ServiceTest;

import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import com.itlizeproject.ItlizeProjectManager.Repository.ResourceDetailRepository;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceDetailService;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceDetailService;
import com.mysql.cj.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceDetailServiceTest {
    @Autowired
    private ResourceDetailService service;

    @Test
    public void updateTest() {
        Integer id = 1;
        String description = "Description updated by test";
        Integer cost = 100;
        service.update(id, description, cost);

        ResourceDetail actual = service.findById(id);

        Assert.assertEquals(cost, actual.getCost());
        Assert.assertEquals(description, actual.getDescription());
    }
}
