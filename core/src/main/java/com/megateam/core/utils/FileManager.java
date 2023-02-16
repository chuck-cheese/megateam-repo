package com.megateam.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.megateam.core.data.Ticket;
import com.megateam.core.exceptions.FileException;

import java.io.*;
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

	private static String readyToWriteTicket(Ticket ticket) throws JsonProcessingException
	{
		XmlMapper mapper = new XmlMapper();
		mapper.findAndRegisterModules();

		StringWriter writer = new StringWriter();
		return mapper.writeValueAsString(ticket);
	}

	public static void saveToFile(File file, List<Ticket> tickets) throws IOException
	{
		try (FileOutputStream fos = new FileOutputStream(file))
		{
			for (Ticket ticket : tickets)
			{
				if (ticket != null)
				{
					String outString = readyToWriteTicket(ticket) + '\n';
					fos.write(outString.getBytes());
				}
			}
		}
	}
}
