package com.project.professor.allocation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.DayOfWeek;

@Entity
@Table(name = "allocation")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @ToString
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DayOfWeek day;
    private Time start;
    private Time end;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public DayOfWeek getDayOfWeek() {
        return day;
    }

    public Time getStartHour() {
        return start;
    }

    public Time getEndHour() {
        return end;
    }
}
