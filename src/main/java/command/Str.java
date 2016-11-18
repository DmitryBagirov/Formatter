package command;

import java.io.IOException;

/**
 * for ".
 */
class Str implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            c.getW().writeChar(c.getCurrentChar());
        } catch (IOException e) {
            e.printStackTrace();
        }
        c.setIsString(!c.isString());
    }
}
