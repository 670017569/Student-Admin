package com.edu.pt.controller;

import com.edu.pt.entity.course.Course;
import com.edu.pt.entity.course.CourseType;
import com.edu.pt.entity.course.Exam;
import com.edu.pt.entity.user.User;
import com.edu.pt.service.CourseService;
import com.edu.pt.service.ExamService;
import com.edu.pt.service.UserService;
import com.edu.pt.utils.CommonResult;
import com.edu.pt.utils.ScoreModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequiresRoles({"teacher"})
public class TeacherViewController {
    @Resource
    private CourseService courseService;
    @Resource
    private UserService userService;
    @Resource
    private ExamService examService;


    /**
     * 完成考试发布
     * @param exam
     * @return
     */
    @PostMapping("/teacher/exam")
    public String  addExam(Exam exam){
        examService.addExam(exam);
        return "redirect:/teacher/teacherSelf";
    }

    /**
     * 跳转至教师查看考试页面
     * @return
     */
    @GetMapping("/teacher/exams")
    public String toExams(){
        return "teacherView/techOwnExam";
    }

    @ResponseBody
    @DeleteMapping("/teacher/deleteExam")
    public CommonResult deleteExam(@RequestParam("exam_id") int exam_id){

        examService.deleteExam(exam_id);
        return new CommonResult(200,"删除成功");
    }

    /**
     * 获取教师所教课程的考试
     * @return
     */
    @ResponseBody
    @GetMapping("/teacher/getTechExams")
    public CommonResult getTechExam(){
        Subject subject = SecurityUtils.getSubject();

        User user = (User) subject.getPrincipal();

        int uid = user.getUid();

        return new CommonResult(200,"查询成功",examService.getTechExams(uid));
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/teacher/addcourse")
    public String toAddCourse(){
        return "teacherView/addCourse";
    }

    /**
     * 跳转至课程信息编辑页面
     * @param course_id
     * @param modelMap
     * @return
     */
    @GetMapping("/teacher/addcourse/{course_id}")
    public String toEdit(@PathVariable(value = "course_id") int course_id, ModelMap modelMap){
        modelMap.addAttribute("course",courseService.findById(course_id));
        return "teacherView/addCourse";
    }
                
    /**
     * 通过课程id删除课程
     * @param course_id
     * @return
     */
    @DeleteMapping("/teacher/course")
    public @ResponseBody
    CommonResult deleteOne(@RequestParam("course_id") int course_id){
        courseService.deleteOne(course_id);
        return new CommonResult(200,"删除成功");

    }

    /**
     * 查询所有老师的id和姓名
     * @return
     */
    @GetMapping("/admin/getTeachers")
    public @ResponseBody
    List<User> teachers(){
        return userService.findAllUser(2);
    }

    /**
     * 获取所有的课程类型
     * @return
     */
    @GetMapping("/teacher/getTypes")
    public @ResponseBody
    List<CourseType> courseTypes(){
        return courseService.findAllType();
    }

    /**
     * 完成课程添加，重定向至课程列表
     * @param course
     * @return
     */
    @PostMapping("/teacher/addcourse")
    public String addOne(Course course){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        course.setUser(user);
        courseService.addOne(course);
        return "redirect:/teacher/teacherSelf";
    }

    /**
     * 完成课程修改
     * @param course
     * @return
     */
    @PutMapping("/teacher/addcourse")
    public String updateOne(Course course){
        courseService.updateOne(course);
        return "redirect:/teacher/teacherSelf";
    }

    /**
     * 转到教师管理课程页面
     * @return
     */
    @GetMapping("/teacher/teacherSelf")
    public String toTeacherSelf(){
        return "teacherView/teacherSelf";
    }

    /**
     * 获取该教师所开设的课程
     * @param pageNum
     * @param size
     * @return
     */
    @ResponseBody
    @GetMapping("/teacher/getCourseOwnTech")
    public CommonResult getCourseOwnTech(@RequestParam("pageNum") int pageNum,@RequestParam("size") int size){

        PageHelper.startPage(pageNum,size);

        Subject subject = SecurityUtils.getSubject();

        User currentUser = (User) subject.getPrincipal();

        int tech_id = currentUser.getUid();

        return  new CommonResult(200,"查询成功",new PageInfo(courseService.findCourseByTechId(tech_id)));

    }

    /**
     * 前往本课程考试信息发布页
     * @return
     */
    @GetMapping("/teacher/exampub/{course_id}")
    public String toOwnCourse(@PathVariable("course_id") int course_id,ModelMap modelMap){
        modelMap.addAttribute("course",courseService.findById(course_id));
        return "teacherView/exampub";
    }

    /**
     * 前往课程班级学生管理查看页面
     * @return
     */
    @GetMapping("/teacher/courseClass")
    public String toCourseClass(){
        return "teacherView/courseClass";
    }

    /**
     * 获取教师所教课程下拉列表
     * @return
     */
    @ResponseBody
    @GetMapping("/teacher/getTechCourseSelect")
    public CommonResult getTechCourseSelect(){

        Subject subject = SecurityUtils.getSubject();

        User currentUser = (User) subject.getPrincipal();

        int tech_id = currentUser.getUid();

        return  new CommonResult(200,"查询成功",courseService.findCourseByTechId(tech_id));

    }

    @ResponseBody
    @PostMapping("/teacher/shutdown")
    public CommonResult shutdown(@RequestParam("course_id") int course_id){
        courseService.shutdown(course_id);
        return new CommonResult(200,"结课成功");
    }

    /**
     * 获取某课程下的所有学生
     * @param course_id
     * @return
     */
    @ResponseBody
    @GetMapping("/teacher/getStuInCourse")
    public CommonResult getStuInCourse(@RequestParam("course_id") int course_id){
        return new CommonResult(200,"查询成功",courseService.findStuInCourse(course_id));
    }

    /**
     * 带上某课程下的所有学生，跳转到成绩录入界面
     * @param course_id
     * @param modelMap
     * @return
     */
    @GetMapping("/teacher/updateScore/{course_id}")
    public String toUpdateScore(@PathVariable("course_id") int course_id,ModelMap modelMap){
        modelMap.addAttribute("course",courseService.findById(course_id));
        modelMap.addAttribute("students",courseService.findStuInCourse(course_id));
        return "teacherView/examScore";
    }

    /**
     * 根据前端传回的成绩表保存成绩
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/teacher/saveScores")
    public CommonResult saveScores(@RequestBody List<ScoreModel> data){

        for (ScoreModel scoreModel : data){
            courseService.saveScore(scoreModel);
            System.out.println(scoreModel);
        }
        return new CommonResult(200,"保存成功");
    }

    /**
     * 或取某课程下所有学生的成绩
     * @param course_id
     * @return
     */
    @ResponseBody
    @GetMapping("/teacher/getScores")
    public CommonResult checkScore(@RequestParam("course_id") int course_id){
        return new CommonResult(200,"查询成功",courseService.checkScore(course_id));
    }
}
