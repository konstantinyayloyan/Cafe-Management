package com.cafemanagement.entity;

import javax.persistence.*;

@Entity
public class AdminUser extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int age;


}
