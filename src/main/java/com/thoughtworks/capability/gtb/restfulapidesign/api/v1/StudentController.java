package com.thoughtworks.capability.gtb.restfulapidesign.api.v1;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void registerStudent(@RequestBody Student student) {
        studentService.registerStudent(student);
    }

    @DeleteMapping("/{id}")
    void removeStudent(@PathVariable Integer id) {
        studentService.removeStudent(id);
    }

    @GetMapping
    List<Student> queryStudents(@RequestParam(required = false) String gender) {
        return studentService.queryStudents(gender);
    }

    @GetMapping("/{id}")
    Student getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @PatchMapping("/{id}")
    void updateStudent(@PathVariable Integer id, @RequestBody Student info) {
        studentService.updateStudent(id, info);
    }
}
