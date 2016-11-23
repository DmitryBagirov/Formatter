package command;

/**
 * Exception for command.
 */
public class CommandException extends Exception {
    /**
     * default constructor.
     */
    public CommandException() {
    }

    /**
     * constructor with message.
     * @param message message
     */
    public CommandException(final String message) {
        super(message);
    }
}
