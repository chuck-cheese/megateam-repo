package com.megateam.core.resolvers.impl;


import com.megateam.core.commans.Command;
import com.megateam.core.resolvers.Resolver;
import com.megateam.core.utils.CommandSource;

import java.util.HashMap;
import java.util.Map;


class CommandResolver  implements Resolver {
    private final Map<String, Command> COMMAND_REGISTRY = new HashMap<>() {{


    }};
    @Override
    public Command resolveCommand(String command, CommandSource source) {
        String userInput = command.trim();
        String[] splittedUserInput = userInput.split(" ");

        if (COMMAND_REGISTRY.containsKey(splittedUserInput[0]))
            return COMMAND_REGISTRY.get(splittedUserInput[0]);

        return null;
    }
}