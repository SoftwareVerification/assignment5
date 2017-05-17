package ast.type;

import typing.Subst;
import typing.UnificationException;

import java.util.List;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class TypeVar implements Type {
    public int tvId;

    public TypeVar(int index) {
        this.tvId = index;
    }

    public boolean equals(Object otv) {
        return otv instanceof TypeVar && tvId == ((TypeVar) otv).tvId;
    }

    public Type substitute(Subst subst) {
        Type substType = subst.get(this);
        if (substType == null) {
            return this;
        } else {
            return substType.substitute(subst);
        }
    }

    public boolean containsTV(TypeVar tv) {
        return tvId == tv.tvId;
    }

    public void collectVars(List<TypeVar> vars) {
        if (!vars.contains(this)) {
            vars.add(this);
        }
    }

    public void unify(Type t, Subst subst) throws UnificationException {
        t.unify(this, subst);
    }

    public void unify(TypeArrow ta, Subst subst) throws UnificationException {
        if (ta.containsTV(this)) {
            throw new UnificationException(this, ta);
        }
        subst.add(this, ta);
    }

    public void unify(TypeConst tc, Subst subst) throws UnificationException {
        subst.add(this, tc);
    }

    public void unify(TypeVar tv, Subst subst) throws UnificationException {
        if (tvId != tv.tvId) {
            subst.add(this, tv);
        }
    }

    public String toString() {
        return Integer.toString(tvId);
    }
}
