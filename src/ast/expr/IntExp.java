package ast.expr;

import ast.type.Type;
import ast.type.TypeConst;
import typing.*;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class IntExp implements Exp {
    public int IntVal;

    public IntExp(int IntVal) {
        this.IntVal = IntVal;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        Unify.unify(sigma, TypeConst.IntType, subst);
    }
}
