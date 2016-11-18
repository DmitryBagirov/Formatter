package command;

import java.util.HashMap;

/**
 * Conditions map.
 */
public class Map {
    /**
     * map of conditions.
     */
    private HashMap<Character, Command> conditions;

    /**
     * constructor.
     */
    public Map() {
        conditions = new HashMap<>();
        conditions.put('{', new OpenBrace());
        conditions.put(';', new Semicolon());
        conditions.put('}', new CloseBrace());
        conditions.put('*', new EndBlockComment());
        conditions.put('\n', new LineFeed());
        conditions.put('\r', new Other());
        conditions.put('/', new Comment());
        conditions.put('\"', new Str());
        conditions.put('\\', new Escape());
        conditions.put(null, new Other());
    }

    /**
     * @param key condition
     * @return command
     */
    public final Command get(final Character key) {
        if (conditions.containsKey(key)) {
            return conditions.get(key);
        }
        return conditions.get(null);
    }
}
