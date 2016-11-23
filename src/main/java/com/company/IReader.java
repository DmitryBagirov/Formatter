package com.company;


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
     * @throws ReaderException error
     */
    char readChar() throws ReaderException;
}
