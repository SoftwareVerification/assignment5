package ast.type;

import java.util.List;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class TypeScheme {
    public List<TypeVar> quantTVs;
    public Type schemeType;
}
