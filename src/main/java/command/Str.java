package command;

import com.company.WriterException;

/**
 * for ".
 */
class Str implements Command {
    /**
     * handler.
     * @param c Context
     * @throws CommandException err
     */
    public void execute(final Context c) throws CommandException {
        try {
            c.getW().writeChar(c.getCurrentChar());
        } catch (WriterException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in Str");
        }
        c.setIsString(!c.isString());
    }
}
