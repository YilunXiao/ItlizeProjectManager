package com.itlizeproject.ItlizeProjectManager.Service;

import com.itlizeproject.ItlizeProjectManager.Entity.User;

import java.util.List;

public interface UserService {
    public User findById(Integer Id);

    public User findByUsername(String username);

    List<User> findAll();

    public User updateUserById(Integer id, String name, String password, String email);

    public void delete(User user);
    public void deleteById(Integer id);

    public User save(User user);

    public User create(String name, String password, String email);
}
