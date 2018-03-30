package main.java8.tricks;

/**
 * Title : main.java8.tricks <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/30 14:04
 */
public class LoopCondition {

    /**
     * i--的循环条件
     * 14: e2500001 subs r0, r0, #1 ; 0x1
     * 18: 1afffffc bne 10 <loop_dec+0x10>
     *
     * i++的循环条件
     * 3c: e2833001 add r3, r3, #1 ; 0x1
     * 40: e1500003 cmp r0, r3
     * 44: 1afffffb bne 38 <loop_inc+0x14>
     *
     * 使用i--比i++少了一个cmp指令
     *
     */
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        int arrayLength = array.length;

        for (int i = arrayLength; i > 0; i--) {
            System.out.println(array[i - 1]);
        }

        for (int i = 0; i < arrayLength; i++) {
            System.out.println(array[i]);
        }
    }

}
