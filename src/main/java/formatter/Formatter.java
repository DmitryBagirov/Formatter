package formatter;
import command.CommandException;
import command.Context;
import  command.Map;
import reader.IReader;
import reader.ReaderException;
import writer.IWriter;
import writer.WriterException;

/**
 * code formatter.
 */
public final class Formatter implements IFormatter {
    /**
     * constructor lego.
     */
    public Formatter() {

    }

    /**
     * format code.
     *
     * @param r  input
     * @param wr output
     * @throws FormatterException err
     */
    public void format(final IReader r, final IWriter wr)
            throws  FormatterException {
        Map m = new Map();
        Context c = new Context(wr, r);
        try {
            c.setCurrentChar(r.readChar());
            while (r.hasChars()) {
                c.setNextChar(r.readChar());
                m.get(c.getCurrentChar()).execute(c);
                c.setCurrentChar(c.getNextChar());
            }
            c.getW().writeChar(c.getCurrentChar());
            wr.close();
        } catch (ReaderException | WriterException | CommandException e) {
            throw new FormatterException(e.getMessage());
        }
    }
}
