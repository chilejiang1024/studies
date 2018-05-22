package work.zhili.springboot2template.core.Status;

import com.google.gson.JsonObject;

/**
 * Title : work.zhili.springboot2template.core.Status <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
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
