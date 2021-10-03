package com.itlizeproject.ItlizeProjectManager.Repository;

import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDetailRepository extends JpaRepository<ResourceDetail, Integer> {
    ResourceDetail findResourceDetailById(Integer id);
    ResourceDetail findResourceDetailByResourceId(Integer id);
    ResourceDetail findResourceDetailByProjectColumnId(Integer id);
}

