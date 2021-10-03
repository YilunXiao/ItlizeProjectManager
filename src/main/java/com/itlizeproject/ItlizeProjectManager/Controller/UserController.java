package com.itlizeproject.ItlizeProjectManager.Controller;

//import com.itlizeproject.ItlizeProjectManager.Config.LimitConfig;
import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Service.UserService;
import com.itlizeproject.ItlizeProjectManager.Service.Impl.UserServiceImp;
import com.itlizeproject.ItlizeProjectManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
//import sun.misc.Request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    // get all users from database
    @GetMapping("/users")
    public List<User> list() {
        return service.findAll();
    }

    // get one user by id
    @GetMapping("/users/")
    public User findById(@RequestParam("id") Integer id) {
        return service.findById(id);
    }

    // create a user
    @PostMapping("/users")
    public User create(@RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        return service.save(user);
    }


    // update a user
    @PutMapping("/users")
    public User update(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password) {
        return service.updateUserById(id, name, password, email);
    }
}
