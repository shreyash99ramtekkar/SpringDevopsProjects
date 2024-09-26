package com.infy.validator.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.infy.exception.MovieException;
import com.infy.validator.MovieValidator;

public class MovieValidatorTest {

	@Test
	public void validateRatingTestValidRating() throws Exception {
		MovieValidator.validateRating(5.5f);
	}

	@Test
	public void validateRatingTestInvalidRating() throws Exception {
		Exception ex = Assertions.assertThrows(MovieException.class, () -> MovieValidator.validateRating(10.5f));
		Assertions.assertEquals("MovieValidator.INVALID_RATING", ex.getMessage());
	}

}
