package com.example.CRUDDemo.repository;


import com.example.CRUDDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
