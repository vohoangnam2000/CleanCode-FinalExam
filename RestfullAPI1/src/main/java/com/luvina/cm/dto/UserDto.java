package com.luvina.cm.dto;

import com.luvina.cm.entity.Student;
import com.luvina.cm.entity.Teacher;
import com.luvina.cm.*;
import com.luvina.cm.enums.UserMode;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserDto {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private Student student;
    private Teacher teacher;
    @NonNull
    private UserMode userMode;
}
