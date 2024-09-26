package com.infy.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.Movie;
import com.infy.service.MovieService;

@CrossOrigin 
@RestController
@RequestMapping("/MovieAPI")
public class MovieAPI {

	@Autowired
	private Environment environment;
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping(value = "/addMovie")
	public String addMovie(@Valid @RequestBody Movie movie) throws Exception{
		//added comment here for demo
		
		Integer movieId = movieService.addMovie(movie);
		return environment.getProperty("MovieAPI.MOVIE_ADDED_SUCCESS")+movieId;
	}
	@GetMapping(value = "/getAllMovies")
	public List<Movie> getAllMovies() throws Exception{
		return movieService.getAllMovies();
	}
	
	@PostMapping(value = "/updateMovieRating")
	public String updateMovieRating(@Valid @RequestBody Movie movie) throws Exception{
			movieService.updateMovieRating(movie.getMovieId(), movie.getRating());
			return environment.getProperty("MovieAPI.MOVIE_UPDATED_SUCCESS");
	}
	
	@DeleteMapping(value = "/deleteMovie/{movieId}")
	public String deleteMovie(@PathVariable(name="movieId") Integer movieId) throws Exception{
		movieService.deleteMovie(movieId);
		return environment.getProperty("MovieAPI.MOVIE_DELETED_SUCCESS");
	}
}
