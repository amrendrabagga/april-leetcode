package practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheOptimum extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCacheOptimum(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheOptimum obj = new LRUCacheOptimum(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
