package command;

import writer.WriterException;


/**
 * for {.
 */
class OpenBrace implements Command {
    /**
     * handler.
     * @param c Context
     * @throws CommandException err
     */
    public void execute(final Context c) throws CommandException {
        try {
            if (c.isComment() || c.isString()) {
                c.getW().writeChar(c.getCurrentChar());
                return;
            }
            c.incLevel();
            c.getW().writeChar(c.getCurrentChar());
            c.getW().writeChar('\n');
            c.writeTabs();
        } catch (WriterException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in OpenBrace");
        }
    }
}
