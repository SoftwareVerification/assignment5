package ast.expr;

import ast.type.Type;
import typing.*;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class UnaExp implements Exp {
    public UnaryOp unaOp;
    public Exp unaArg;

    public UnaExp(UnaryOp unaOp, Exp unaArg) {
        this.unaOp = unaOp;
        this.unaArg = unaArg;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        UnaryOp.UnaOpType uot = unaOp.getType(tvPool);
        unaArg.inferType(env, uot.argtype, subst, tvPool);
        Unify.unify(sigma, uot.restype, subst);
    }
}
