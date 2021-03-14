package com.ljp.test.controller.copy;

import com.ljp.test.controller.entity.Student;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class CopyTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date now = new Date();
        Student s1 = new Student("张三", "男", "甲班", now, now);
        Student s2 = new Student();
        BeanUtils.copyProperties(s1, s2);
        System.out.println(s1 == s2);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        Student s3 = s1.clone();
        System.out.println(s1 == s3);
        System.out.println("s3 = " + s3);
    }
}
