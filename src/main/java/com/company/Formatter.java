package com.company;

import java.io.IOException;

/**
 * code formatter.
 */
final class Formatter implements IFormatter {
    /**
     * next & last considered char from file.
     */
    private int level;
    /**
     * nextchar.
     */
    private char nextChar;
    /**
     * flags.
     */
    private boolean isString, isComment;
    /**
     * writer
     */
    private IWriter w;

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
    public void format(final IReader r, final IWriter wr)
            throws IOException, ReaderException {
        w = wr;
        String currStr;
        while (r.hasChars()) {
            currStr = safeReadString(r);
            for (int j = 0; j < currStr.length(); ++j) {
                char ch = currStr.charAt(j);
                switch (ch) {
                    case '{':
                        if (isComment || isString) {
                            w.writeChar(ch);
                            break;
                        }
                        level++;
                        w.writeChar(ch);
                        w.writeChar('\n');
                        writeTabs();
                        break;
                    case ';':
                        if (isComment || isString) {
                            w.writeChar(ch);
                            break;
                        }
                        w.writeChar(ch);
                        if (currStr.charAt(j + 1) != '/') {
                            w.writeChar('\n');
                            writeTabs();
                            break;
                        } else if (currStr.charAt(j + 1) == '}') {
                            w.writeChar('\n');
                            level--;
                            writeTabs();
                        }
                        break;
                    case '}':
                        if (isComment || isString) {
                            w.writeChar(ch);
                            break;
                        }
                        level--;
                        w.writeChar(ch);
                        if (j + 1 < currStr.length()
                                && currStr.charAt(j + 1) == '*') {
                            break;
                        }
                        w.writeChar('\n');
                        writeTabs();
                        break;
                    case '/':
                        if (currStr.charAt(j + 1) == '/') {
                            isComment = true;
                            w.writeChar(ch);
                            break;
                        } else if (currStr.charAt(j + 1) == '*') {
                            w.writeChar('/');
                            w.writeChar('*');
                            j++;
                            break;
                        }
                        w.writeChar(ch);
                        break;
                    case '*':
                        if (currStr.charAt(j + 1) == '/') {
                            w.writeChar('*');
                            w.writeChar('/');
                            w.writeChar('\n');
                            writeTabs();
                            j++;
                            break;
                        }
                        w.writeChar(ch);
                        break;
                    case '\r':
                        if (currStr.charAt(j + 1) == '\n') {
                            j++;
                        }
                    case '\n':
                        if (!isComment) {
                            break;
                        }
                        isComment = false;
                        w.writeChar(ch);
                        if (currStr.charAt(j + 1) == '}') {
                            level--;
                        }
                        writeTabs();
                        break;
                    case '"':
                        if (isString && currStr.charAt(j - 1) == '\\') {
                            w.writeChar(ch);
                            break;
                        }
                        isString = !isString;
                    default:
                        w.writeChar(ch);
                        break;
                }
            }
        }
        w.close();
    }

    /**
     * writes tabs.
     */
    private void writeTabs() throws IOException {
        for (int i = 0; i < level; ++i) {
            w.writeChar('\t');
        }
    }

    /**
     * safe read string to avoid errors in format().
     *
     * @param r reader
     * @return string from file
     * @throws IOException     error
     * @throws ReaderException error
     */
    String safeReadString(final IReader r) throws IOException, ReaderException {
        StringBuilder buff = new StringBuilder();
        char nextChar;
        while (r.hasChars()) {
            nextChar = r.readChar();
            if (nextChar != '}' && nextChar != '/' && nextChar != ' '
                    && nextChar != '\\' && nextChar != '"'
                    && nextChar != '\t' && nextChar != '\n'
                    && nextChar != ')' && nextChar != '*' && nextChar != ';'
                    && nextChar != '\r') {
                buff.append(nextChar);
                break;
            }
            buff.append(nextChar);
        }
        return buff.toString().replaceAll(" +", " ");
    }
}