package com.luvina.cm.dto;

import com.luvina.cm.entity.Student;
import com.luvina.cm.entity.Teacher;
import com.luvina.cm.enums.UserMode;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private Student student;
    private Teacher teacher;
    private UserMode mode;
}
