package com.megateam.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.megateam.core.data.Ticket;
import com.megateam.core.exceptions.FileException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {

	/**
	 * Method returns file for requested path
	 * @param filePath path to a file
	 * @return requested file
	 * @throws FileException if requested file not exists or is not a file
	 */
	public static File findFile(String filePath) throws FileException {
		File file = new File(filePath);

		if (!file.exists()) throw new FileException(
			"There is no file for requested path: " + filePath
		);

		if (!file.isFile()) throw new FileException(
			"You should specify an exact file"
		);

		return file;
	}

	/**
	 * Service method for generating xml string for concrete Ticket
	 * @param ticket is ticket to be converted to xml
	 * @return an xml string for exact ticket
	 * @throws JsonProcessingException if something gone wrong while convertation
	 */
	private static String readyToWriteTicket(Ticket ticket)
		throws JsonProcessingException {
		XmlMapper mapper = new XmlMapper();
		mapper.findAndRegisterModules();

		StringWriter writer = new StringWriter();
		return mapper.writeValueAsString(ticket);
	}

	/**
	 * Method saves a list of tickets into a specified file
	 * @param file where the list of tickets should appear
	 * @param tickets list of tickets
	 * @throws IOException if something gone wrong while creating FileOutputStream
	 */
	public static void saveToFile(File file, List<Ticket> tickets)
		throws IOException {
		try (FileOutputStream fos = new FileOutputStream(file)) {
			for (Ticket ticket : tickets) {
				if (ticket != null) {
					String outString = readyToWriteTicket(ticket) + '\n';
					fos.write(outString.getBytes());
				}
			}
		}
	}

	/**
	 * Service method for parsing an exact ticket from xml string
	 * @param ticketString ticket string in xml format
	 * @return returns an exact ticket for xml
	 * @throws JsonProcessingException if something gone wrong while parsing ticket
	 */
	private static Ticket readTicket(String ticketString)
		throws JsonProcessingException {
		XmlMapper mapper = new XmlMapper();
		mapper.findAndRegisterModules();

		return mapper.readValue(ticketString, Ticket.class);
	}

	/**
	 * Method parses a list of tickets from a specified file
	 * @param file file to read
	 * @return list of tickets parsed from file
	 * @throws IOException if something gone wrong while creating FileReader
	 */
	public static List<Ticket> getFromFile(File file) throws IOException {
		List<Ticket> tickets = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			List<String> lines = br.lines().toList();

			for (String ticketString : lines) {
				if (!"".equals(ticketString)) {
					tickets.add(readTicket(ticketString));
				}
			}
		}

		return tickets;
	}
}
