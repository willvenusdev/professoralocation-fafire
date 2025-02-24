package com.project.professor.alocation.repository;

import com.project.professor.alocation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long> {

    List<Department> findByNameContainingIgnoreCase(String location);

}
