package main.algorithm.leetcode;

/**
 * Description :
 *   <i>https://leetcode.com/problems/design-hashset/submissions/</i>
 *   Runtime: 9 ms, faster than 100.00% of Java online submissions for Design HashSet.
 *   Memory Usage: 47.4 MB, less than 44.05% of Java online submissions for Design HashSet.
 *
 * @author chile
 * @version 1.0
 * @date 2021/8/5 13:31
 */
public class DesignHashSet {

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    class MyHashSet {

        private final byte[] holder;

        /** Initialize your data structure here. */
        public MyHashSet() {
            holder = new byte[1000001];
        }

        public void add(int key) {
            holder[key] = 1;
        }

        public void remove(int key) {
            holder[key] = 0;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return holder[key] == 1;
        }
    }

}
