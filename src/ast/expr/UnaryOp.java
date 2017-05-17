package ast.expr;

import ast.type.Type;
import ast.type.TypeConst;
import typing.TVPool;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public enum UnaryOp {
    opNot {
        @Override
        public UnaOpType getType(TVPool tvPool) {
            return new UnaOpType(TypeConst.BoolType, TypeConst.BoolType);
        }
    };

    abstract public UnaOpType getType(TVPool tvPool);

    public class UnaOpType {
        public Type argtype, restype;

        public UnaOpType(Type argtype, Type restype) {
            this.argtype = argtype;
            this.restype = restype;
        }
    }
}
