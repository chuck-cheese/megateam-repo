package com.megateam.core.resolvers;

import com.megateam.core.commans.Command;
import com.megateam.core.exceptions.ResolvingException;
import com.megateam.core.utils.CommandSource;

import java.util.List;

public interface Resolver
{
	default Command resolveCommand(String command, CommandSource source) throws ResolvingException
	{
		throw new ResolvingException("Resolving is not possible!");
	};

	default List<String> resolveArguments(String command, CommandSource source) throws ResolvingException
	{
		throw new ResolvingException("Resolving is not possible!");
	}
}
