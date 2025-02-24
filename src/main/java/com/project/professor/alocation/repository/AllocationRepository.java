package com.project.professor.alocation.repository;

import com.project.professor.alocation.entity.Allocation;
import com.project.professor.alocation.entity.Course;
import com.project.professor.alocation.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository  extends JpaRepository<Allocation, Long> {

    List<Allocation> findByProfessor(Professor professor);

    List<Allocation> findByCourse(Course course);

}
