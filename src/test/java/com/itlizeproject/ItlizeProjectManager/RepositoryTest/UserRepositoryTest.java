package com.itlizeproject.ItlizeProjectManager.RepositoryTest;

import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void saveTest() {
        User user = new User();
        user.setId(123);
        user.setUserName("Test User");
        user.setPassword("abcde");
        user.setEmail("Email@gog.com");

        User result = repository.save(user);
        Assert.assertNotNull(result);
    }

}
