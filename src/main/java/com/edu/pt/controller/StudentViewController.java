package com.edu.pt.controller;

import com.edu.pt.entity.user.User;
import com.edu.pt.service.CourseService;
import com.edu.pt.service.ExamService;
import com.edu.pt.utils.CommonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequiresRoles({"student"})
public class StudentViewController {
    @Resource
    private CourseService courseService;

    @Resource
    private ExamService examService;

    /**
     * 跳转到选课页面
     * @return
     */
    @GetMapping("/student/courses")
    public String toSelectCoursePage(){
        return "studentView/selectCourse";
    }


    /**
     * 获取所有可选课程列表
     * @param pageNum
     * @param size
     * @return
     */
    @ResponseBody
    @GetMapping("/student/getCourseIsOn")
    public CommonResult getCourseIsOn(@RequestParam("pageNum") int pageNum, @RequestParam("size") int size){
        PageHelper.startPage(pageNum,size);
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        int stu_id = currentUser.getUid();
        log.info("当前进入选课的用户"+stu_id);
        return  new CommonResult(200,"查询成功",new PageInfo(courseService.findCourseIsOn(stu_id)));
    }

    /**
     * 学生选取课程存入学生课程表
     * @param course_id
     * @return
     */
    @ResponseBody
    @PostMapping("/student/getCourse")
    public CommonResult getCourse(@RequestParam("course_id") int course_id){
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        int stu_id = currentUser.getUid();
        courseService.getCourse(course_id,stu_id);
        return new CommonResult(200,"选课成功");
    }


    /**
     * 显示已选课程
     * @return
     */
    @ResponseBody
    @GetMapping("/student/getCourseIsSelected")
    public CommonResult getCourseIsSelected(){
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        int stu_id = currentUser.getUid();
        log.info(stu_id+"查看已选课程");
        return  new CommonResult(200,"查询成功",courseService.findCourseIsSelected(stu_id));
    }


    /**
     * 退选课程
     * @param course_id
     * @return
     */
    @RequiresRoles("student")
    @ResponseBody
    @DeleteMapping("/student/disSelectCourse")
    public CommonResult disSelectCourse(@RequestParam("course_id") int course_id){
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        int stu_id = currentUser.getUid();
        courseService.disSelectCourse(stu_id,course_id);
        log.info(stu_id+"退选课程"+course_id+"成功");
        return new CommonResult(200,"退选成功");
    }

    /**
     * 获取所有已出成绩课程及分数
     * @param modelMap
     * @return
     */
    @GetMapping("/student/scores")
    public String getAllScore(ModelMap modelMap){

        Subject subject = SecurityUtils.getSubject();

        User user = (User) subject.getPrincipal();

        int uid = user.getUid();

        modelMap.addAttribute("scores",courseService.getStuScores(uid));

        return "studentView/scores";
    }


    /**
     * 跳转到学生考试安排页面
     * @return
     */
    @GetMapping("/student/stuExams")
    public String toStuViewExams(){
        return "studentView/stuViewExams";
    }

    /**
     * 获取学生所学课程的考试
     * @return
     */
    @ResponseBody
    @GetMapping("/student/getStuExams")
    public CommonResult getStuExam(){
        Subject subject = SecurityUtils.getSubject();

        User user = (User) subject.getPrincipal();

        int uid = user.getUid();

        return new CommonResult(200,"查询成功",examService.getStuExams(uid));
    }


}
