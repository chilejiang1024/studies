package main.java8.tricks;

import java.security.MessageDigest;

import static java.lang.System.out;

/**
 * Title : main.java8.tricks <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/20 17:40
 */
public class StringToMD5 {

    /**
     * 十六进制下数字到字符的映射数组
     */
    private final static String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**
     * get MD5 string
     * @param originString origin string
     * @return MD5 with hex (length : 32)
     */
    private static String getMD5(String originString) {
        if (originString != null){
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(originString .getBytes());
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b  字节数组
     * @return 十六进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成16进制形式的字符串
     * @param b a byte
     * @return the hex digit for the byte
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    public static void main(String[] args) {
        String s = "heheda";
        String md5 = getMD5(s);
        out.println(md5);
    }

}
