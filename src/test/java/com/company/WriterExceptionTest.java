package com.company;

import org.junit.Test;
import writer.WriterException;

/**
 * test for writer.
 */
public class WriterExceptionTest {

    @Test(expected = WriterException.class)
    public void writerException() throws WriterException {
        throw new WriterException("test");
    }

    @Test(expected = WriterException.class)
    public void writerExceptionDef() throws WriterException {
        throw new WriterException();
    }
}
