package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class for read from files.
 */
class Reader implements IReader {
    /**
     * file.
     */
    private BufferedReader buffer;

    /**
     * @param file Input file name
     * @throws FileNotFoundException throws when file not found
     */
    Reader(final String file) throws FileNotFoundException {
        buffer = new BufferedReader(new FileReader(file));
    }

    /**
     * @return returns false if EOF otherwise true
     * @throws IOException error
     */
    public boolean hasChars() throws IOException {
        return buffer.ready();
    }

    /**
     * @return read char from file
     * @throws IOException error
     */
    public char readChar() throws IOException {
        return (char) buffer.read();
    }
}
