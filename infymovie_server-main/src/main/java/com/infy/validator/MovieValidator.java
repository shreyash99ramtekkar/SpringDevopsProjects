package com.infy.validator;

import com.infy.exception.MovieException;

public class MovieValidator {

	public static void validateRating(Float rating) throws MovieException{
		if(rating>10 || rating<0){
			throw new MovieException("MovieValidator.INVALID_RATING");
		}
	}
}
