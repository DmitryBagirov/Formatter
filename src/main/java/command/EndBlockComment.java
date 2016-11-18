package command;

import java.io.IOException;

/**
 * for }.
 */
class EndBlockComment implements Command {
    /**
     * handler.
     * @param c context
     */
    public void execute(final Context c) {
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
        } catch (IOException ignored) {

        }
    }
}
