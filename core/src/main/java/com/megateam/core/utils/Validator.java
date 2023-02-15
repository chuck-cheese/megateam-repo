package com.megateam.core.utils;

import com.megateam.core.exceptions.InvalidInputException;

public class Validator
{

	public static boolean validateInput(String userInput) throws InvalidInputException
	{
		if ("".equals(userInput))
			throw new InvalidInputException("Please enter non-empty command");

		return true;
	}

}
