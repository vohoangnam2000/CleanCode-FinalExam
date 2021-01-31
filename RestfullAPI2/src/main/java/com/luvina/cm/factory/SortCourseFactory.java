package com.luvina.cm.factory;

import com.luvina.cm.entity.Course;
import com.luvina.cm.enums.SortMode;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SortCourseFactory {
    public void createSort(List<Course> courses, String sortType) {
        if (SortMode.NAME.toString().equals(sortType)) {
            sortByName(courses);
        } else if (SortMode.OPENED.toString().equals(sortType)) {
            sortByOpened(courses);
        } else {
            throw new UnsupportedOperationException("Unspported sort mode");
        }
    }

    public void sortByName(List<Course> courses) {
        Collections.sort(courses, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public void sortByOpened(List<Course> courses) {
        Collections.sort(courses, (o1, o2) -> o2.getOpened().compareTo(o1.getOpened()));
    }
}


