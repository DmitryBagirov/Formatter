package command;

import java.io.IOException;

/**
 * for }.
 */
class CloseBrace implements Command {
    /**
     * handler.
     * @param c context
     */
    public void execute(final Context c) {
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
        } catch (IOException ignored) {

        }
    }
}
