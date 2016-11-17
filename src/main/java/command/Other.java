package command;

import java.io.IOException;

/**
 * for other chars
 */
class Other implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            if (c.currentChar != '\r') {
                c.w.writeChar(c.currentChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
