package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1")
public class studentController {
    @Autowired
    private final studentservice servicestd;

    public studentController(studentservice servicestd) {
        this.servicestd = servicestd;
    }


    @GetMapping
    public List<Student> responsestd() {
        return servicestd.getstudents();
    }

    @PostMapping("reg")
    public void RegisterNewStudent(@RequestBody Student student) {
        servicestd.AddNewStudent(student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            servicestd.deleteStudentById(id);
            return ResponseEntity.ok("Student deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting student: " + e.getMessage());
        }
    }
}
