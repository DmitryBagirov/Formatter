package formatter;

/**
 * Exception for formatter.
 */
public class FormatterException extends Exception {
    /**
     * default constructor.
     */
    public FormatterException() {
    }

    /**
     * constructor with message.
     * @param message message
     */
    public FormatterException(final String message) {
        super(message);
    }
}
