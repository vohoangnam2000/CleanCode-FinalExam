package com.luvina.cm.service;

import com.luvina.cm.dto.CourseResDto;
import com.luvina.cm.entity.Course;
import com.luvina.cm.factory.SortCourseFactory;
import com.luvina.cm.repository.CouserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.cache.annotation.Cacheable;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final ModelMapper modelMapper;
    private final CouserRepository couserRepository;
    private final SortCourseFactory sortCourseFactory;

    @Transactional()
    @Cacheable(value = "courses")
    public List<CourseResDto> getCourse(String keyword, String sortBy) {
        List<Course> courses = couserRepository.findByName(keyword);
        sortCourseFactory.createSort(courses, sortBy);
        return courses
                .stream()
                .map(c -> modelMapper.map(c, CourseResDto.class))
                .collect(Collectors.toList());
    }
}
