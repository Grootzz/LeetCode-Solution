package interview.solution.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用LinkedHashMap实现LRU
 *
 * @author noodle
 * @date 2019/8/28 22:21
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static int MAX_ENTRY = 10;

    public LRUCache() {
        super(MAX_ENTRY, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRY;
    }
}