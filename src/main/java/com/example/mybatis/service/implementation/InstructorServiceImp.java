package com.example.mybatis.service.implementation;

import com.example.mybatis.model.Instructor;
import com.example.mybatis.repository.InstructorRepository;
import com.example.mybatis.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImp implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImp(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public List<Instructor> getInstructors() {
        return instructorRepository.findAllInstructors();
    }

    @Override
    public Instructor getInstructorsById(Integer id) {
        return instructorRepository.findInstructorById(id);
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.insertinstructor(instructor);
    }
}
