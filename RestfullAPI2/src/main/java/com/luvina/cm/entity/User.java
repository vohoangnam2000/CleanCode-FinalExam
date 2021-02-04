package com.luvina.cm.entity;

import lombok.Getter;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = ?1")
@NamedQuery(name = "User.findById", query = "select u from User u where u.id = ?1")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected String email;
    protected String password;

}
