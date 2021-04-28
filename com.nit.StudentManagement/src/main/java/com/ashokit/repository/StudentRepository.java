package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}