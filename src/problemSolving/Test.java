package problemSolving;

import java.util.LinkedHashMap;

public class Test {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        public Test(int capacity) {
            cap = capacity;
        }

        public void makeRecently(int key){
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key,val);
        }


        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            makeRecently(key);

            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
                cache.put(key,value);
                return;
            }
            if (cache.size() >= cap) {
                Integer oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);

            }
            cache.put(key,value);
        }

    public static void main(String[] args) {

        Test lRUCache = new Test(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4

    }

}
