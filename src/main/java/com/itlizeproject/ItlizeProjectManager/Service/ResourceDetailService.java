package com.itlizeproject.ItlizeProjectManager.Service;

import com.itlizeproject.ItlizeProjectManager.Entity.ResourceDetail;
import java.util.List;

public interface ResourceDetailService {
    public ResourceDetail findById(Integer Id);
    List<ResourceDetail> findAll();
    List<ResourceDetail> findByResource(Integer resourceId);
    List<ResourceDetail> findByProjectColumn(Integer projectId);
    public ResourceDetail update(Integer id, String description, Integer cost);
    public ResourceDetail save(ResourceDetail resourceDetail);
    public void delete(ResourceDetail resourceDetail);
    public void deleteById(Integer id);
}

