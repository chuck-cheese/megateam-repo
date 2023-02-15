package com.megateam.core.utils;

import com.megateam.core.exceptions.InvalidInputException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorTest
{

	@Test
	public void validateIncorrectInputTest()
	{
		try
		{
			Validator.validateInput("");
			assertTrue(false);
		}
		catch (InvalidInputException e)
		{
			assertEquals("Please enter non-empty command", e.getMessage());
		}
	}

	@Test
	public void validateCorrectInputTest()
	{
		try
		{
			assertTrue(Validator.validateInput("kek"));
		}
		catch (InvalidInputException ignored)
		{
			assertTrue(false);
		}
	}

}
