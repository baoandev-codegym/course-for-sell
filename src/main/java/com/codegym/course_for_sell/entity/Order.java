package com.codegym.course_for_sell.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Float total;
    private Date date;
    private String status;
    @ManyToMany(mappedBy = "orders")
    private Set<Course> courses;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
