package ast.expr;

import ast.type.Type;
import ast.type.TypeConst;
import typing.Environ;
import typing.Subst;
import typing.TVPool;
import typing.UnificationException;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class If implements Exp {
    public Exp ifCond, ifThen, ifElse;

    public If(Exp ce, Exp te, Exp ee) {
        this.ifCond = ce;
        this.ifThen = te;
        this.ifElse = ee;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        ifCond.inferType(env, TypeConst.BoolType, subst, tvPool);
        ifThen.inferType(env, sigma, subst, tvPool);
        ifElse.inferType(env, sigma, subst, tvPool);
    }
}
