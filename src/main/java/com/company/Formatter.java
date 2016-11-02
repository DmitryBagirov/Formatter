package com.company;

import java.io.IOException;

/**
 * code formatter.
 */
final class Formatter implements IFormatter {
    /**
     *
     */
    Formatter() {
    }

    /**
     * format code.
     *
     * @param in  input file name
     * @param out output file name
     * @throws IOException err
     */
    public void format(final String in, final String out) throws IOException {
        int level = 0;
        Reader r = new Reader(in);
        Writer w = new Writer(out);
        char ch;
        while (r.hasChars()) {
            ch = r.readChar();
            if (ch < ' ') {
                continue;
            }
            switch (ch) {
                case '{':
                    level++;
                    w.writeChar(ch);
                    w.writeChar('\n');
                    for (int i = 0; i < level; ++i) {
                        w.writeChar('\t');
                    }
                    break;
                case '}':
                    level--;
                    //formattedString.deleteCharAt(formattedString.length() - 1)
                    w.writeChar(ch);
                    w.writeChar('\n');
                    for (int i = 0; i < level; ++i) {
                        w.writeChar('\t');
                    }
                    break;
                case ';':
                    w.writeChar(ch);
                    w.writeChar('\n');
                    boolean app = false;
                    if (r.readChar() == '}') {
                        level--;
                        app = true;
                    }
                    for (int i = 0; i < level; ++i) {
                        w.writeChar('\t');
                    }
                    if (app) { // додумать нормальный вариант
                        w.writeChar('}');
                        w.writeChar('\n');
                    }
                    break;
                default:
                    w.writeChar(ch);
                    break;
            }
        }
        w.close();
    }
}
