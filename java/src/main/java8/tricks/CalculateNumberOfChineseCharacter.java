package main.java8.tricks;

/**
 * Title : main.java8.tricks
 * Description :
 *  <p>
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/11 13:39
 */

public class CalculateNumberOfChineseCharacter {

    /**
     * calculate number of chinese character
     * @param words the string need to be calculated
     */
    private static void calculateNumberOfChineseCharacter(String words) {
        String regex = "[\u4e00-\u9fff]";
        String wordString = "嘿嘿啥嘿";
        String unmatchedString = " " + wordString + " ";
        int numberOfChineseCharacter = unmatchedString.split(regex).length - 1;
        System.out.println(numberOfChineseCharacter);
    }


}
