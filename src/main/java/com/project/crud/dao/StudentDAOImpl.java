package com.project.crud.dao;

import com.project.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> queryResult = entityManager.createQuery("FROM Student", Student.class);
        return queryResult.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        student = entityManager.merge(student);
        entityManager.remove(student);
    }
}
