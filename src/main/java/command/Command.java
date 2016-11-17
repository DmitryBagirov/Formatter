package command;

/**
 * Interface for Command.
 */
public interface Command {
    /**
     * handler.
     * @param c context
     */
    void execute(Context c);
}
