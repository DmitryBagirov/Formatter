package command;

import com.company.WriterException;


/**
 * for \n.
 */
 class LineFeed implements Command {
    /**
     * handler.
     * @param c context
     * @throws CommandException err
     */
    public void execute(final Context c) throws CommandException {
        try {
            if (!c.isComment()) {
                return;
            }
            c.setIsComment(false);
            c.getW().writeChar(c.getCurrentChar());
            if (c.getNextChar() == '}') {
                return;
            }
            c.writeTabs();
        } catch (WriterException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in LineFeed");
        }
    }
}
