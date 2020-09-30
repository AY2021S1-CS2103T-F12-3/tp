package tp.cap5buddy.parser;

import tp.cap5buddy.logic.commands.ResultCommand;

/**
 * Represents the super class of all Parser commands.
 */
public abstract class Parser {
    public abstract ResultCommand execute();
}

