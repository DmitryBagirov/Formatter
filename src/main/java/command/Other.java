package command;

import writer.WriterException;


/**
 * for other chars.
 */
class Other implements Command {
    /**
     * handler.
     * @param c Context
     * @throws CommandException err
     */
    public void execute(final Context c) throws CommandException {
        try {
            if (c.getCurrentChar() != '\r') {
                c.getW().writeChar(c.getCurrentChar());
            }
        } catch (WriterException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in Other");
        }
    }
}
