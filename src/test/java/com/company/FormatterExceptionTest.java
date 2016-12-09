package com.company;

import formatter.FormatterException;
import org.junit.Test;
import formatter.Formatter;
import reader.Reader;
import reader.ReaderException;
import writer.Writer;
import writer.WriterException;

import static org.junit.Assert.assertEquals;

/**
 * test for formatter exception.
 */
public class FormatterExceptionTest {

    @Test(expected = FormatterException.class)
    public void formatterException() throws FormatterException {
        throw new FormatterException("test");
    }

    @Test(expected = FormatterException.class)
    public void formatterExceptionDef() throws FormatterException {
        throw new FormatterException();
    }
}
