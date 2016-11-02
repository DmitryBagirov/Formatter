package com.company;

import java.io.IOException;

/**
 * Interface for formatter.
 */

interface IFormatter {
    /**
     * format code.
     *
     * @param in  input file name
     * @param out output file name
     * @throws IOException err
     */
    void format(String in, String out) throws IOException;
}
