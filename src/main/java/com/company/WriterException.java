package com.company;

/**
 * Exception for writer.
 */
public class WriterException extends Exception {
    /**
     * default constructor.
     */
    public WriterException() {
    }

    /**
     * constructor with message.
     * @param message message
     */
    public WriterException(final String message) {
        super(message);
    }
}
