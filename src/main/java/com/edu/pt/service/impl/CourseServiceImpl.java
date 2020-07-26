package com.edu.pt.service.impl;


import com.edu.pt.entity.course.Course;
import com.edu.pt.entity.course.CourseType;
import com.edu.pt.entity.user.User;
import com.edu.pt.mapper.CourseMapper;
import com.edu.pt.service.CourseService;
import com.edu.pt.utils.ScoreModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    public List<Course> findCourseByTechId(int tech_id) {
        return courseMapper.findCourseByTechId(tech_id);

    }

    public void disSelectCourse(int stu_id,int course_id) {
        courseMapper.disSelectCourse(stu_id,course_id);
    }

    public List<Course> findCourseIsSelected(int stu_id) {
        return courseMapper.findCourseIsSelected(stu_id);
    }

    public List<Course> findCourseIsOn(int stu_id) {
        return courseMapper.findCourseIsOn(stu_id);
    }

    public List<Course> findAll(){
        return courseMapper.findAllCourse();
    }

    public void changeStatus1(Integer course_id){
        courseMapper.changeStatus1(course_id);
    }
    public void changeStatus0(Integer course_id){
        courseMapper.changeStatus0(course_id);
    }

    public void shutdown(int course_id){
        courseMapper.shutdown(course_id);
    }

    public Course findById(Integer course_id){
        return courseMapper.check(course_id);
    }

    public void deleteOne(int course_id){
        courseMapper.deleteOne(course_id);
    }

    public void addOne(Course course){
        courseMapper.addOne(course);
    }


    public void updateOne(Course course){
        courseMapper.updateOne(course);
    }

    @Override
    public CourseType findTypeById(int type_id) {
        return courseMapper.findTypeById(type_id);
    }

    @Override
    public List<CourseType> findAllType() {
        return courseMapper.findAllType();
    }

    @Override
    public void getCourse(int course_id, int stu_id) {
        courseMapper.getCourse(course_id,stu_id);
    }

    @Override
    public List<User> findStuInCourse(int course_id) {
        return courseMapper.findStuInCourse(course_id);
    }

    @Override
    public void saveScore(ScoreModel scoreModel) {
        courseMapper.saveScore(scoreModel);
    }

    @Override
    public List<ScoreModel> checkScore(int course_id) {
        return courseMapper.checkScore(course_id);
    }

    @Override
    public List<ScoreModel> getStuScores(int uid) {
        return courseMapper.getStuScores(uid);
    }


}
