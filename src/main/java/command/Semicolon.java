package command;

import com.company.WriterException;


/**
 * for ; .
 */
class Semicolon implements Command {
    /**
     * handler.
     * @param c Context
     * @throws CommandException er
     */
    public void execute(final Context c) throws CommandException {
        try {
            c.getW().writeChar(c.getCurrentChar());
            if (c.isComment() || c.isString()) {
                return;
            }
            if (c.getNextChar() == '}') {
                c.decLevel();
            }
            if (c.getNextChar() != '/') {
                c.getW().writeChar('\n');
                c.writeTabs();
            }
        } catch (WriterException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in Semicolon");
        }
    }
}
