package com.edu.pt.service.impl;

import com.edu.pt.entity.course.Exam;
import com.edu.pt.mapper.ExamMapper;
import com.edu.pt.service.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Resource
    private ExamMapper examMapper;

    @Override
    public void addExam(Exam exam) {
        examMapper.addExam(exam);
    }

    @Override
    public List<Exam> getTechExams(int uid) {
        return examMapper.getTechExams(uid);
    }

    @Override
    public List<Exam> getStuExams(int uid) {
        return examMapper.getStuExams(uid);
    }

    @Override
    public int deleteExam(int exam_id) {
        return examMapper.deleteExam(exam_id);
    }
}
