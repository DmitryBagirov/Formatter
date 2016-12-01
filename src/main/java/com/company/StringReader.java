package com.company;

/**
 * Class for read strings.
 */

public class StringReader implements IReader {
    /**
     * current position.
     */
    private int pos;
    /**
     * source string.
     */
    private String src;

    /**
     * Constructor.
     * @param str source string
     */
    public StringReader(final String str) {
        src = str;
    }

    /**
     * Check if is having char.
     * @return true if has char
     */
    public final boolean hasChars() {
        return pos < src.length();
    }

    /**
     * return next character.
     * @return next char
     */
    @Override
    public final char readChar() {
        return src.charAt(pos++);
    }
}
