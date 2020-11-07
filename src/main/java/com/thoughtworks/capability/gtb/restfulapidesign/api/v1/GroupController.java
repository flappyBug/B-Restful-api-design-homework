package com.thoughtworks.capability.gtb.restfulapidesign.api.v1;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
