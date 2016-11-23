package com.company;


/**
 * file writer.
 */
public interface IWriter {
    /**
     * write char to file.
     *
     * @param ch character
     * @throws WriterException err
     */
    void writeChar(char ch) throws WriterException;

    /**
     * close file.
     *
     * @throws WriterException err
     */
    void close() throws WriterException;
}
