package com.example.mybatis.service;

import com.example.mybatis.model.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> getInstructors();
    Instructor getInstructorsById(Integer id);

    Instructor createInstructor(Instructor instructor);
}
