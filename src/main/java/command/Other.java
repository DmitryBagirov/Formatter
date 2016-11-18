package command;

import java.io.IOException;

/**
 * for other chars.
 */
class Other implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            if (c.getCurrentChar() != '\r') {
                c.getW().writeChar(c.getCurrentChar());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
