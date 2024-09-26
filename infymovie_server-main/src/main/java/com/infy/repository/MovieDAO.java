package com.infy.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.MovieEntity;

public interface MovieDAO extends CrudRepository<MovieEntity, Integer> {
	public Optional<MovieEntity> findByName(String name);
}
