package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudentService {
    PrimitiveIterator.OfInt idGenerator = IntStream.iterate(0, i -> i + 1).iterator();
    private final Map<Integer, Student> students = new HashMap<>();

    public void registerStudent(Student student) {
        student.setId(idGenerator.next());
        students.put(student.getId(), student);
    }

    public Student removeStudent(Integer id) {
        return students.remove(id);
    }

    public List<Student> queryStudents(String gender) {
        if (gender == null || gender.isEmpty()) {return new ArrayList<>(students.values());}
        return students.values().stream()
                .filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }
}
