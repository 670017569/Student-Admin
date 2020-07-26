package com.edu.pt.utils;

import com.edu.pt.entity.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreModel {

    private int uid;
    private Course course;
    private int score;
    private int course_id;

}
