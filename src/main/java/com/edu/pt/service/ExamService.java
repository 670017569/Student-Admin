package com.edu.pt.service;


import com.edu.pt.entity.course.Exam;

import java.util.List;

public interface ExamService {

    public void addExam(Exam exam);

    public List<Exam> getTechExams(int uid);

    public List<Exam> getStuExams(int uid);

    public int deleteExam(int exam_id);
}
