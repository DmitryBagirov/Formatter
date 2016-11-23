package command;

import com.company.ReaderException;
import com.company.WriterException;


/**
 * for }.
 */
class EndBlockComment implements Command {
    /**
     * handler.
     * @param c context
     * @throws CommandException err
     */
    public void execute(final Context c) throws CommandException {
        try {
            if (c.getNextChar() == '/') {
                c.getW().writeChar('*');
                c.getW().writeChar('/');
                c.getW().writeChar('\n');
                c.setNextChar(c.getR().readChar());
                //nextChar = r.readChar();
                return;
            }
            c.getW().writeChar(c.getCurrentChar());
        } catch (WriterException | ReaderException e) {
            throw new CommandException(e.getMessage()
                    + "\n" + "Error in EndBlockComment");
        }
    }
}
