package work.zhili.springboot2template.core.status;

import com.google.gson.JsonObject;

/**
 * Title : work.zhili.springboot2template.core.status <br>
 * Description : <br>
 *   <p> return message when the api request successfully
 *
 * @author chile
 * @version 1.0
 * @date 2018/5/22 13:13
 */
public class ReturnMessage {

    public static final String SUCCESSFUL_MESSAGE;

    static {
        SUCCESSFUL_MESSAGE = successfulMessage();
    }

    private static String successfulMessage() {
        JsonObject msg = new JsonObject();
        msg.addProperty("code", 1);
        msg.addProperty("msg", "Operation successful.");
        return msg.toString();
    }
}
