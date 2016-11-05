package com.company;

import java.io.IOException;

/**
 *
 */
final class MainClass {
    /**
     * singleton.
     */
    private MainClass() {
        System.out.println("dv");
    }
    /**
     * @param args params from command line
     * @throws IOException erro
     */
    public static void main(final String[] args) throws IOException {
//        if (args.length < 2) {
//            System.out.print("Error! PLease set input and "
//                    + "output filename as parameter\n");
//            return;
//        }
        Formatter f = new Formatter();
        Reader r = new Reader("input");
        Writer w = new Writer("output");
        f.format(r, w);
    }
}
