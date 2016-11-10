package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Test for reader.
 */
public class ReaderTest {
    private Reader r;
    private BufferedReader rr;
    @Before
    public void setUp() throws Exception {
        r = new Reader("input");
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