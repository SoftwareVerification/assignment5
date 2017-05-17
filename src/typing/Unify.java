package typing;

import ast.type.Type;
import ast.type.TypeArrow;
import ast.type.TypeConst;
import ast.type.TypeVar;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public interface Unify {
    public static void unify(Type t1, Type t2, Subst subst) throws UnificationException {
        t1.substitute(subst).unify(t2.substitute(subst), subst);
    }

    public abstract void unify(Type t, Subst subst) throws UnificationException;

    public abstract void unify(TypeArrow ta, Subst subst) throws UnificationException;

    public abstract void unify(TypeConst ta, Subst subst) throws UnificationException;

    public abstract void unify(TypeVar ta, Subst subst) throws UnificationException;
}
