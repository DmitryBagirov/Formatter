package command;

import java.io.IOException;

/**
 * for ;
 */
class Semicolon implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            c.w.writeChar(c.currentChar);
            if (c.isComment || c.isString) {
                return;
            }
            if (c.nextChar != '/') {
                c.w.writeChar('\n');
                c.writeTabs();
            }
        } catch (IOException ignored) {

        }
    }
}
