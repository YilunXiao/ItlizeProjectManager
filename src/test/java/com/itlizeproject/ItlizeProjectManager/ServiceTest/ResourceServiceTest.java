package com.itlizeproject.ItlizeProjectManager.ServiceTest;

import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    void testCase0(){
        Boolean result = resourceService.addOne("r0");
        assert(result).equals(true);
    }

    @Test
    void testCase1() throws Exception {
        resourceService.deleteOne(resourceService.findName("r0").getId());
        resourceService.addOne("r1");
        resourceService.addOne("r2");
        resourceService.updateCode(resourceService.findName("r1").getId(),"R404");
        List<Resource> rList = resourceService.findAll();
        Assertions.assertEquals(rList.size(),2);
    }

    @Test
    void testCase2() throws Exception {
        resourceService.addOne("r3");
        resourceService.updateCode(resourceService.findName("r3").getId(),"R101");
        resourceService.updateName(resourceService.findCode("R101").getId(),"r101");
        Resource r1 = resourceService.findOne(resourceService.findCode("R101").getId());
        assert(r1.getName()).equals("r101");
    }

    @Test
    void testCase3() throws Exception {
        resourceService.deleteOne(resourceService.findName("r2").getId());
        resourceService.deleteOne(resourceService.findCode("R404").getId());
        resourceService.deleteOne(resourceService.findName("R101").getId());
        List<Resource> rList = resourceService.findAll();
        Assertions.assertEquals(rList.size(),0);
    }


}
