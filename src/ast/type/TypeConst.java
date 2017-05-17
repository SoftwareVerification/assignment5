package ast.type;

import typing.Subst;
import typing.UnificationException;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public enum TypeConst implements Type {
    IntType, BoolType;

    public Type substitute(Subst subst) {
        return this;
    }

    public void unify(Type t, Subst subst) throws UnificationException {
        t.unify(this, subst);
    }

    public void unify(TypeArrow ta, Subst subst) throws UnificationException {
        throw new UnificationException(this, ta);
    }

    public void unify(TypeConst tc, Subst subst) throws UnificationException {
        if (this != tc) {
            throw new UnificationException(this, tc);
        }
    }

    public void unify(TypeVar tv, Subst subst) throws UnificationException {
        subst.add(tv, this);
    }

}
