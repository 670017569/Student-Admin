package com.edu.pt.service.impl;

import com.edu.pt.entity.depratment.*;
import com.edu.pt.mapper.DepartmentMapper;
import com.edu.pt.service.DepartmentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> findDptByParentId(int parentId) {
        return departmentMapper.findDptByParentId(parentId);
    }

    @Override
    public void saveDpt(String name,int parentId){
        departmentMapper.saveDpt(name,parentId);
    }

}
