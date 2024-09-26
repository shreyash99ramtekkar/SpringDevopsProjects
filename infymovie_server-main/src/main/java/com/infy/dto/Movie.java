package com.infy.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class Movie {

	@Null(message = "Movie Id must be Null!!")
	private Integer movieId;
	@NotNull(message = "Movie Name must not be Null!!")
	@NotBlank(message = "Movie Name must not be Blank!!")
	@NotEmpty(message = "Movie Name must not be Empty!!")
	private String name;
	@NotNull(message = "Movie Rating must not be Null!!")
	private Float rating;
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
}
