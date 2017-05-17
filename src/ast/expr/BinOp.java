package ast.expr;

import ast.type.Type;
import ast.type.TypeConst;
import typing.TVPool;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public enum BinOp {
    opPlus {
        @Override
        public BinOpType getType(TVPool tvPool) {
            return new BinOpType(TypeConst.IntType, TypeConst.IntType, TypeConst.IntType);
        }
    },
    opMin {
        @Override
        public BinOpType getType(TVPool tvPool) {
            return new BinOpType(TypeConst.IntType, TypeConst.IntType, TypeConst.IntType);
        }
    },
    opMul {
        @Override
        public BinOpType getType(TVPool tvPool) {
            return new BinOpType(TypeConst.IntType, TypeConst.IntType, TypeConst.IntType);
        }
    },
    opDiv {
        @Override
        public BinOpType getType(TVPool tvPool) {
            return new BinOpType(TypeConst.IntType, TypeConst.IntType, TypeConst.IntType);
        }
    },
    opEq {
        @Override
        public BinOpType getType(TVPool tvPool) {
            return new BinOpType(TypeConst.IntType, TypeConst.IntType, TypeConst.BoolType);
        }
    },
    opLt {
        @Override
        public BinOpType getType(TVPool tvPool) {
            return new BinOpType(TypeConst.IntType, TypeConst.IntType, TypeConst.BoolType);
        }
    };

    abstract public BinOpType getType(TVPool tvPool);

    public class BinOpType {
        public Type arg1type, arg2type, restype;

        public BinOpType(Type arg1type, Type arg2type, Type restype) {
            this.arg1type = arg1type;
            this.arg2type = arg2type;
            this.restype = restype;
        }
    }
}
