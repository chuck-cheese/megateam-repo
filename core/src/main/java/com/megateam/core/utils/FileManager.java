package com.megateam.core.utils;

import com.megateam.core.exceptions.FileException;
import java.io.File;

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
}
