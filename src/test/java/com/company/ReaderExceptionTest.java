package com.company;

import org.junit.Test;
import reader.ReaderException;
import writer.WriterException;

/**
 * test for reader.
 */
public class ReaderExceptionTest {

    @Test(expected = ReaderException.class)
    public void readerException() throws ReaderException {
        throw new ReaderException("test");
    }
    @Test(expected = ReaderException.class)
    public void readerExceptionDef() throws ReaderException {
        throw new ReaderException();
    }
}
