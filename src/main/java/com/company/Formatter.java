package com.company;

import java.io.IOException;

/**
 * code formatter.
 */
final class Formatter implements IFormatter {
    /**
     * next char from file.
     */
    private char nextChar;
    /**
     *
     */
    Formatter() {
    }

    /**
     * format code.
     *
     * @param r  input
     * @param w output
     * @throws IOException err
     */
    public void format(final IReader r, final IWriter w) throws IOException {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        while (r.hasChars()) {
            String test = safeReadString(r);
            for (char ch : test.toCharArray()) {
                if (ch < ' ') {
                    continue;
                }
                switch (ch) {
                    case '{':
                        level++;
                        sb.append(ch).append('\n');
                        for (int i = 0; i < level; ++i) {
                            sb.append('\t');
                        }
                        break;
                    case '}':
                        level--;
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append(ch);
                        sb.append('\n');
                        for (int i = 0; i < level; ++i) {
                            sb.append('\t');
                        }
                        break;
                    case ';':
                        sb.append(ch);
                        sb.append('\n');
                        for (int i = 0; i < level; ++i) {
                            sb.append('\t');
                        }
                        break;
                    default:
                        sb.append(ch);
                        break;
                }
            }
            w.writeString(sb.toString());
            sb.setLength(0);
        }
        w.close();
    }

    /**
     * safe read string to avoid errors in format().
     * @param r reader
     * @return string from file
     * @throws IOException error
     */
    public String safeReadString(final IReader r) throws IOException {
        StringBuilder buff = new StringBuilder();
        buff.append(nextChar);
        buff.append(r.readString());
        while (r.hasChars()) {
            nextChar = r.readChar();
            if (nextChar != '}') {
                break;
            }
            buff.append(nextChar);
        }
        return buff.toString();
    }

}
