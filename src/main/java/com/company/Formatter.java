package com.company;
import command.Context;
import  command.Map;
import java.io.IOException;

/**
 * code formatter.
 */
final class Formatter implements IFormatter {
    /**
     * constructor lego.
     */
    Formatter() {

    }

    /**
     * format code.
     *
     * @param r  input
     * @param wr output
     * @throws IOException     err
     * @throws ReaderException err
     */
    public void format(final IReader r, final IWriter wr) throws IOException, ReaderException {
        Map m = new Map();
        Context c = new Context(wr, r);
        c.currentChar = r.readChar();
        while (r.hasChars()) {
            c.nextChar = r.readChar();
            m.get(c.currentChar).execute(c);
            c.currentChar = c.nextChar;
        }
        c.w.writeChar(c.currentChar);
        wr.close();
    }
}