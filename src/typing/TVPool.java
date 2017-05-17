package typing;

import ast.type.TypeVar;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class TVPool {
    private int nextVarId = 0;

    public TypeVar freshTV() {
        return new TypeVar(nextVarId++);
    }
}
