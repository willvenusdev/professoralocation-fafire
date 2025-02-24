package com.project.professor.alocation.repository;

import com.project.professor.alocation.entity.Department;
import com.project.professor.alocation.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository  extends JpaRepository<Professor, Long> {

    List<Professor> findByNameContainingIgnoreCase(String name);

    List<Professor> findByDepartment(Department department);

}
