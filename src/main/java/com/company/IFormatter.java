package com.company;


/**
 * Interface for formatter.
 */

interface IFormatter {
    /**
     * format code.
     *
     * @param r  input
     * @param w  output
     * @throws FormatterException err
     */
    void format(IReader r, IWriter w) throws FormatterException;
}
