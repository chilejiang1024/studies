package main.algorithm.a.jian.zhi.offer;

import static java.lang.System.out;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description : <br>
 *
 * 请实现一个函数, 将一个字符串中的空格替换成 `%20`
 * 例如, 当字符串为 `We Are Happy.` 则经过替换之后的字符串为 `We%20Are%20Happy.`
 *
 * 1 末尾填充占位符(每个空格填充2个占位符)
 *     We_Are_Happy____
 *
 * 2 双指针遍历
 *     We_Are_Happy____
 *                ^   ^
 *          <--  p1  p2
 *   p1, p2 同时向左遍历
 *   p1 指向的字符不是空格时与 p2 处的空格替换 (在有空格的时候, p2 始终指向最后一个空格)
 *   p1 指向的字符是空格时, 则将 p1, p1+1, p1+2 替换为 %20
 * @author chile
 * @version 1.0
 * @date 2018/4/11 14:05
 */
public class ReplaceBlankWith20 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("We Are Happy.");
        out.println(sb.toString());
        replace(sb);
        out.println(sb.toString());
    }

    private static void replace(StringBuilder sb) {
        int n = sb.length();
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        int p1 = n - 1, p2 = sb.length() - 1;
        while (p1 != -1 && p1 != p2) {
            if (sb.charAt(p1) == ' ') {
                sb.setCharAt(p1, '%');
                sb.setCharAt(p1 + 1, '2');
                sb.setCharAt(p1 + 2, '0');
                p1 += 2;
            } else {
                sb.setCharAt(p2--, sb.charAt(p1));
                sb.setCharAt(p1--, ' ');
            }
        }
    }

}
