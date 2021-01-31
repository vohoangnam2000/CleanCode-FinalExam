package com.luvina.cm.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String location;
    private String opened;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Teacher> teachers = new ArrayList<>();


}
