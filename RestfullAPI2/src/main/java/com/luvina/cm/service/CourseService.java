package com.luvina.cm.service;

import com.luvina.cm.dto.CourseResDto;
import com.luvina.cm.entity.Course;
import com.luvina.cm.error.ErrorCodes;
import com.luvina.cm.error.ServiceRuntimeException;
import com.luvina.cm.repository.CouserRepository;
import com.luvina.cm.strategies.SortByName;
import com.luvina.cm.strategies.SortByOpened;
import com.luvina.cm.strategies.SortStrategy;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final ModelMapper modelMapper;
    private final CouserRepository couserRepository;
    private static Map<String, SortStrategy> strategies;

    static {
        strategies = new HashMap<>();
        strategies.put("name", new SortByName());
        strategies.put("opened", new SortByOpened());
    }

    @Transactional()
    @Cacheable(value = "courses")
    public List<CourseResDto> getCourse(String keyword, String sortBy) {
        List<Course> courses = couserRepository.findByName(keyword)
                .orElseThrow(()->new ServiceRuntimeException(HttpStatus.valueOf(403),
                ErrorCodes.USER_E001,
                String.format("Name course no exists: %s", keyword)));
        SortStrategy sortingStrategy = lookupSortingStrategy(sortBy.toLowerCase(Locale.ROOT));
        courses = sortingStrategy.sort(courses);
        return courses
                .stream()
                .map(c -> modelMapper.map(c, CourseResDto.class))
                .collect(Collectors.toList());
    }
    private SortStrategy lookupSortingStrategy(String strategyName) {
        SortStrategy sortingStrategy = strategies.get(strategyName);
        if (sortingStrategy == null) {
            throw new UnsupportedOperationException("Unsupported sorting strategy");
        }
        return sortingStrategy;
    }
}
