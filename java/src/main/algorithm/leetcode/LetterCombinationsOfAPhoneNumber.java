package main.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/6/21 18:16
 */
public class LetterCombinationsOfAPhoneNumber {

    class Solution {

        private Map<Character, char[]> NUM_LETTER = new HashMap<>();

        {
            NUM_LETTER.put('2', new char[]{ 'a', 'b', 'c' });
            NUM_LETTER.put('3', new char[]{ 'd', 'e', 'f' });
            NUM_LETTER.put('4', new char[]{ 'g', 'h', 'i' });
            NUM_LETTER.put('5', new char[]{ 'j', 'k', 'l' });
            NUM_LETTER.put('6', new char[]{ 'm', 'n', 'o' });
            NUM_LETTER.put('7', new char[]{ 'p', 'q', 'r', 's' });
            NUM_LETTER.put('8', new char[]{ 't', 'u', 'v' });
            NUM_LETTER.put('9', new char[]{ 'w', 'x', 'y', 'z' });
        }

        private List<char[]> combine(List<char[]> tempChars, char[] chars, int location) {
            List<char[]> result = new ArrayList<>();
            for (int i = 0, n = tempChars.size(); i < n; i++) {
                for (int j = 0; j < chars.length; j++) {
                    char[] chars1 = Arrays.copyOf(tempChars.get(i), tempChars.get(i).length);
                    chars1[location] = chars[j];
                    result.add(chars1);
                }
            }
            return result;
        }
        
        public List<String> letterCombinations(String digits) {
            List<String> r = new ArrayList<>();

            if (digits == null || digits.length() == 0) {
                return r;
            }

            List<char[]> tempChars = new ArrayList<>();

            for (char c : NUM_LETTER.get(digits.charAt(0))) {
                char[] chars = new char[digits.length()];
                chars[0] = c;
                tempChars.add(chars);
            }

            for (int i = 1; i < digits.length(); i++) {
                tempChars = combine(tempChars, NUM_LETTER.get(digits.charAt(i)), i);
            }

            tempChars.forEach(chars -> r.add(String.valueOf(chars)));

            return r;
        }
    }

    @Test
    public void test1() {
        new Solution().letterCombinations("23").forEach(s -> System.out.println(s));
    }

}
