package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Dev;

public interface DevRepository extends JpaRepository<Dev,Integer> {

	public Boolean existsByName(String name);

}
