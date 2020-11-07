package com.thoughtworks.capability.gtb.restfulapidesign.api.v1;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @PutMapping("/shuffle")
    List<Group> shuffleGroups() {
        return groupService.shuffleGroups();
    }

    @PatchMapping("/{id}")
    void rename(Integer id, Group group) {
        groupService.rename(id, group);
    }

    @GetMapping
    List<Group> getGroups() {
        return groupService.getGroups();
    }
}
