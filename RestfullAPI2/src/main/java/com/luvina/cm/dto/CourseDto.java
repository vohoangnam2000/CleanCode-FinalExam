package com.luvina.cm.dto;

import com.luvina.cm.enums.SortMode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Getter
@Setter
public class CourseDto {
    private int id;
    private String name;
    private String description;
    private String location;
    private String opened;
    private SortMode sortMode;
}
