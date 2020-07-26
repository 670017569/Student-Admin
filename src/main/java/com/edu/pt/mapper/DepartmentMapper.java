package com.edu.pt.mapper;

import com.edu.pt.entity.depratment.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface DepartmentMapper {


    /**
     *根据父id查询父id下所有部门
     * (顺查)
     * @return
     */
    @Select("select * from department where parent_id = #{parentId}")
    List<Department> findDptByParentId(int parentId);


    /**
     * 根据子id查询父部门
     * (倒查)
     * @param id
     * @return
     */
    @Select("select * from department where id = (select parent_id from department where id = #{id})")
    Department findParentDptById(int id);


    @Select("select getParentList(#{id})")
    List<String> findAllParentById(int id);

    @Insert("insert into department(parent_id,name) values(#{parentId},#{name})")
    public void saveDpt(String name,int parentId);


}
