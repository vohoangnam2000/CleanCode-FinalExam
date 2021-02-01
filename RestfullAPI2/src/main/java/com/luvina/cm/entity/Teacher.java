package com.luvina.cm.entity;

import com.luvina.cm.dto.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Teacher extends User {
    private String phone;
    private int experiences;

    public Teacher(UserDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.phone = dto.getTeacher().getPhone();
        this.experiences = dto.getTeacher().getExperiences();
    }

    public Teacher() {
    }

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

}
