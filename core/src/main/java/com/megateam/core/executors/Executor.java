package com.megateam.core.executors;

import com.megateam.core.commans.Command;
import com.megateam.core.exceptions.ExecutionException;
import com.megateam.core.utils.CommandSource;
import java.io.File;
import java.util.List;

public interface Executor {
	default boolean execute(
		Command command,
		List<String> arguments,
		CommandSource source
	) throws ExecutionException {
		throw new ExecutionException("Execution failed!");
	}

	default boolean execute(File file) throws ExecutionException {
		throw new ExecutionException("Execution failed!");
	}
}
