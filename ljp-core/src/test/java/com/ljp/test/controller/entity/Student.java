package com.ljp.test.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Cloneable {

    private String studentName;
    private String sex;
    private String className;
    private Date createTime;
    private Date updateTime;

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

}
