package com.megateam.core.resolvers.impl;
import com.megateam.core.resolvers.Resolver;
import com.megateam.core.utils.CommandSource;
import java.util.Arrays;
import java.util.List;


class ArgumentsResolver implements Resolver{
    @Override
    public List<String> resolveArguments(String command, CommandSource source){
        String commandLine = command.trim();
        String[] arrayCommand = commandLine.split(" ");
        String[] argumentsArray = Arrays.copyOfRange(arrayCommand, 1,arrayCommand.length );
        return Arrays.asList(argumentsArray);
    }
}



