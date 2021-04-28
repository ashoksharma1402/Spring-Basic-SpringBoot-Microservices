package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
