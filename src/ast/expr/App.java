package ast.expr;

import ast.type.Type;
import ast.type.TypeArrow;
import ast.type.TypeVar;
import typing.Environ;
import typing.Subst;
import typing.TVPool;
import typing.UnificationException;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class App implements Exp {
    public Exp appFun, appArg;

    public App(Exp fun, Exp arg) {
        this.appFun = fun;
        this.appArg = arg;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        TypeVar alpha = tvPool.freshTV();
        appFun.inferType(env, new TypeArrow(alpha, sigma), subst, tvPool);
        appArg.inferType(env, alpha, subst, tvPool);
    }
}
