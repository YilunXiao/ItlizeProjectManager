package com.itlizeproject.ItlizeProjectManager.ServiceTest;

import com.itlizeproject.ItlizeProjectManager.Service.ProjectResourceService;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectService;
import com.itlizeproject.ItlizeProjectManager.Service.ResourceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProjectResourceServiceTest {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ProjectResourceService projectResourceService;

    //@Test
    //void testCase0() throws Exception {
    //    projectService.addOne("p1");
    //    projectService.addOne("p2");
    //    resourceService.addOne("r101");
    //    resourceService.addOne("r102");
    //    resourceService.addOne("r201");
    //    Integer pId = projectService.findName("p2").getId();
    //    Integer rId = resourceService.findName("r201").get(0).getId();
    //    Boolean result = projectResourceService.addOne(pId,rId);
    //    assert(result).equals(true);
    //}

    //@Test
    //void testCase1() throws Exception {
    //    projectResourceService.addOne(projectService.findName("p1").getId(),resourceService.findName("r101").get(0).getId());
    //    projectResourceService.addOne(projectService.findName("p1").getId(),resourceService.findName("r102").get(0).getId());
    //    Integer id = projectResourceService.findId(projectService.findName("p1").getId(),resourceService.findName("r101").get(0).getId());
    //    projectResourceService.updateAmount(projectService.findName("p1").getId(),resourceService.findName("r101").get(0).getId(),1000);
    //    Assertions.assertEquals(projectResourceService.findOne(id).getResourceAmount(),1000);
    //}

    //@Test
    //void testCase2() throws Exception {
    //    Boolean result = projectResourceService.deleteOne(projectResourceService.findId(projectService.findName("p1").getId(),resourceService.findName("r101").get(0).getId()));
    //    assert(result).equals(true);
    //}

    //@Test
    //void testCase3() throws Exception {
    //    Boolean result = projectResourceService.deleteOne(projectResourceService.findId(projectService.findName("p2").getId(),resourceService.findName("r201").get(0).getId()));
    //    projectResourceService.deleteOne(projectResourceService.findId(projectService.findName("p1").getId(),resourceService.findName("r102").get(0).getId()));
    //    resourceService.deleteOne(resourceService.findName("r101").get(0).getId());
    //    resourceService.deleteOne(resourceService.findName("r102").get(0).getId());
    //    resourceService.deleteOne(resourceService.findName("r201").get(0).getId());
    //    projectService.deleteOne(projectService.findName("p1").getId());
    //    projectService.deleteOne(projectService.findName("p2").getId());
    //    assert(result).equals(true);
    //}
}
