package com.edu.pt.service;


import com.edu.pt.entity.course.Course;
import com.edu.pt.entity.course.CourseType;
import com.edu.pt.entity.user.User;
import com.edu.pt.utils.ScoreModel;

import java.util.List;

public interface CourseService {

    public List<Course> findCourseByTechId(int tech_id);

    public void disSelectCourse(int stu_id,int course_id);

    public List<Course> findCourseIsSelected(int stu_id);

    public List<Course> findCourseIsOn(int stu_id);

    public List<Course> findAll();

    public void changeStatus1(Integer course_id);

    public void changeStatus0(Integer course_id);

    public void shutdown(int course_id);

    public Course findById(Integer course_id);

    public void deleteOne(int course_id);

    public void addOne(Course course);

    public void updateOne(Course course);

    public CourseType findTypeById(int type_id);

    public List<CourseType> findAllType();

    public void getCourse(int course_id,int stu_id);

    public List<User> findStuInCourse(int course_id);

    public void saveScore(ScoreModel scoreModel);

    public List<ScoreModel> checkScore(int course_id);

    public List<ScoreModel> getStuScores(int uid);
}
