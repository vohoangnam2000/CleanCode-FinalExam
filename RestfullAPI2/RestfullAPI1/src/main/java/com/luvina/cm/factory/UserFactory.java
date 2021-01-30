package com.luvina.cm.factory;

import com.luvina.cm.dto.UserDto;
import com.luvina.cm.entity.Student;
import com.luvina.cm.entity.Teacher;
import com.luvina.cm.entity.User;
import com.luvina.cm.enums.UserMode;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public User createUser(UserDto dto) {
        if (dto.getMode() == UserMode.STUDENT) {
            return createStudent(dto);
        } else if (dto.getMode() == UserMode.TEACHER) {
            return createTeacher(dto);
        } else {
            throw new UnsupportedOperationException("Unspported register mode");
        }
    }

    public User createTeacher(UserDto dto) {
        return new Teacher(dto);
    }

    public User createStudent(UserDto dto) {
        return new Student(dto);
    }
}
