package com.company;

import formatter.Formatter;
import formatter.FormatterException;
import org.junit.Before;
import org.junit.Test;
import reader.*;
import writer.*;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Test for Formatter
 */
public class FormatterTest {

    private Formatter f;

    @Before
    public void setUp() throws IOException, ReaderException, WriterException {
        f = new Formatter();
    }

    @Test
    public void format() throws Exception {
        /*f.format(r, w);
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
        assertEquals("Format", s1.toString(), s2.toString());*/
    }

    @Test
    public void bracers() throws FormatterException {
        reader.StringReader sr = new reader.StringReader("{test}");
        writer.StringWriter sw = new writer.StringWriter();
        f.format(sr, sw);
        assertEquals("{\n\ttest}", sw.getString());
    }
    @Test
    public void semicolon() throws FormatterException {
        reader.StringReader sr = new reader.StringReader("{test;}");
        writer.StringWriter sw = new writer.StringWriter();
        f.format(sr, sw);
        assertEquals("{\n\ttest;\n}", sw.getString());
    }
    @Test
    public void comment() throws FormatterException {
        reader.StringReader sr = new reader.StringReader("{test;//koko{}\n}");
        writer.StringWriter sw = new writer.StringWriter();
        f.format(sr, sw);
        assertEquals("{\n\ttest;//koko{}\n}", sw.getString());
    }
    @Test
    public void blockComment() throws FormatterException {
        reader.StringReader sr = new reader.StringReader("{/*tes*t;{}*/}");
        writer.StringWriter sw = new writer.StringWriter();
        f.format(sr, sw);
        assertEquals("{\n\t/*tes*t;\n\t{\n\t\t\t}*/\n}", sw.getString());
    }
    @Test
    public void string() throws FormatterException {
        reader.StringReader sr = new reader.StringReader("{/*test(\"/*;*/\");}");
        writer.StringWriter sw = new writer.StringWriter();
        f.format(sr, sw);
        assertEquals("{\n\t/*test(\"/*;*/\n\");\n}", sw.getString());
    }
}