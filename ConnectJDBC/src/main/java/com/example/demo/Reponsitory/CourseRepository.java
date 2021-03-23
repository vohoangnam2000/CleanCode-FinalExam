package com.example.demo.Reponsitory;

import com.example.demo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course,Integer> {

}
