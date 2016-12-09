package com.company;


import formatter.Formatter;
import formatter.FormatterException;
import reader.Reader;
import reader.ReaderException;
import writer.Writer;
import writer.WriterException;

/**
 *
 */
final class MainClass {
    /**
     * singleton.
     */
    private MainClass() { }

    /**
     *
     * @param args params from command line
     * @throws WriterException exception
     * @throws ReaderException exception
     * @throws FormatterException exception
     */
    public static void main(final String[] args)
            throws ReaderException, WriterException, FormatterException {
        if (args.length < 2) {
            System.out.print("Error! PLease set input and "
                    + "output filename as parameter\n");
            return;
        }
        Formatter f = new Formatter();
        Writer w = new Writer(args[1]);
        Reader r = new Reader(args[0]);
        f.format(r, w);
    }
}
