package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentservice {
    @Autowired
    StudentRepository repository;

    void AddNewStudent(Student student) {
        repository.save(student);
    }

    List<Student> getstudents() {
        return repository.findAll();
    }

    public void deleteStudentById(Long studentId) {
        // Check if the student exists
        Optional<Student> optionalStudent = repository.findById(studentId);

        if (optionalStudent.isPresent()) {
            // Student found, delete it
            repository.deleteById(studentId);
        } else {
            // Student not found, throw an exception or handle as needed
            throw new RuntimeException("Student not found with ID: " + studentId);
        }
    }
}
