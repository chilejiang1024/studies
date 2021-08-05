package main.algorithm.leetcode;

/**
 * Description :
 *   <i>https://leetcode.com/problems/design-hashmap/submissions/</i>
 *   Runtime: 18 ms, faster than 62.03% of Java online submissions for Design HashMap.
 *   Memory Usage: 47.2 MB, less than 26.90% of Java online submissions for Design HashMap.
 *
 * @author chile
 * @version 1.0
 * @date 2021/8/5 15:54
 */
public class DesignHashMap {

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    class MyHashMap {

        private final int[] holder;

        /** Initialize your data structure here. */
        public MyHashMap() {
            holder = new int[1000001];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            holder[key] = value + 1;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return holder[key] - 1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            holder[key] = 0;
        }
    }

}
