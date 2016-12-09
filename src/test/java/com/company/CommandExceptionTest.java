package com.company;

import command.CommandException;
import formatter.FormatterException;
import org.junit.Test;

/**
 * test for command exception.
 */
public class CommandExceptionTest {

    @Test(expected = CommandException.class)
    public void formatterException() throws CommandException {
        throw new CommandException("test");
    }

    @Test(expected = CommandException.class)
    public void formatterExceptionDef() throws CommandException {
        throw new CommandException();
    }
}
