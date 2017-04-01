/**
 * Title : PACKAGE_NAME
 * Description :
 *  - 
 *  -  
 *
 * @author chile
 * @version 1.0
 * @date 2017/3/30 14:37
 */

public class Test {

    public static void main(String[] args) {
        String s = "Bertuggggg Mete";
        StringBuffer sb = new StringBuffer();
        for (int i = 0, j = s.length(); i < j; i++) {
            if (i == 0) {
                sb.append(s.charAt(0));
            }
            if (s.charAt(i) != sb.charAt(sb.length() - 1)) {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);
    }

}
