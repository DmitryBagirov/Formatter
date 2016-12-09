package command;

import reader.ReaderException;
import writer.WriterException;


/**
 * for //.
 */
class Comment implements Command {
    /**
     * handler.
     * @param c context
     * @throws CommandException err
     */
    public void execute(final Context c) throws CommandException {
        try {
            if (c.getNextChar() == '/') {
                c.setIsComment(true);
                c.getW().writeChar(c.getCurrentChar());
                return;
            } else if (c.getNextChar() == '*') {
                c.getW().writeChar('/');
                c.getW().writeChar('*');
                c.setNextChar(c.getR().readChar());
                return;
            }
            c.getW().writeChar(c.getCurrentChar());
        } catch (WriterException | ReaderException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in Comment");
        }
    }
}
