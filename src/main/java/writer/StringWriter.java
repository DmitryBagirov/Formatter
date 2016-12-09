package writer;

/**
 * Class for write strings.
 */
public class StringWriter implements IWriter {

    /**
     * result string.
     */
    private StringBuilder result;

    /**
     * constructor.
     */
    public StringWriter() {
        result = new StringBuilder();
    }

    /**
     * write char.
     * @param ch character
     * @throws WriterException er
     */
    @Override
    public final void writeChar(final char ch) throws WriterException {
        result.append(ch);
    }

    /**
     * get string.
     * @return string
     */
    public final String getString() {
        return result.toString();
    }

    /**
     * close.
     * @throws WriterException err
     */
    @Override
    public void close() throws WriterException {
        //result = null;
    }
}
