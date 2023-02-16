package com.megateam.core.executors.impl;

import com.megateam.core.commans.Command;
import com.megateam.core.exceptions.ExecutionException;
import com.megateam.core.executors.Executor;
import com.megateam.core.utils.CommandSource;
import com.megateam.core.utils.Printer;
import java.io.Reader;
import java.util.List;

public class CommandExecutor implements Executor {

	private final Reader in;
	private final Printer out;

	public CommandExecutor(Reader in, Printer out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public boolean execute(
		Command command,
		List<String> arguments,
		CommandSource source
	) throws ExecutionException {
		return command.setReader(in).setPrinter(out).execute(arguments);
	}
}
