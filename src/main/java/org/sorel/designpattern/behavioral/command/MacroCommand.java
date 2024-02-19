package org.sorel.designpattern.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    private Deque<Command> commandStack = new ArrayDeque<>();

    @Override
    public void execute() {
        for (Command command : commandStack) {
            command.execute();
        }
    }

    public void append(Command command) {
        if (command != this) {
            commandStack.push(command);
        }
    }

    public void undo() {
        if (!commandStack.isEmpty()) {
            commandStack.pop();
        }
    }

    public void clear() {
        commandStack.clear();
    }
}
