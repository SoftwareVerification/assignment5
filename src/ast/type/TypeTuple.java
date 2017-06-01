package ast.type;

import typing.Subst;
import typing.UnificationException;

import java.util.List;

/**
 * @author Hendrik Werner s4549775
 */
public class TypeTuple implements Type {
    public Type fst, snd;

    public TypeTuple(Type fst, Type snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public Type substitute(Subst subst) {
        return new TypeTuple(fst.substitute(subst), snd.substitute(subst));
    }

    public boolean containsTV(TypeVar var) {
        return fst.containsTV(var) || snd.containsTV(var);
    }

    public void collectVars(List<TypeVar> vars) {
        fst.collectVars(vars);
        snd.collectVars(vars);
    }

    public void unify(Type t, Subst subst) throws UnificationException {
        t.unify(this, subst);
    }

    @Override
    public void unify(TypeArrow ta, Subst subst) throws UnificationException {
        throw new UnificationException(ta, this);
    }

    public void unify(TypeTuple ta, Subst subst) throws UnificationException {
        fst.unify(ta.fst, subst);
        snd.unify(ta.snd, subst);
    }

    public void unify(TypeConst tc, Subst subst) throws UnificationException {
        throw new UnificationException(this, tc);
    }

    public void unify(TypeVar tv, Subst subst) throws UnificationException {
        if (!containsTV(tv)) {
            subst.add(tv, this);
        }
    }

    public String toString() {
        return String.format("(%s) -> (%s)", fst, snd);
    }
}
