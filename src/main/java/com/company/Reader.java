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
     * @throws ReaderException throws when file not found
     */
    Reader(final String file) throws ReaderException {
        try {
            buffer = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new ReaderException("File can`t be read");
        }
    }

    /**
     * @return returns false if EOF otherwise true
     * @throws ReaderException error
     */
    public boolean hasChars() throws ReaderException {
        try {
            return buffer.ready();
        } catch (IOException e) {
            throw new ReaderException("No more chars");
        }
    }

    /**
     * @return read char from file
     * @throws ReaderException error
     */
    public char readChar() throws ReaderException {
        try {
            return (char) buffer.read();
        } catch (IOException e) {
            throw new ReaderException("Char can`t be read");
        }
    }
}
