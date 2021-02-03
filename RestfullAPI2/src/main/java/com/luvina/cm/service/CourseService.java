package com.luvina.cm.service;

import com.luvina.cm.dto.CourseResDto;
import com.luvina.cm.entity.Course;
import com.luvina.cm.error.ErrorCodes;
import com.luvina.cm.error.ServiceRuntimeException;
import com.luvina.cm.factory.SortCourseFactory;
import com.luvina.cm.repository.CouserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final ModelMapper modelMapper;
    private final CouserRepository couserRepository;
    private final SortCourseFactory sortCourseFactory;

    @Transactional()
    @Cacheable(value = "courses")
    public List<CourseResDto> getCourse(String keyword, String sortBy) {
        List<Course> courses = couserRepository.findByName(keyword)
                .orElseThrow(()->new ServiceRuntimeException(HttpStatus.valueOf(403),
                ErrorCodes.USER_E001,
                String.format("Name course no exists: %s", keyword)));
        sortCourseFactory.createSort(courses, sortBy);
        return courses
                .stream()
                .map(c -> modelMapper.map(c, CourseResDto.class))
                .collect(Collectors.toList());
    }
}
