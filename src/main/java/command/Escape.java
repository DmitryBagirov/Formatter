package command;

import java.io.IOException;

/**
 * for "
 */
class Escape implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            if (c.isString && c.nextChar == '"') {
                c.w.writeChar(c.currentChar);
                c.w.writeChar(c.nextChar);
                c.nextChar = c.r.readChar();
                return;
            }
            c.isString = !c.isString;
        } catch (IOException ignored) {

        }
    }
}
