package com.infy.service;

import java.util.List;

import com.infy.dto.Movie;

public interface MovieService {

	public Integer addMovie(Movie movie) throws Exception;
	public List<Movie> getAllMovies() throws Exception;
	public void updateMovieRating(Integer movieId, Float rating) throws Exception;
	public void deleteMovie(Integer movieId) throws Exception;
	
}
