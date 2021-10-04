package com.itlizeproject.ItlizeProjectManager.Repository;

import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResourceDetailRepository extends JpaRepository<ResourceDetail, Integer> {
    //ResourceDetail findResourceDetailById(Integer id);
    List<ResourceDetail> findResourceDetailByResourceId(Integer id);
    List<ResourceDetail> findResourceDetailByProjectColumnId(Integer id);
}

