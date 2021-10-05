package com.itlizeproject.ItlizeProjectManager.Controller;

//import com.itlizeproject.ItlizeProjectManager.Config.LimitConfig;
import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Service.UserService;
import com.itlizeproject.ItlizeProjectManager.Service.Impl.UserServiceImp;
import com.itlizeproject.ItlizeProjectManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> list() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // get one user by id
    @GetMapping("/users/user")
    public ResponseEntity<User> findById(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    // create a user
    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password) {
        return new ResponseEntity<>(service.create(name, password, email), HttpStatus.OK);
    }


    // update a user
    @PutMapping("/users")
    public ResponseEntity<User> update(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password) {
        return new ResponseEntity<>(service.updateUserById(id, name, password, email), HttpStatus.OK);
    }

    // delete a user
    @DeleteMapping("/users")
    public void deleteById(@RequestParam("id") Integer id) {
        service.deleteById(id);
    }
}
