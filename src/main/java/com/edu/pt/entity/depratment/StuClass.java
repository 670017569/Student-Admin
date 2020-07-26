package com.edu.pt.entity.depratment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuClass implements Serializable {

    private int id;
    private String name;

}
