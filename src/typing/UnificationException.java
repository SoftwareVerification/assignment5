package typing;

import ast.type.Type;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class UnificationException extends Exception {
    public UnificationException(Type type1, Type type2) {
        super(String.format("Cannot unify %s with %s", type1, type2));
    }
}
