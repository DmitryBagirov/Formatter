package command;

import java.io.IOException;

/**
 * for ; .
 */
class Semicolon implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            c.getW().writeChar(c.getCurrentChar());
            if (c.isComment() || c.isString()) {
                return;
            }
            if (c.getNextChar() != '/') {
                c.getW().writeChar('\n');
                c.writeTabs();
            }
        } catch (IOException ignored) {

        }
    }
}
