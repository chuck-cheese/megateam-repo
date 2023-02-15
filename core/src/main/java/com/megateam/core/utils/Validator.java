package com.megateam.core.utils;

import com.megateam.core.exceptions.InvalidInputException;

public class Validator {

	/**
	 * Method validates string being reliable for usage in command resolving
	 * @param userInput user input string for validation
	 * @return true if userInput is correct
	 * @throws InvalidInputException if userInput is incorrect
	 */
	public static boolean validateInput(String userInput)
		throws InvalidInputException {
		if ("".equals(userInput.trim())) throw new InvalidInputException(
			"Please enter non-empty command"
		);

		return true;
	}
}
