package com.edu.pt.entity.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam implements Serializable {

    private int id;
    private Course course;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date exam_date;
    @JsonFormat(pattern = "HH:mm")
    private String start_time;
    @JsonFormat(pattern = "HH:mm")
    private String end_time;
    private String address;
    private int methods;

}
