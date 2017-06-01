package ast.expr;

import ast.type.Type;
import ast.type.TypeArrow;
import ast.type.TypeTuple;
import ast.type.TypeVar;
import typing.*;

/**
 * @author Hendrik Werner s4549775
 */
public class First implements Exp {
    public Exp tuple;

    public First(Exp tuple) {
        this.tuple = tuple;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        TypeVar alpha1 = tvPool.freshTV();
        TypeVar alpha2 = tvPool.freshTV();
        tuple.inferType(env, new TypeTuple(alpha1, alpha2), subst, tvPool);
        Unify.unify(sigma, alpha1, subst);
    }
}
