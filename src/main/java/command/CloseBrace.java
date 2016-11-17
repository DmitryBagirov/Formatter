package command;

import java.io.IOException;

/**
 * for }
 */
class CloseBrace implements Command {
    /**
     * handler.
     * @param c context
     */
    public void execute(final Context c) {
        try {
            if (c.isComment || c.isString) {
                c.w.writeChar(c.currentChar);
                return;
            }
            c.level--;
            c.writeTabs();
            if (c.nextChar == '*') {
                c.w.writeChar(c.currentChar);
                return;
            }
            c.w.writeChar(c.currentChar);
            c.w.writeChar('\n');
        } catch (IOException ignored) {

        }
    }
}
