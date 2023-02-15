package com.megateam.core.utils;

import static org.junit.Assert.*;

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
}
