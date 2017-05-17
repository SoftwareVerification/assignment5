package ast.type;

import typing.Subst;
import typing.Unify;

import java.util.List;

public interface Type extends Unify {
    public abstract Type substitute(Subst subst);

    public default boolean containsTV(TypeVar var) {
        return false;
    }

    public default void collectVars(List<TypeVar> vars) {

    }
}
