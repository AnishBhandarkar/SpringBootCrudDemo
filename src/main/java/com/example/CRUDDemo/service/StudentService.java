package com.example.CRUDDemo.service;

import com.example.CRUDDemo.entity.Student;
import com.example.CRUDDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        return this.studentRepository.save(studentReq);
    }

    public List<Student> getAllStudent() {
        return this.studentRepository.findAll();
    }
}
