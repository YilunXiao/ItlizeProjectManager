package com.itlizeproject.ItlizeProjectManager.Service.Impl;

import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Repository.UserRepository;
import com.itlizeproject.ItlizeProjectManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer Id) {
        return repository.findById(Id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User updateUserById(Integer id, String name, String password, String email) {
        User user = findById(id);
        user.setUserName(name);
        user.setPassword(password);
        user.setEmail(email);
        repository.save(user);
        return user;
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User create(String name, String password, String email) {
        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setTimeCreated(new Date());
        return repository.save(user);
    }
}
