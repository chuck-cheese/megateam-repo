package com.megateam.core.utils;

import java.util.List;

public class Input {

	String command;
	List<String> arguments;
	CommandSource source;

	public void Input(
		String command,
		List<String> arguments,
		CommandSource source
	) {
		this.command = command;
		this.arguments = arguments;
		this.source = source;
	}

	public List<String> getArguments() {
		return arguments;
	}

	public CommandSource getSource() {
		return source;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setArguments(List<String> arguments) {
		this.arguments = arguments;
	}

	public void setSource(CommandSource source) {
		this.source = source;
	}
}
