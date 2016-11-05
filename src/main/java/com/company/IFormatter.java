package com.company;

import java.io.IOException;

/**
 * Interface for formatter.
 */

interface IFormatter {
    /**
     * format code.
     *
     * @param r  input
     * @param w  output
     * @throws IOException err
     */
    void format(IReader r, IWriter w) throws IOException;
}
