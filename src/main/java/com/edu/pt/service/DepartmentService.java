package com.edu.pt.service;


import com.edu.pt.entity.depratment.*;

import java.util.List;

public interface DepartmentService {

    /**
     * 查询所有学院
     * @return
     */
    public List<Department> findDptByParentId(int parentId);

    public void saveDpt(String name,int parentId);
}
