package command;

import java.io.IOException;

/**
 * for {.
 */
class OpenBrace implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            if (c.isComment() || c.isString()) {
                c.getW().writeChar(c.getCurrentChar());
                return;
            }
            c.incLevel();
            c.getW().writeChar(c.getCurrentChar());
            c.getW().writeChar('\n');
            c.writeTabs();
        } catch (IOException ignored) {

        }
    }
}
