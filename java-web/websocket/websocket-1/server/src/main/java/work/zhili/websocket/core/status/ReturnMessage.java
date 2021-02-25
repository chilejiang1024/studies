package work.zhili.websocket.core.status;

import com.alibaba.fastjson.JSONObject;

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
        JSONObject msg = new JSONObject();
        msg.put("code", 1);
        msg.put("msg", "Operation successful.");
        return msg.toString();
    }
}
