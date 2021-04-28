package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.StudentMarks;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {

}