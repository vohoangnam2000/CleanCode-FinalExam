package com.luvina.cm.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "teacher")
@Data
public class Teacher extends User {
    private String phone;
    private int experiences;
}
