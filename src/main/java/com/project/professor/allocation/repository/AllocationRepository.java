package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository  extends JpaRepository<Allocation, Long> {

    List<Allocation> findByProfessor(Professor professor);

    List<Allocation> findByCourse(Course course);

}
