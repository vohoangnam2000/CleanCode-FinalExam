package com.luvina.cm.strategies;

import com.luvina.cm.entity.Course;
import java.util.Collections;
import java.util.List;

public class SortByName implements SortStrategy {
    @Override
    public List<Course> sort(List<Course> courses) {
        Collections.sort(courses, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return courses;
    }
}
