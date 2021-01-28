package com.luvina.cm.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Student extends User{
    private int year;
}
