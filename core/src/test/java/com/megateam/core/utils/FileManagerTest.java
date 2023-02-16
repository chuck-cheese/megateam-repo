package com.megateam.core.utils;

import com.megateam.core.data.*;
import com.megateam.core.exceptions.FileException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
public class FileManagerTest
{

	private Coordinates coordinates;
	private Venue venue;
	private Ticket ticket;
	private File testingFile;

	@Before
	public void setup() throws FileException
	{
		coordinates = Coordinates
				.builder()
				.setX(1231F)
				.setY(12)
				.build();

		venue = Venue
				.builder()
				.setName("test")
				.setType(VenueType.BAR)
				.setCapacity(100L)
				.build();

		ticket = Ticket
				.builder()
				.setName("testTicket")
				.setComment("wowowow")
				.setCoordinates(coordinates)
				.setPrice(1000F)
				.setType(TicketType.VIP)
				.setRefundable(true)
				.setVenue(venue)
				.build();

		testingFile = FileManager.findFile("testing" + File.separator + "tests.xml");
	}

	@Test
	public void findFileTest()
	{
		try
		{
			File file = FileManager.findFile("testing" + File.separator + "tests.xml");
			assertNotNull(file);
			assertTrue(file.exists());
		}
		catch (FileException e)
		{
			assertTrue(false);
		}
	}

	@Test
	public void saveToFileTest()
	{
		List<Ticket> tickets = List.of(ticket, ticket, ticket);

		try
		{
			FileManager.saveToFile(testingFile, tickets);
			assertTrue(true);
		}
		catch (IOException e)
		{
			assertTrue(false);
		}
	}

}
