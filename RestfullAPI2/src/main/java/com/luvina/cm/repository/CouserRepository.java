package com.luvina.cm.repository;

import com.luvina.cm.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CouserRepository extends JpaRepository<Course, Integer> {
    @Query("SELECT c FROM Course c WHERE c.name LIKE CONCAT('%',:name,'%')")
    List<Course> findByName(@Param("name") String name);
}
