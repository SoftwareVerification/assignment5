package ast.type;

import typing.Subst;
import typing.Unify;

import java.util.List;

public interface Type extends Unify {
    Type substitute(Subst subst);

    default boolean containsTV(TypeVar var) {
        return false;
    }

    default void collectVars(List<TypeVar> vars) {

    }
}
