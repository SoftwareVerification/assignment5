package ast.expr;

import ast.type.Type;
import typing.Environ;
import typing.Subst;
import typing.TVPool;
import typing.UnificationException;

public interface Exp {
    void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException;
}
