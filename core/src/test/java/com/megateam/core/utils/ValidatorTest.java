package com.megateam.core.utils;

import static org.junit.Assert.*;

import com.megateam.core.data.VenueType;
import com.megateam.core.exceptions.InvalidInputException;
import org.junit.Test;

public class ValidatorTest {

	@Test
	public void validateIncorrectInputTest() {
		try {
			Validator.validateInput("");
			assertTrue(false);
		} catch (InvalidInputException e) {
			assertEquals("Please enter non-empty command", e.getMessage());
		}
	}

	@Test
	public void validateCorrectInputTest() {
		try {
			assertTrue(Validator.validateInput("kek"));
		} catch (InvalidInputException ignored) {
			assertTrue(false);
		}
	}

	@Test
	public void validateIncorrectCoordinatesTest() {
		try {
			Validator.validateCoordinates(-400, 0);
			assertTrue(false);
		} catch (InvalidInputException e) {
			assertEquals("X coordinate should be greater than -390", e.getMessage());
		}
	}

	@Test
	public void validateCorrectCoordinatesTest() {
		try {
			assertTrue(Validator.validateCoordinates(222, 0));
		} catch (InvalidInputException ignored) {
			assertTrue(false);
		}
	}

	@Test
	public void validateIncorrectVenueTest() {
		try {
			Validator.validateVenue("", 10L, VenueType.BAR);
			assertTrue(false);
		} catch (InvalidInputException e) {
			assertEquals("Venue name cannot be empty string!", e.getMessage());
		}
	}

	@Test
	public void validateCorrectVenueTest() {
		try {
			assertTrue(Validator.validateVenue("test", 100L, VenueType.BAR));
		} catch (InvalidInputException ignored) {
			assertTrue(false);
		}
	}
}
