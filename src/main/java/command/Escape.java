package command;

import reader.ReaderException;
import writer.WriterException;


/**
 * for ".
 */
class Escape implements Command {
    /**
     * handler.
     * @param c Context
     * @throws CommandException err
     */
    public void execute(final Context c) throws CommandException {
        try {
            if (c.isString() && c.getNextChar() == '"') {
                c.getW().writeChar(c.getCurrentChar());
                c.getW().writeChar(c.getNextChar());
                c.setNextChar(c.getR().readChar());
                //return;
            }
            //c.setIsString(!c.isString());
        } catch (WriterException | ReaderException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in Escape");
        }
    }
}
