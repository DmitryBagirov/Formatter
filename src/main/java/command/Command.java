package command;

/**
 * Interface for Command.
 */
public interface Command {
    /**
     * handler.
     * @param c context
     * @throws CommandException err
     */
    void execute(Context c) throws CommandException;
}
