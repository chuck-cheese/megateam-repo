package com.megateam.core.utils;

import com.megateam.core.data.VenueType;
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

	/**
	 * Methods validates coordinates fields
	 * @param x X-Coord value
	 * @param y Y-Coord value
	 * @return true if coordinates are correct
	 * @throws InvalidInputException if specified coordinates are incorrect
	 */
	public static boolean validateCoordinates(float x, int y)
		throws InvalidInputException {
		if (x < -390) throw new InvalidInputException(
			"X coordinate should be greater than -390"
		);

		return true;
	}

	/**
	 * Method validates venue fields
	 * @param name venue name
	 * @param capacity venue capacity
	 * @param type venue type from VenueType
	 * @return true if venue is correct
	 * @throws InvalidInputException if specified venue fields are invalid
	 */
	public static boolean validateVenue(
		String name,
		long capacity,
		VenueType type
	) throws InvalidInputException {
		if (name == null) throw new InvalidInputException(
			"Venue name cannot be not null!"
		);

		if (type == null) throw new InvalidInputException(
			"Venue type cannot be null!"
		);

		if ("".equals(name.trim())) throw new InvalidInputException(
			"Venue name cannot be empty string!"
		);

		if (capacity < 0) throw new InvalidInputException(
			"Venue capacity should be greater than 0!"
		);

		return true;
	}
}
