package com.itlizeproject.ItlizeProjectManager.Repository;

import com.itlizeproject.ItlizeProjectManager.Entity.Project;
import com.itlizeproject.ItlizeProjectManager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findProjectById(Integer id);
    List<Project> findAll();
    Project findProjectByName(String name);
    List<Project> findProjectsByUser(User user);
}
