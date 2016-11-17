package command;

import java.io.IOException;

/**
 * for "
 */
class Str implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            c.w.writeChar(c.currentChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        c.isString = !c.isString;
    }
}
