package com.company;

import java.io.IOException;

/**
 * file writer.
 */
public interface IWriter {
    /**
     * write char to file.
     *
     * @param ch character
     * @throws IOException err
     */
    void writeChar(char ch) throws IOException;

    /**
     * close file.
     *
     * @throws IOException err
     */
    void close() throws IOException;
}
