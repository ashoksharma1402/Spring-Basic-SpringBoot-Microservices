package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Tourist;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {

}
