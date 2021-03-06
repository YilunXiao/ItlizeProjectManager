package com.itlizeproject.ItlizeProjectManager.Service;

import com.itlizeproject.ItlizeProjectManager.Entity.Resource;

import java.util.List;

public interface ResourceService {
    Resource findOne(Integer id) throws Exception;
    List<Resource> findAll();
    List<Resource> findName(String resourceName) throws Exception;
    List<Resource> findCode(String resourceCode) throws Exception;
    Boolean addOne(String resourceName);
    Boolean updateName(Integer id, String resourceName) throws Exception;
    Boolean updateCode(Integer id, String resourceCode) throws Exception;
    Boolean deleteOne(Integer id) throws Exception;
    void addDetail(Resource resource);
    //Boolean removeDetail(Integer resourceId, Integer resourceDetailId) throws Exception;
}