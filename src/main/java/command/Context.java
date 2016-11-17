package command;

import com.company.IReader;
import com.company.IWriter;

import java.io.IOException;

/**
 * Context
 */
public class Context {
    /**
     * flags.
     */
    boolean isString, isComment;
    /**
     * blocks level.
     */
    int level;
    /**
     * writer.
     */
    public IWriter w;
    /**
     * reader.
     */
    IReader r;
    /**
     * current and next chars.
     */
    public char nextChar, currentChar;

    /**
     * constructor.
     * @param w writer
     * @param r reader
     */
    public Context(final IWriter w, final IReader r) {
        this.w = w;
        this.r = r;
    }

    /**
     * write tabs.
     */
    void writeTabs() {
        for (int i = 0; i < level; ++i) {
            try {
                w.writeChar('\t');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
