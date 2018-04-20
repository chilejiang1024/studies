package main.algorithm.a.jian.zhi.offer;

import java.time.temporal.ChronoField;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description : <br>
 * read a number
 * ex. 1,2345         一万两千三百四十五
 *     1, 2312, 3123  一亿两千三百一十二万三千一百二十三
 * @author chile
 * @version 1.0
 * @date 2018-4-20 22:08:36
 */
public class ReadNumber {

    private static String[] NUMBER_2_HAN = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    private static String[] NORMAL_LEVEL = {"", "十", "百", "千"};

    private static String[] FORMAL_LEVEL = {"", "万", "亿"};

    public static void main(String[] args) {
        System.out.println(readTheNumber(123));
        System.out.println(readTheNumber(1234));
        System.out.println(readTheNumber(12345));
        System.out.println(readTheNumber(123456789));
        System.out.println(readTheNumber(1234567890));
        System.out.println(readTheNumber(0));
        System.out.println(readTheNumber(0000));
        System.out.println(readTheNumber(-12345));
        System.out.println(readTheNumber(10001));
        System.out.println(readTheNumber(10001001));
        System.out.println(readTheNumber(109030405));



    }

    private static String readTheNumber(int number) {
        StringBuilder builder = new StringBuilder();
        String numberStr = String.valueOf(number);
        if (number < 0) {
            builder.append("负");
            numberStr = numberStr.substring(1, numberStr.length());
        }
        char[] chars = numberStr.toCharArray();
        int length = chars.length;
        int level  = length / 4;
        int firstLevel = length - level * 4;

        for (int i = 0; i < firstLevel; i++) {
            builder.append(NUMBER_2_HAN[chars[i] - 48]);
            builder.append(NORMAL_LEVEL[firstLevel - i - 1]);
        }

        if (firstLevel * level > 0) {
            builder.append(FORMAL_LEVEL[level]);
        }

        for (int i = 0, k = 0; i < level; i++) {
            int index = firstLevel + i * 4;
            for (int j = 0; j < 4; j++) {
                if (chars[index + j] - '0' == 0) {
                    k++;
                } else {
                    if (k > 0) {
                        builder.append(NUMBER_2_HAN[0]);
                        k = 0;
                    }
                    builder.append(NUMBER_2_HAN[chars[index + j] - '0']);
                    builder.append(NORMAL_LEVEL[3 - j]);
                }
            }
            builder.append(FORMAL_LEVEL[level - i - 1]);
        }

        return builder.toString();
    }
}
