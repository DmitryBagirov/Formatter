package command;

import com.company.WriterException;


/**
 * for }.
 */
class CloseBrace implements Command {
    /**
     * handler.
     *
     * @param c context
     * @throws CommandException err
     */
    public void execute(final Context c) throws CommandException {
        try {
            if (c.isComment() || c.isString()) {
                c.getW().writeChar(c.getCurrentChar());
                return;
            }
            c.decLevel();
            c.writeTabs();
            if (c.getNextChar() == '*') {
                c.getW().writeChar(c.getCurrentChar());
                return;
            }
            c.getW().writeChar(c.getCurrentChar());
            c.getW().writeChar('\n');
        } catch (WriterException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in CloseBrace");
        }
    }
}
