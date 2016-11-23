package command;

import com.company.IReader;
import com.company.IWriter;
import com.company.WriterException;


/**
 * Context.
 */
public class Context {
    /**
     * string flag.
     */
    private boolean isString;
    /**
     * comment flag.
     */
    private boolean isComment;
    /**
     * level of hierarchy.
     */
    private int level;
    /**
     * writer.
     */
    private IWriter w;
    /**
     * reader.
     */
    private IReader r;
    /**
     * next char.
     */
    private char nextChar;
    /**
     * current char.
     */
    private char currentChar;

    /**
     * constructor.
     *
     * @param writer writer
     * @param reader reader
     */
    public Context(final IWriter writer, final IReader reader) {
        this.w = writer;
        this.r = reader;
    }

    /**
     * write tabs.
     * @throws WriterException err
     */
    final void writeTabs() throws WriterException {
        for (int i = 0; i < getLevel(); ++i) {
            getW().writeChar('\t');
        }
    }

    /**
     * flags.
     *
     * @return bool
     */
    public final boolean isString() {
        return isString;
    }

    /**
     * set context to string.
     * @param isStr bool
     */
    public final void setIsString(final boolean isStr) {
        this.isString = isStr;
    }

    /**
     * true if context is comment.
     * @return bool
     */
    public final boolean isComment() {
        return isComment;
    }

    /**
     * set context to comment.
     * @param comment bool
     */
    public final void setIsComment(final boolean comment) {
        isComment = comment;
    }

    /**
     * blocks level.
     *
     * @return level
     */
    public final int getLevel() {
        return level;
    }

    /**
     * decrease level of hierarchy.
     */
    public final void decLevel() {
        --this.level;
    }

    /**
     * increase level of hierarchy.
     */
    public final void incLevel() {
        ++this.level;
    }

    /**
     * writer.
     *
     * @return writer
     */
    public final IWriter getW() {
        return w;
    }

    /**
     * set writer.
     *
     * @param writer writer
     */
    public final void setW(final IWriter writer) {
        this.w = writer;
    }

    /**
     * reader.
     *
     * @return IReader
     */
    public final IReader getR() {
        return r;
    }

    /**
     * set reader.
     *
     * @param reader reader
     */
    public final void setR(final IReader reader) {
        this.r = reader;
    }

    /**
     * next and next chars.
     *
     * @return next char
     */
    public final char getNextChar() {
        return nextChar;
    }

    /**
     * current char.
     *
     * @return current char
     */
    public final char getCurrentChar() {
        return currentChar;
    }

    /**
     * set nextChar.
     * @param ch char
     */
    public final void setCurrentChar(final char ch) {
        this.currentChar = ch;
    }
    /**
     * set nextChar.
     * @param ch char
     */
    public final void setNextChar(final char ch) {
        this.nextChar = ch;
    }
}
