package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private String note;

    public void updateInfo(Student info) {
        if (info.name != null) {
            this.name = info.name;
        }
        if (info.gender != null) {
            this.gender = info.gender;
        }
        if (info.note != null) {
            this.note = info.note;
        }
    }
}
