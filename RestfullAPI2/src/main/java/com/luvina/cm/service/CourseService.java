package com.luvina.cm.service;

import com.luvina.cm.dto.CourseResDto;
import com.luvina.cm.entity.Course;
import com.luvina.cm.entity.Teacher;
import com.luvina.cm.repository.CouserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final ModelMapper modelMapper;
    private final CouserRepository couserRepository;

    @Transactional
    public List<CourseResDto> getCourse(String keyword, String sortBy) {
        List<Course> courses = couserRepository.findByName(keyword);
        printflist(courses);
        return courses
                .stream()
                .map(c -> modelMapper.map(c, CourseResDto.class))
                .collect(Collectors.toList());
    }

    public void printflist(List<Course> courses) {
        System.out.println("Teacher");
        List<Teacher> teachers = courses.get(0).getTeachers();
        System.out.println("teachers"+ teachers.get(0).getName());
        for (int i = 0 ; i < courses.size() ; i++) {
            System.out.println(courses.get(i).getTeachers().toString());
        }
    }
}
