package com.itlizeproject.ItlizeProjectManager.Repository;

import com.itlizeproject.ItlizeProjectManager.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    Resource findResourceById(Integer id);
    List<Resource> findAll();
    List<Resource> findResourcesByName(String name);
    List<Resource> findResourcesByResourceCode(String code);
}
