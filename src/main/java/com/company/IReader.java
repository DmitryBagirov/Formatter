package com.company;

import java.io.IOException;

/**
 * file reader.
 */
public interface IReader {
    /**
     * @return returns false if EOF otherwise true
     * @throws ReaderException error
     */
    boolean hasChars() throws  ReaderException;

    /**
     * @return read char from file
     * @throws IOException error
     */
    char readChar() throws IOException;
}
