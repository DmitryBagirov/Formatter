package command;

import java.io.IOException;

/**
 * for //
 */
class Comment implements Command {
    /**
     * handler.
     * @param c context
     */
    public void execute(final Context c) {
        try {
            if (c.nextChar == '/') {
                c.isComment = true;
                c.w.writeChar(c.currentChar);
                return;
            } else if (c.nextChar == '*') {
                c.w.writeChar('/');
                c.w.writeChar('*');
                c.nextChar = c.r.readChar();
                return;
            }
            c.w.writeChar(c.currentChar);
        } catch (IOException ignored) {

        }
    }
}
