package examples;

import ast.expr.*;
import ast.type.Type;
import ast.type.TypeArrow;
import ast.type.TypeVar;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public interface Example {
    // (\x -> \y -> x y)(\x -> x)
    Exp prog1 =
            new App(new Abs("x", new Abs("y", new App(new Var("x"), new Var("y")))),
                    new Abs("x", new Var("x")));
    // (\x -> \y -> x z)
    Exp prog2 =
            new Abs("x", new Abs("y", new Abs("z", new App(new App(new Var("x"), new Var("z")), new App(new Var("y"), new Var("z"))))));
    Exp prog3 = new Abs("x", new App(new Abs("x", new Var("x")), new Var("x")));
    Exp prog4 = new Abs("x", new BinExp(BinOp.opLt, new Var("x"), new Var("x")));
    Type type1 =
            new TypeArrow(new TypeVar(0), new TypeArrow(new TypeVar(0), new TypeVar(1)));
    Type type2 =
            new TypeArrow(new TypeArrow(new TypeVar(1), new TypeVar(1)), new TypeVar(2));
    Type type3 =
            new TypeArrow(new TypeVar(0), new TypeVar(1));
    Type type4 =
            new TypeVar(0);
}
