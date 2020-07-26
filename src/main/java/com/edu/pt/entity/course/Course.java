package com.edu.pt.entity.course;

import com.edu.pt.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {

    private int id;
    private String name;
    private float credit;
    private int hours;
    /**
     * 课程状态：
     * 0：未发布（不可选）
     * 1：已发布（可选，可退选）
     * 2：已结课
     */
    private Integer status;
    private CourseType courseType;
    private User user;

}
