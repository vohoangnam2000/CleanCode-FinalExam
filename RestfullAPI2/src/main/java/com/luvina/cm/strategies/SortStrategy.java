package com.luvina.cm.strategies;

import com.luvina.cm.entity.Course;
import java.util.List;

public interface SortStrategy {
    List<Course> sort(List<Course> courses);
}
