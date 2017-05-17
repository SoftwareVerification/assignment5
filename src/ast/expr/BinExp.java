package ast.expr;

import ast.type.Type;
import typing.*;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class BinExp implements Exp {
    public BinOp binExpOp;
    public Exp binOpLeft, binOpRight;

    public BinExp(BinOp binExpOp, Exp binOpLeft, Exp BinOpRight) {
        this.binExpOp = binExpOp;
        this.binOpLeft = binOpLeft;
        this.binOpRight = BinOpRight;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        BinOp.BinOpType bot = binExpOp.getType(tvPool);
        binOpLeft.inferType(env, bot.arg1type, subst, tvPool);
        binOpRight.inferType(env, bot.arg2type, subst, tvPool);
        Unify.unify(sigma, bot.restype, subst);
    }
}
