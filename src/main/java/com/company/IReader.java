package com.company;

import java.io.IOException;

/**
 * file reader.
 */
interface IReader {
    /**
     * @return returns false if EOF otherwise true
     * @throws IOException error
     */
    boolean hasChars() throws  IOException;

    /**
     * @return read char from file
     * @throws IOException error
     */
    char readChar() throws IOException;

    /**
     *
     * @return string from file
     * @throws IOException error
     */
    String readString() throws IOException;
}
