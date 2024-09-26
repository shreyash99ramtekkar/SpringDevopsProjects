package com.infy.service.test;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.Movie;
import com.infy.entity.MovieEntity;
import com.infy.exception.MovieException;
import com.infy.repository.MovieDAO;
import com.infy.service.MovieService;
import com.infy.service.MovieServiceImpl;

@SpringBootTest
public class MovieServiceTest {

	@Mock
	private MovieDAO movieDAO;

	@InjectMocks
	private MovieService movieService = new MovieServiceImpl();

	@Test
	public void addMovieValidTest() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(1111);
		movie.setRating(2.0f);

		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(1111);

		Mockito.when(movieDAO.findByName(Mockito.anyString())).thenReturn(Optional.empty());
		Mockito.when(movieDAO.save(Mockito.any(MovieEntity.class))).thenReturn(movieEntity);
		Integer actual = movieService.addMovie(movie);

		Assertions.assertEquals(1111, actual);
	}

	@Test
	public void addMovieInValidTest() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(9001);
		movie.setName("dfgt");
		movie.setRating(2.0f);

		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(9001);
		movieEntity.setName("jkzdghuf");
		movieEntity.setRating(1.1f);

		Optional<MovieEntity> optional = Optional.of(movieEntity);

		Mockito.when(movieDAO.findByName(Mockito.anyString())).thenReturn(optional);
		Mockito.when(movieDAO.save(Mockito.any(MovieEntity.class))).thenReturn(movieEntity);
		Exception actual = Assertions.assertThrows(MovieException.class, () -> movieService.addMovie(movie));
		Assertions.assertEquals("MovieService.MOVIE_NAME_ALREADY_PRESENT", actual.getMessage());
	}

	@Test
	public void getAllMoviesValidTest() throws Exception {
		MovieEntity me = new MovieEntity();
		me.setMovieId(1001);
		me.setName("This is the End");
		me.setRating(6.8f);
		List<MovieEntity> li = List.of(me);
		Iterable<MovieEntity> iterable = li;
		//Optional optional = Optional.of(iterable);

		Mockito.when(movieDAO.findAll()).thenReturn(iterable);
		List<Movie> actual = movieService.getAllMovies();
		Assertions.assertEquals(1, actual.size());
	}

	@Test
	public void updateMovieRatingValidTest() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(1111);
		movie.setRating(2.0f);

		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(1111);

		Mockito.when(movieDAO.findById(Mockito.anyInt())).thenReturn(Optional.of(movieEntity));
		Mockito.when(movieDAO.save(Mockito.any(MovieEntity.class))).thenReturn(movieEntity);
		movieService.updateMovieRating(1111, 2.0f);
	}

	@Test
	public void updateMovieRatingInValidTest() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(1111);
		movie.setRating(2.0f);

		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(1111);

		Mockito.when(movieDAO.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		Exception actual = Assertions.assertThrows(MovieException.class,
				() -> movieService.updateMovieRating(1111, 2.0f));
		Assertions.assertEquals("MovieService.MOVIE_NOT_FOUND", actual.getMessage());
	}

	@Test
	public void deleteMovieValidTest() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(1111);
		movie.setRating(2.0f);

		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(1111);

		Mockito.when(movieDAO.findById(Mockito.anyInt())).thenReturn(Optional.of(movieEntity));
		Mockito.when(movieDAO.save(Mockito.any(MovieEntity.class))).thenReturn(movieEntity);
		movieService.deleteMovie(1111);
	}

	@Test
	public void deleteMovieInValidTest() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(1111);
		movie.setRating(2.0f);

		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieId(1111);

		Mockito.when(movieDAO.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		Exception actual = Assertions.assertThrows(MovieException.class, () -> movieService.deleteMovie(1111));
		Assertions.assertEquals("MovieService.MOVIE_NOT_FOUND", actual.getMessage());
	}

}
