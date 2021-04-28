package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.CarModel;

@Repository
public interface CarModelReposotory extends JpaRepository<CarModel, Long> {

}
