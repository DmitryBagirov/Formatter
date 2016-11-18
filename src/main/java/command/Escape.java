package command;

import java.io.IOException;

/**
 * for ".
 */
class Escape implements Command {
    /**
     * handler.
     * @param c Context
     */
    public void execute(final Context c) {
        try {
            if (c.isString() && c.getNextChar() == '"') {
                c.getW().writeChar(c.getCurrentChar());
                c.getW().writeChar(c.getNextChar());
                c.setNextChar(c.getR().readChar());
                //return;
            }
            //c.setIsString(!c.isString());
        } catch (IOException ignored) {

        }
    }
}
