package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class GroupService {
    private final List<Group> groups;
    private final StudentService studentService;
    private Random random = new Random();
    private final Integer TOTAL_GROUPS = 6;

    public GroupService(StudentService studentService) {
        this.studentService = studentService;
        groups = IntStream.rangeClosed(1, TOTAL_GROUPS)
                .mapToObj(id -> new Group(id, "Team " + id, new ArrayList<>(), null)).collect(Collectors.toList());
    }

    private Student randomPop(List<Student> students) {
        return students.remove(random.nextInt(students.size()));
    }

    private void clearGroups() {
        groups.forEach(group -> group.getStudents().clear());
    }

    public List<Group> shuffleGroups() {
        clearGroups();
        List<Student> students = studentService.queryStudents(null);
        int groupIndex = 0;
        while (!students.isEmpty()) {
            groups.get(groupIndex).getStudents().add(randomPop(students));
            groupIndex = (groupIndex + 1) % TOTAL_GROUPS;
        }
        return groups;
    }

    public void rename(Integer id, Group group) {
        if (id >= TOTAL_GROUPS || id < 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found");
        }
        groups.get(id).setName(group.getName());
    }
}
