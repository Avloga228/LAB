package commandWithDescription;

import commands.Commands;

public class CommandWithDescription {
    String description;
    Commands.Command command;

    public CommandWithDescription(String description, Commands.Command command) {
        this.description = description;
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public Commands.Command getCommand() {
        return command;
    }

}
