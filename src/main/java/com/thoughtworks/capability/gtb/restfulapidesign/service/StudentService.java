package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

@Service
public class StudentService {
    PrimitiveIterator.OfInt idGenerator = IntStream.iterate(0, i -> i + 1).iterator();
    private List<Student> students = new ArrayList<>();

    public void registerStudent(Student student) {
        student.setId(idGenerator.next());
        students.add(student);
    }
}
