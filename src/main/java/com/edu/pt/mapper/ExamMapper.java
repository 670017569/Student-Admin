package com.edu.pt.mapper;

import com.edu.pt.entity.course.Exam;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ExamMapper {

    @Insert("insert into exam (course_id,exam_date,start_time, end_time, address, methods) values (#{course.id},#{exam_date},#{start_time},#{end_time},#{address},#{methods})")
    public void addExam(Exam exam);

    @Select("select * from exam where course_id in(select id from course where uid = #{uid})")
    @Results(id = "examInfo",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "address",property = "address"),
            @Result(column = "exam_date",property = "exam_date"),
            @Result(column = "start_time",property = "start_time"),
            @Result(column = "end_time",property = "end_time"),
            @Result(column = "course_id",property = "course",one = @One(
                    select = "com.edu.pt.mapper.CourseMapper.check"
            ))
    })

    public List<Exam> getTechExams(int uid);

    @Select("select * from exam where course_id in(select course_id from stu_course where uid = #{uid})")
    @ResultMap("examInfo")
    public List<Exam> getStuExams(int uid);

    @Delete("delete from exam where id = #{exam_id}")
    public int deleteExam(int exam_id);
}
