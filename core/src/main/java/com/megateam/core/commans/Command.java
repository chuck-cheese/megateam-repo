package com.megateam.core.commans;

import com.megateam.core.exceptions.ExecutionException;
import com.megateam.core.utils.CommandSource;
import com.megateam.core.utils.Printer;
import java.io.Reader;
import java.util.List;

public abstract class Command {

	private Reader reader;
	private Printer printer;
	protected CommandSource source;
	protected String name;
	protected String description;

	protected Command(String name, String description, CommandSource source) {
		this.name = name;
		this.description = description;
		this.source = source;
	}

	public Printer getPrinter() {
		return printer;
	}

	public Reader getReader() {
		return reader;
	}

	public Command setPrinter(Printer printer) {
		this.printer = printer;
		return this;
	}

	public Command setReader(Reader reader) {
		this.reader = reader;
		return this;
	}

	public String help() {
		return String.format("%s - %s", name, description);
	}

	public abstract boolean execute(List<String> arguments)
		throws ExecutionException;
}
