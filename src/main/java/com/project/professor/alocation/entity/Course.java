package com.project.professor.alocation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "name", nullable = false)
    private String name;
}
