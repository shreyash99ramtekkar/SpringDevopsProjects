package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.Movie;
import com.infy.entity.MovieEntity;
import com.infy.exception.MovieException;
import com.infy.repository.MovieDAO;
import com.infy.validator.MovieValidator;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieDAO;

	@Override
	public Integer addMovie(Movie movie) throws Exception {

		MovieValidator.validateRating(movie.getRating());
		Optional<MovieEntity> optional = movieDAO.findByName(movie.getName());
		if (optional.isPresent()) {
			throw new MovieException("MovieService.MOVIE_NAME_ALREADY_PRESENT");
		}

		MovieEntity entity = new MovieEntity();
		entity.setName(movie.getName());
		entity.setRating(movie.getRating());
		entity = movieDAO.save(entity);

		return entity.getMovieId();

	}

	@Override
	public List<Movie> getAllMovies() throws Exception {
		List<Movie> movies = new ArrayList<Movie>();
		Optional<Iterable<MovieEntity>> optional = Optional.of(movieDAO.findAll());
		if (optional.isPresent()) {
			Iterable<MovieEntity> iterable = optional.get();
			for (MovieEntity movie : iterable) {
				Movie movie2 = new Movie();
				movie2.setMovieId(movie.getMovieId());
				movie2.setName(movie.getName());
				movie2.setRating(movie.getRating());
				movies.add(movie2);
			}
		}
		return movies;
	}

	@Override
	public void updateMovieRating(Integer movieId, Float rating) throws Exception {
		MovieValidator.validateRating(rating);
		Optional<MovieEntity> optional = movieDAO.findById(movieId);
		if (!optional.isEmpty()) {
			MovieEntity movie = optional.get();
			movie.setRating(rating);
			movieDAO.save(movie);
		} else {
			throw new MovieException("MovieService.MOVIE_NOT_FOUND");
		}
	}

	@Override
	public void deleteMovie(Integer movieId) throws Exception {
		Optional<MovieEntity> optional = movieDAO.findById(movieId);
		if (optional.isPresent()) {
			movieDAO.delete(optional.get());
		} else {
			throw new MovieException("MovieService.MOVIE_NOT_FOUND");
		}
	}

}
