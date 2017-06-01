package ast.expr;

import ast.type.Type;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
