package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for write to files.
 */
class Writer implements IWriter {
    /**
     * file.
     */
    private BufferedWriter buffer;

    /**
     * @param file file name
     * @throws IOException err
     */
    Writer(final String file) throws IOException {
        buffer = new BufferedWriter(new FileWriter(file));
    }

    /**
     * write char to file.
     *
     * @param ch character
     * @throws IOException err
     */
    public void writeChar(final char ch) throws IOException {
        buffer.append(ch);
    }

    /**
     * close file.
     *
     * @throws IOException err
     */
    public void close() throws IOException {
        buffer.close();
    }
}
