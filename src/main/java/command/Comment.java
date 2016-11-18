package command;

import java.io.IOException;

/**
 * for //.
 */
class Comment implements Command {
    /**
     * handler.
     * @param c context
     */
    public void execute(final Context c) {
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
        } catch (IOException ignored) {

        }
    }
}
