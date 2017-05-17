package ast.expr;

import ast.type.Type;
import ast.type.TypeArrow;
import ast.type.TypeVar;
import typing.*;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class Abs implements Exp {
    public String absVar;
    public Exp absBody;

    public Abs(String var, Exp body) {
        this.absVar = var;
        this.absBody = body;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        TypeVar alpha = tvPool.freshTV();
        TypeVar beta = tvPool.freshTV();
        env.add(absVar, alpha);
        absBody.inferType(env, beta, subst, tvPool);
        env.remove(absVar);
        Unify.unify(sigma, new TypeArrow(alpha, beta), subst);
    }
}
