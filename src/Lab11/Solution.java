package Lab11;

import java.util.*;

public class Solution {
    public static <T> ArrayList<T> newArrayList(Collection<T> elements) {
        return new ArrayList<>(elements);
    }

    public static <T> HashSet<T> newHashSet(Collection<T> elements) {
        return new HashSet<>(elements);
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size())
            throw new IllegalArgumentException();
        HashMap<K, V> res = new HashMap<>();
        for (int i = 0; i < keys.size(); i++)
            res.put(keys.get(i), values.get(i));
        return res;
    }
}