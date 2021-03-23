package com.example.demo.Service;

import com.example.demo.Entity.Course;
import com.example.demo.Reponsitory.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    public CourseRepository courseRepository;

    public List<Course> getListCourse(){
        List<Course> courses = courseRepository.findAll();
        return courses;
    }
}
