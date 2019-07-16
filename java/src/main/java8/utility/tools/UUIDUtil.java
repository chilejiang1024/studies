package main.java8.utility.tools;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import static java.lang.System.out;

/**
 * Title : main.java8.utility.tools <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/7/16 13:34
 */
public class UUIDUtil {

    @Test
    public void testGenerate10() {
        UUIDUtil.generate10();
    }

    public static void generate10() {
        try {
            for (int i = 0; i < 10; i++) {
                UUID uuid = UUID.randomUUID();
                out.println(encrypt(uuid.toString()));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(str.getBytes());
        byte[] abResult = md5.digest();

        return byte2hex(abResult);
    }

    private static String byte2hex(byte[] data) {
        if (data == null) {
            return null;
        }
        return new String(Hex.encodeHex(data));
    }

}
