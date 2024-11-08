package com.project.crud.dao;

import com.project.crud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer studentId);

    List<Student> getAll();

    void update(Student student);

    void delete(Student student);
}
