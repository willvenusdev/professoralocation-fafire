package com.project.professor.alocation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.DayOfWeek;

@Entity
@Table(name = "allocation")
@Getter
@Setter
@NoArgsConstructor
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DayOfWeek day;
    private Time start;
    private Time end;

    public Allocation(Long id, DayOfWeek day, Time start, Time end) {
        this.id = id;
        this.day = day;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "id=" + id +
                ", day=" + day +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
