package com.edu.pt.mapper;

import com.edu.pt.entity.course.Course;
import com.edu.pt.entity.course.CourseType;
import com.edu.pt.entity.user.User;
import com.edu.pt.utils.ScoreModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CourseMapper {

    @Delete("delete from stu_course where uid =#{stu_id} and course_id=#{course_id}")
    public void disSelectCourse(int stu_id,int course_id);

    @Select("select * from course where id in (select course_id from stu_course where stu_course.uid=#{stu_id})")
    @ResultMap("courseInfo")
    public List<Course> findCourseIsSelected(int stu_id);

    @Select("select * from course where status = '1' and course.id not in(select course_id from stu_course where course_id = course.id and stu_course.uid=#{stu_id})")
    @ResultMap("courseInfo")
    public List<Course> findCourseIsOn(int stu_id);

    @Insert("insert into stu_course(uid,course_id) values(#{stu_id},#{course_id})")
    public void getCourse(int course_id,int stu_id);


    @Select("select * from courseType where id = #{type_id}")
    public CourseType findTypeById(int type_id);

    @Select("select * from courseType")
    public List<CourseType> findAllType();


    @Select("select * from course")
    @Results(id = "courseInfo",
            value = {
                    @Result(id = true,column = "course_id",property = "course_id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "credit",property = "credit"),
                    @Result(column = "hours",property = "hours"),
                    @Result(column = "status",property = "status"),
                    @Result(column = "type_id",property = "courseType",
                            one = @One(
                                    select = "com.edu.pt.mapper.CourseMapper.findTypeById",
                                    fetchType = FetchType.EAGER
                            )
                    ),
                    @Result(column = "uid",property = "user",
                            one = @One(
                                    select = "com.edu.pt.mapper.UserMapper.findByUid",
                                    fetchType = FetchType.EAGER
                            )
                    )
            }
    )
    public List<Course> findAllCourse();


    @Update("update course set status = '1' where id = #{course_id}")
    public void changeStatus1(Integer course_id);

    @Update("update course set status = '0' where id = #{course_id}")
    public void changeStatus0(Integer course_id);

    @Update("update course set status = '2' where id = #{course_id}")
    public void shutdown(Integer course_id);

    @Select("select * from course where id = #{course_id}")
    @ResultMap(value = "courseInfo")
    public Course check(Integer course_id);

    @Update("update course set name=#{name},credit=#{credit},hours=#{hours},uid = #{user.uid},type_id=#{courseType.id} where id = #{id}")
    public void updateOne(Course course);

    @Delete("delete from course where id = #{course_id}")
    public void deleteOne(int course_id);

    @Insert("insert into course (name, credit, hours, type_id, uid) values (#{name},#{credit},#{hours},#{courseType.id},#{user.uid})")
    public void addOne(Course course);

    @Select("select * from course where uid =#{tech_id} and status != '2'")
    @ResultMap("courseInfo")
    public List<Course> findCourseByTechId(int tech_id);

    @Select("select * from user where uid in (select uid from stu_course where course_id = #{course_id})")
    @ResultMap("com.edu.pt.mapper.UserMapper.user_dpt")
    public List<User> findStuInCourse(int course_id);

    @Update("update stu_course set score = #{score} where uid = #{uid} and course_id = #{course_id}")
    public void saveScore(ScoreModel scoreModel);

    @Select("select * from stu_course where course_id = #{course_id}")

    public List<ScoreModel> checkScore(int course_id);

    @Select("select * from stu_course where uid = #{uid} and score is not null")
    @Results(id = "score",value = {
            @Result(column = "course_id",property = "course",one = @One(
                    select = "com.edu.pt.mapper.CourseMapper.check"
            ))
    })
    public List<ScoreModel> getStuScores(int uid);
}
