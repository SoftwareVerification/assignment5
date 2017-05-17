package typing;

import ast.type.Type;
import ast.type.TypeVar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class Subst {
    private Map<Integer, Type> tvMap;

    public Subst() {
        tvMap = new HashMap<Integer, Type>();
    }

    public void add(TypeVar tv, Type substType) {
        tvMap.put(tv.tvId, substType);
    }

    public void add(List<TypeVar> tvs, List<Type> substTypes) {
        Iterator<Type> typeIt = substTypes.iterator();
        for (TypeVar tv : tvs) {
            tvMap.put(tv.tvId, typeIt.next());
        }
    }

    public Type get(TypeVar tv) {
        return tvMap.get(tv.tvId);
    }
}
