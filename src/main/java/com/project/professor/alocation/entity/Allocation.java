package com.project.professor.alocation.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.DayOfWeek;

@Entity
@Table(name = "allocation")
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

    public Allocation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
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
