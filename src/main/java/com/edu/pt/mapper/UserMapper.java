package com.edu.pt.mapper;


import com.edu.pt.entity.user.Permission;
import com.edu.pt.entity.user.Role;
import com.edu.pt.entity.user.TechLevel;
import com.edu.pt.entity.user.User;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 插入用户信息
     * @param user
     */
    @Insert("insert into user(username, password, name, email, gender,birth,dpt_id,level_id) " +
            "values (#{username},#{password},#{name},#{email},#{gender},#{birth},#{dpt.id},#{techLevel.id})")
    public int addUser(User user) throws DuplicateKeyException;



    /**
     * 修改用户信息
     * @param user
     */
    @Update("update user set username=#{username}, password =#{password},name=#{name},email=#{email},gender=#{gender},birth=#{birth},dpt_id=#{dpt.id},level_id=#{techLevel.id} where uid = #{uid}")
    public int updateUser(User user);

    /**
     * 修改用户状态为停用
     * @param uid
     */
    @Update("update user set status = '0' where uid = #{uid}")
    public int altUserStatus(int uid);

    /**
     * 通过用户id查找
     * @param uid
     * @return
     */
    @Select("select * from user where uid = #{uid}")
    @ResultMap("user_dpt")
    public User findUserByUid(int uid);

    /**
     * 查询某种角色下的所有用户基本信息
     * @param role_id
     * @return
     */
    @Select("select * from user,user_role where user_role.role_id = #{role_id} and user.uid = user_role.uid and status = '1' order by dpt_id")
    @Results(id = "user_dpt",
            value = {
                    @Result(id = true,column = "uid",property = "uid"),
                    @Result(column = "username",property = "username"),
                    @Result(column = "password",property = "password"),
                    @Result(column = "uid",property = "role",many = @Many(
                            select = "com.edu.pt.mapper.UserMapper.findRolesByUid"
                    )),
                    @Result(column = "dpt_id",property = "department",one = @One(
                            select = "com.edu.pt.mapper.DepartmentMapper.findAllParentById"
                    )),
                    @Result(column = "level_id",property = "techLevel",one = @One(
                            select = "findLevelById"
                    ))
            })
    public List<User> findAllUser(int role_id);

    @Select("select * from user where dpt_id = #{class_id} and status = '1' order by dpt_id")
    @ResultMap("user_dpt")
    public List<User> findUserByClassId(int class_id);




    @Select("select * from techLevel where id = #{level_id}")
    public TechLevel findLevelById(int level_id);

    /**
     * 查询用户账号密码及角色权限信息
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    @Results(id = "userInfo",
    value = {
            @Result(id = true,column = "uid",property = "uid"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "uid",property = "role",many = @Many(
                    select = "com.edu.pt.mapper.UserMapper.findRolesByUid"
            ))
    })
    public User findByUsername(String username);




    @Results(id = "role_perms",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "role" ,property = "role"),
            @Result(column = "id",property = "permses",many = @Many(
                    select = "findPermsByRoleId"
            ))
    })
    @Select("select * from user_role,role where user_role.uid = #{uid} and role.id = user_role.role_id")
    public Role findRolesByUid(int uid);


    @Select("select * from role_perms,perms where role_perms.role_id = #{uid} and perms.id = role_perms.perms_id")
    @Results(id = "permsInfo",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "perms",property = "perms")
    })
    public List<Permission> findPermsByRoleId(int uid);

    @Select("select * from techLevel")
    public List<TechLevel> getLevels();


    @Select("select name from user where uid = #{uid}")
    public User findByUid(int uid);

}
