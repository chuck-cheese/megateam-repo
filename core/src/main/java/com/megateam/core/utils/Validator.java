package com.megateam.core.utils;

import com.megateam.core.data.Coordinates;
import com.megateam.core.data.TicketType;
import com.megateam.core.data.Venue;
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

	/**
	 * Method validates ticket fields
	 * @param name ticket name
	 * @param coordinates ticket coordinates
	 * @param price ticket price
	 * @param comment ticket comment
	 * @param refundable ticket refundable status
	 * @param type ticket type
	 * @param venue venue type
	 * @return true if all ticket fields are correct
	 * @throws InvalidInputException if one of specified ticket fields is incorrect
	 */
	public static boolean validateTicket(
		String name,
		Coordinates coordinates,
		Float price,
		String comment,
		boolean refundable,
		TicketType type,
		Venue venue
	) throws InvalidInputException {
		if (name == null) throw new InvalidInputException(
			"Ticket name cannot be null!"
		);

		if ("".equals(name.trim())) throw new InvalidInputException(
			"Ticket name cannot be empty string!"
		);

		if (price < 0) throw new InvalidInputException(
			"Ticket price should be greater than 0!"
		);

		if (comment == null) throw new InvalidInputException(
			"Ticket comment cannot be null!"
		);

		if ("".equals(comment.trim())) throw new InvalidInputException(
			"Ticket comment cannot be empty string!"
		);

		if (venue == null) throw new InvalidInputException(
			"Ticket venue cannot be null!"
		);

		return true;
	}
}
