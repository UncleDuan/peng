package algorithm.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by pengsel on 2019/3/12.
 * 1.继承了一个LinkedHashMap；
 * 2.设置其最大容量，这里要注意设置的最大容量除以0.75，防止出现重排；
 * 3.覆盖其removeEldestEntry方法，当容量大于设定最大容量时，删除该最旧数据；
 * 4.通过Collection.synchronizedMap()实现线程安全操作。
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_CACHE_SIZE;

    public LRUCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {

        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}