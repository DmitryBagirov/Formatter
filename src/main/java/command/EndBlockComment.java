package command;

import java.io.IOException;

/**
 * for }
 */
class EndBlockComment implements Command {
    /**
     * handler.
     * @param c context
     */
    public void execute(final Context c) {
        try {
            if (c.nextChar == '/') {
                c.w.writeChar('*');
                c.w.writeChar('/');
                c.w.writeChar('\n');
                c.nextChar = c.r.readChar();
                //nextChar = r.readChar();
                return;
            }
            c.w.writeChar(c.currentChar);
        } catch (IOException ignored) {

        }
    }
}
