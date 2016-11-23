package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Test for Formatter
 */
public class FormatterTest {

    private Formatter f;
    private Reader r;
    private Writer w;

    @Before
    public void setUp() throws IOException, ReaderException, WriterException {
        f = new Formatter();
        r = new Reader("input");
        w = new Writer("output");
    }

    @Test
    public void format() throws Exception {
        f.format(r, w);
        BufferedReader template = new BufferedReader(new FileReader("template"));
        BufferedReader result = new BufferedReader(new FileReader("output"));
        StringBuilder s2 = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        while (template.ready()) {
            s1.append((char)template.read());
        }
        while (result.ready()) {
            s2.append((char)result.read());
        }
        System.out.print(s1);
        assertEquals("Format", s1.toString(), s2.toString());
    }

}