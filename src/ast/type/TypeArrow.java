package ast.type;

import typing.Subst;
import typing.UnificationException;

import java.util.List;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class TypeArrow implements Type {
    public Type taArg, taRes;

    public TypeArrow(Type arg, Type res) {
        this.taArg = arg;
        this.taRes = res;
    }

    public Type substitute(Subst subst) {
        return new TypeArrow(taArg.substitute(subst), taRes.substitute(subst));
    }

    public boolean containsTV(TypeVar var) {
        return taArg.containsTV(var) || taRes.containsTV(var);
    }

    public void collectVars(List<TypeVar> vars) {
        taArg.collectVars(vars);
        taRes.collectVars(vars);
    }

    public void unify(Type t, Subst subst) throws UnificationException {
        t.unify(this, subst);
    }

    public void unify(TypeArrow ta, Subst subst) throws UnificationException {
        taArg.unify(ta.taArg, subst);
        taRes.substitute(subst).unify(ta.taRes.substitute(subst), subst);
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
        return String.format("(%s) -> (%s)", taArg, taRes);
    }
}
