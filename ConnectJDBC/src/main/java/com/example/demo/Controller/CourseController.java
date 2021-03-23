package com.example.demo.Controller;

import com.example.demo.Entity.Course;
import com.example.demo.Service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    public CourseService courseService;

    @ResponseBody
    @GetMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllCourse(){
        List<Course> courses = courseService.getListCourse();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(df);
        try {
            System.out.println(objectMapper.writeValueAsString(courses));
            return objectMapper.writeValueAsString(courses);
        } catch (Exception e) {
            return "{'error': 'cannot return books'}";
        }
    }
}
