package com.itlizeproject.ItlizeProjectManager.ServiceTest;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import com.itlizeproject.ItlizeProjectManager.Service.ProjectService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Test
    void testCase0(){
        Boolean result = projectService.addOne("p0");
        assert(result).equals(true);
    }

    @Test
    void testCase1() throws Exception {
        projectService.deleteOne(projectService.findName("p0").getId());
        projectService.addOne("p1");
        projectService.addOne("p2");
        List<Project> pList = projectService.findAll();
        Assertions.assertEquals(pList.size(),2);
    }

    @Test
    void testCase2() throws Exception {
        projectService.addOne("p3");
        projectService.updateName(projectService.findName("p3").getId(),"P1001");
        Project r1 = projectService.findOne(projectService.findName("P1001").getId());
        assert(r1.getName()).equals("P1001");
    }

    @Test
    void testCase3() throws Exception {
        projectService.deleteOne(projectService.findName("p1").getId());
        projectService.deleteOne(projectService.findName("p2").getId());
        projectService.deleteOne(projectService.findName("P1001").getId());
        List<Project> rList = projectService.findAll();
        Assertions.assertEquals(rList.size(),0);
    }


}
