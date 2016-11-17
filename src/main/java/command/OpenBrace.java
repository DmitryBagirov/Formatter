package command;

import java.io.IOException;

/**
 * for {
 */
class OpenBrace implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            if (c.isComment || c.isString) {
                c.w.writeChar(c.currentChar);
                return;
            }
            c.level++;
            c.w.writeChar(c.currentChar);
            c.w.writeChar('\n');
            c.writeTabs();
        } catch (IOException ignored) {

        }
    }
}
