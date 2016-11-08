package com.company;

import java.io.IOException;

/**
 * file writer.
 */
interface IWriter {
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

    /**
     *
     * @param str string which need to write
     * @throws IOException error
     */
    void writeString(String str) throws IOException;
}
