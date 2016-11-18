package command;

import java.io.IOException;

/**
 * for \n.
 */
 class LineFeed implements Command {
    /**
     * handler.
     * @param c context
     */
    public void execute(final Context c) {
        try {
            if (!c.isComment()) {
                return;
            }
            c.setIsComment(false);
            c.getW().writeChar(c.getCurrentChar());
            if (c.getNextChar() == '}') {
                return;
            }
            c.writeTabs();
        } catch (IOException ignored) {

        }
    }
}
