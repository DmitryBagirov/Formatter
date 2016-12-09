package reader;

/**
 * Exception for reader.
 */
public class ReaderException extends Exception {
    /**
     * default constructor.
     */
    public ReaderException() {
    }

    /**
     * constructor with message.
     * @param message message
     */
    public ReaderException(final String message) {
        super(message);
    }
}
