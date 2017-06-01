package ast.expr;

import ast.type.Type;
import ast.type.TypeArrow;
import ast.type.TypeTuple;
import ast.type.TypeVar;
import typing.*;

/**
 * @author Hendrik Werner s4549775
 */
public class Tuple implements Exp {
    public Exp fst;
    public Exp snd;

    public Tuple(Exp fst, Exp snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        TypeVar alpha1 = tvPool.freshTV();
        TypeVar alpha2 = tvPool.freshTV();
        fst.inferType(env, alpha1, subst, tvPool);
        snd.inferType(env, alpha2, subst, tvPool);
        Unify.unify(sigma, new TypeTuple(alpha1, alpha2), subst);
    }
}
