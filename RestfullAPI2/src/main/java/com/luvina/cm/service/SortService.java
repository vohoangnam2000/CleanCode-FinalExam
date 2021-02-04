package com.luvina.cm.service;

import com.luvina.cm.entity.Course;
import com.luvina.cm.strategies.SortStrategy;

import java.util.List;

public class SortService {
    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.sortStrategy = strategy;
    }

    public List<Course> sort(List<Course> courses) {
        return sortStrategy.sort(courses);
    }
}
