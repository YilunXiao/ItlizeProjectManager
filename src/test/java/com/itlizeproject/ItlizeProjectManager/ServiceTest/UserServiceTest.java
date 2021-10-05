package com.itlizeproject.ItlizeProjectManager.ServiceTest;

import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Repository.UserRepository;
import com.itlizeproject.ItlizeProjectManager.Service.Impl.UserServiceImp;
import com.mysql.cj.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImp userService;

    @Autowired
    private UserRepository repository;

    @Test
    public void findNullTest() {
        int userId = 0;
        User user = userService.findById(userId);
        Assert.assertNull(user);
    }

    @Test
    public void createTest() {
        String username = "Test User";
        String password = "password";
        String email = "email@goog.com";
        User user = userService.create(username, password, email);
        Assert.assertNotNull(user);
    }

    @Test
    public void findTest() {
        Integer userId = 1;
        User user = userService.findById(userId);
        Assert.assertEquals(user.getId(), userId);
    }

    @Test
    public void updateTest() {
        int updateId = 1;
        String name = "updated 2";
        String password = "new pw";
        String email = "newEmail@gog.com";

        userService.updateUserById(updateId, name, password, email);
        User actual = userService.findById(updateId);

        Assert.assertEquals(actual.getUserName(), name);
        Assert.assertEquals(actual.getPassword(), password);
        Assert.assertEquals(actual.getEmail(), email);
    }
}

