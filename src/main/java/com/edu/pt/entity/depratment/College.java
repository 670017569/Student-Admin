package com.edu.pt.entity.depratment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class College implements Serializable {

    private int id;
    private String name;
    private List<Profess> professes;

}
