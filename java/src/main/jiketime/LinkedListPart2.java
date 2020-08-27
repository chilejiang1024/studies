package main.jiketime;

import org.junit.Test;

/**
 * Title : main.jiketime <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/8/27 10:00
 */
public class LinkedListPart2 {

    public int find(char[] a, char target) {
        int n = a.length;
        if (n == 0) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (target == a[i]) {
                return i;
            }
        }

        return -1;
    }

    public int find2(char[] a, char target) {
        int n = a.length, lastIndex = n - 1;
        if (n == 0) {
            return -1;
        }

        if (a[lastIndex] == target) {
            return lastIndex;
        }

        char lastOne = a[lastIndex];
        a[lastIndex] = target;

        int targetIndex = -1;
        // 注意此处, 不需要对i做边界值校验了
        // 每次循环都可以减少一次比较, 提升性能
        for (int i = 0; ; i++) {
            if (target == a[i]) {
                if (i < lastIndex) {
                    targetIndex = i;
                }
                break;
            }
        }

        a[lastIndex] = lastOne;
        return targetIndex;
    }

    @Test
    public void test1() {
        char[] a = {'1', 'w', 'p', 'l', 'a', 'c'};
        assert this.find(a, 'p') == 2;
        assert this.find(a, 'a') == 4;
        assert this.find(a, '1') == 0;
        assert this.find(a, 'f') == -1;
    }

    @Test
    public void test2() {
        char[] a = {'1', 'w', 'p', 'l', 'a', 'c'};
        assert this.find2(a, 'p') == 2;
        assert this.find2(a, 'a') == 4;
        assert this.find2(a, '1') == 0;
        assert this.find2(a, 'f') == -1;
    }

}
