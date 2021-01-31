package com.luvina.cm.dto;

import com.luvina.cm.enums.SortMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseReqDto {
    private String name;
    private SortMode sortMode;
}
