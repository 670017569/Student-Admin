package com.edu.pt.entity.user;

import com.edu.pt.entity.depratment.Department;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private int gender;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")//无效方法
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String birth;
    private TechLevel techLevel;
    private List<Role> role;
    private List<String> department;
    private Department dpt;
}
