package command;

import java.io.IOException;

/**
 * for \n
 */
 class LineFeed implements Command {
    /**
     * handler.
     * @param c context
     */
    public void execute(final Context c) {
        try {
            if (!c.isComment) {
                return;
            }
            c.isComment = false;
            c.w.writeChar(c.currentChar);
            if (c.nextChar == '}') {
                return;
            }
            c.writeTabs();
        } catch (IOException ignored) {

        }
    }
}
