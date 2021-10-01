package com.itlizeproject.ItlizeProjectManager.Service.Impl;

import com.itlizeproject.ItlizeProjectManager.Entity.User;
import com.itlizeproject.ItlizeProjectManager.Repository.UserRepository;
import com.itlizeproject.ItlizeProjectManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer Id) {
        return repository.getById(Id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User updateUserById(Integer id, String name, String password, String email) {
        User user = findById(id);
        user.setUsername(name);
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
}
