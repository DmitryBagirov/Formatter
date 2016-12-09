package com.company;

import org.junit.Before;
import org.junit.Test;
import reader.*;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Test for reader.
 */
public class ReaderTest {
    private reader.Reader r;
    private BufferedReader rr;
    @Before
    public void setUp() throws Exception {
        r = new reader.Reader("input");
        rr = new BufferedReader(new FileReader("input"));
    }

    @Test
    public void hasChars() throws ReaderException {
        assertEquals("hasChars", true, r.hasChars());
    }

    @Test
    public void readChar() throws Exception {
        assertEquals("readChar", (char) rr.read(), r.readChar());
    }
}