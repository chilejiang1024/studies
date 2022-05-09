package main.interview.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2022/3/19 11:53
 */
public class Interview_2022_3_19 {

    public static void mainExample(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int countOfWord = 0, countOfCut = 0;
        boolean selected = false;
        // 注意 hasNext 和 hasNextLine 的区别
        // 1 a, 2 cc, 3 cx, 4 cv, 5 ca
        while (in.hasNextInt()) {
            // 注意 while 处理多个 case
            // int a = in.nextInt();
            // int b = in.nextInt();
            // System.out.println(a + b);
            int num = in.nextInt();
            switch (num) {
                case 1:
                    if (selected) {
                        countOfWord = 1;
                        selected = false;
                    } else {
                        countOfWord++;
                    }
                    break;
                case 2:
                    if (selected) {
                         countOfCut = countOfWord;
                         // selected = false;
                    } else {

                    }
                    break;
                case 3:
                    if (selected) {
                        countOfCut = countOfWord;
                        // selected = false;
                        countOfWord = 0;
                    } else {

                    }
                    break;
                case 4:
                    if (selected) {
                        countOfWord = countOfCut;
                        selected = false;
                        // countOfCut = 0;
                    } else {
                        countOfWord += countOfCut;
                        // countOfCut = 0;
                    }
                    break;
                case 5:
                    if (countOfWord > 0) {
                        selected = true;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(countOfWord);
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        // x#y = 2x + 3y + 4
        // x$y = 3x + y + 21
        // $ > # 左右顺序
        // 可以用int
        // 注意 hasNext 和 hasNextLine 的区别
        int result = 0;
        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while (in.hasNextLine()) {
            String input = in.nextLine();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '$') {
                    nums.add(Integer.valueOf(builder.toString()));
                    builder = new StringBuilder();
                    operators.add('$');
                    continue;
                }

                if (c == '#') {
                    nums.add(Integer.valueOf(builder.toString()));
                    builder = new StringBuilder();
                    operators.add('#');
                    continue;
                }
                builder.append(c);
                if (i == input.length() - 1) {
                    nums.add(Integer.valueOf(builder.toString()));
                }
            }
            break;
        }
        for (int i = 0, n = operators.size(); i < n; i++) {
            if (operators.get(i) == '$') {
                int tempResult = op2(nums.get(i), nums.get(i + 1));
                nums.set(i, tempResult);
                nums.remove(i + 1);
                operators.remove(i);
                i--;
                n--;
            }
        }

        for (int i = 0, n = operators.size(); i < n; i++) {
            if (operators.get(i) == '#') {
                int tempResult = op1(nums.get(i), nums.get(i + 1));
                nums.set(i, tempResult);
                nums.remove(i + 1);
                i--;
                n--;
            }
        }



        System.out.println(nums.get(0));
    }

    private static int op1(int x, int y) {
        return 2 * x + 3 * y + 4;
    }

    private static int op2(int x, int y) {
        return 3 * x + y + 2;
    }

}
