package com.luvina.cm.controller;

import com.luvina.cm.dto.CourseReqDto;
import com.luvina.cm.dto.CourseResDto;
import com.luvina.cm.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CourseController {

    private final CourseService courseService;

    @GetMapping("/api/v1/courses")
    public ResponseEntity<List<CourseResDto>> getCourseByName(@RequestParam(value = "keyword") String keyword,
                                                              @RequestParam(value = "sortMode") String sortMode) {
        System.out.println("getName " + keyword);
        System.out.println("SortName " + sortMode);
        List<CourseResDto> response = courseService.getCourse(keyword, sortMode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
