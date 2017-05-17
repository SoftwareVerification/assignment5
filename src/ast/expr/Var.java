package ast.expr;

import ast.type.Type;
import typing.*;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class Var implements Exp {
    public String varId;

    public Var(String id) {
        this.varId = id;
    }

    @Override
    public void inferType(Environ env, Type sigma, Subst subst, TVPool tvPool) throws UnificationException {
        Type varType = env.get(varId);
        Unify.unify(sigma, varType, subst);
    }
}
