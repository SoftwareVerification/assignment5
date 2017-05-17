package typing;

import ast.type.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class Environ {
    private Map<String, Stack<Type>> environ = new HashMap<>();

    public void add(String var, Type t) {
        Stack<Type> types = environ.get(var);
        if (types == null) {
            Stack<Type> newS = new Stack<>();
            newS.push(t);
            environ.put(var, newS);
        } else {
            types.push(t);
        }
    }

    public Type get(String var) {
        Stack<Type> types = environ.get(var);
        if (types == null) {
            return null;
        } else {
            return types.peek();
        }
    }

    public void remove(String var) {
        Stack<Type> types = environ.get(var);
        if (types != null) {
            types.pop();
        }
    }
}
