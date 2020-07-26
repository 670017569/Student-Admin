package com.edu.pt.controller;

import com.edu.pt.entity.course.Course;
import com.edu.pt.entity.depratment.Department;
import com.edu.pt.entity.user.TechLevel;
import com.edu.pt.entity.user.User;
import com.edu.pt.service.CourseService;
import com.edu.pt.service.DepartmentService;
import com.edu.pt.service.UserService;
import com.edu.pt.utils.CommonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
@RequiresRoles({"admin"})
public class AdminViewController {

    @Resource
    private UserService userService;
    @Resource
    private CourseService courseService;
    @Resource
    private DepartmentService departmentService;



    /**
     * 根据班级id所有用户
     * @return
     */
    @ResponseBody
    @GetMapping("/admin/getUserByDptId")
    public CommonResult getUserByClassId(@RequestParam("dptId") int dptId){
        return new CommonResult(200,"success",new PageInfo(userService.findUserByClassId(dptId)));
    }

    /**
     * 根据身份类型分页查询所有用户
     * @return
     */
    /**
     * 根据班级id所有用户
     * @return
     */
    @ResponseBody
    @GetMapping("/admin/getUserByRole")
    public CommonResult getUserByRole(@RequestParam("role_id") int role_id,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int size){
        PageHelper.startPage(pageNum,size);
        return new CommonResult(200,"success",new PageInfo(userService.findAllUser(role_id)));
    }

    /******************************************学生管理**************************************************/

    /**
     * 跳转到学生信息查看列表
     * @return
     */
    @GetMapping("/admin/students")
    public String toStudent(){
        return "adminView/studentList";
    }


    /**
     * 带上当前要修改的学生跳转到学生信息修改页面
     * @param uid
     * @param modelMap
     * @return
     */
    @GetMapping("/admin/student/{uid}")
    public String toEditStu(@PathVariable("uid") int uid, ModelMap modelMap){
        modelMap.addAttribute("stu",userService.findUserByUid(uid));
        return "adminView/updateStu";
    }



    /**
     * 完成学生信息修改
     * @param user
     * @return
     */
    @PutMapping("/admin/student")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/admin/students";
    }

    /**
     * 跳转到添加学生页面
     * @return
     */
    @GetMapping("/admin/student")
    public String toAddStu(){
        return "adminView/updateStu";
    }

    /**
     * 传回学生数据完成学生添加
     * @param user
     * @return
     */
    @PostMapping("/admin/student")
    public String addStu(User user,ModelMap modelMap) {
        if (null == userService.findByUsername(user.getUsername())){
            userService.addUser(user);
        }else {
            modelMap.addAttribute("msg","用户名已存在");
        }

        return "adminView/studentList";
    }

    /**
     * 将学生状态转status为0不可见停用状态
     * 注销账号
     * @param uid
     */
    @ResponseBody
    @DeleteMapping("/admin/deleteUser")
    public CommonResult deleteUser(@RequestParam("uid") int uid){
        return new CommonResult(200,"删除成功",userService.altUserStatus(uid));
    }

/**************************************对教师人员信息管理***********************************************/
    /**
     * 跳转至教师列表页面
     * @return
     */
    @GetMapping("/admin/teachers")
    public String toTeachersPage(){
        return "adminView/teacherList";
    }

    /**
     * 跳转至教师添加页面
     * @return
     */
    @GetMapping("/admin/teacher")
    public String toAddTeacherPage(){
        return "adminView/updateTech";
    }

    /**
     * 完成教师信息添加
     * @param user
     * @return
     */
    @PostMapping("/admin/teacher")
    public String addTech(User user){
        userService.addUser(user);
        return "redirect:/admin/teachers";
    }

    /**
     * 跳转至教师信息修改页面
     * @param uid
     * @param modelMap
     * @return
     */
    @GetMapping("/admin/teacher/{uid}")
    public String toUpdatePage(@PathVariable("uid") int uid,ModelMap modelMap){
        modelMap.addAttribute("teacher",userService.findUserByUid(uid));
        return "adminView/updateTech";
    }

    /**
     * 完成教师信息修改
     * @param user
     * @return
     */
    @PutMapping("/admin/teacher")
    public String updateTeacher(User user){
        log.info(user+"");
        userService.updateUser(user);
        return "redirect:/admin/teachers";
    }

    /**
     * 获取所有教师职称等级
     * @return
     */
    @ResponseBody
    @GetMapping("/admin/getLevels")
    public List<TechLevel> getLevels(){
        return userService.getAllLevels();
    }

    /**************************************发布课程变更为可选状态***********************************************/
    /**
     * 跳转到课程发布页面
     * @return
     */
    @GetMapping("/admin/coursepub")
    public String toCoursePub(){
        return "adminView/courseList";
    }

    /**
     * 获取所有课程列表
     * @param pageNum
     * @param size
     * @return
     */
    @GetMapping("/admin/getCourPage")
    public @ResponseBody CommonResult<PageInfo> studentList(@RequestParam("pageNum") int pageNum, @RequestParam("size") int size){
        PageHelper.startPage(pageNum,size);
        return  new CommonResult(200,"查询成功",new PageInfo(courseService.findAll()));
    }

    /**
     * 设置课程状态为可选
     * @param course_id
     * @return
     */
    @PutMapping("/admin/changeStatus1")
    public @ResponseBody
    Course changeStatus1(@RequestParam("course_id") Integer course_id){

        courseService.changeStatus1(course_id);
        return courseService.findById(course_id);
    }

    /**
     * 设置状态为不可选
     * @param course_id
     * @return
     */
    @PutMapping("/admin/changeStatus0")
    public @ResponseBody Course changeStatus0(@RequestParam("course_id") Integer course_id){
        courseService.changeStatus0(course_id);
        return courseService.findById(course_id);
    }

/***************************************部门管理**************************************************/

    /**
     * 跳转到部门管理页面
     * @return
     */
    @GetMapping("/admin/departments")
    public String toDptManager(){
        return "adminView/dptmanager";
    }

    /**
     *根据父id查询所有子部门
     * @return
     */
    @ResponseBody
    @GetMapping("/admin/getDpts")
    public List<Department> getCols(@RequestParam("parentId") int parentId){
        return departmentService.findDptByParentId(parentId);
    }

    /**
     * 添加学院
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/admin/saveDpt")
    public CommonResult saveDpt(@RequestParam("name") String name,@RequestParam("parentId") int parentId){
        departmentService.saveDpt(name,parentId);
        return new CommonResult(200,"保存成功");
    }


}
