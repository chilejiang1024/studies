package work.zhili.springcloud.eureka.core.http.response;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Title : com.thunisoft.assistant.core.http.response <br>
 * Description : <br>
 *  - 传说中的 api 返回值构造器
 *  -
 *
 * @author chile
 * @version 1.0
 * @date 2018-7-17 14:58:40
 */
public class HttpResponse<T> implements Serializable {

    private static final long serialVersionUID = -1882217090748851412L;

    private int code;

    private String msg;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpResponse(int code, String msg, T data) {
        setCode(code);
        setMsg(msg);
        setData(data);
    }

    public HttpResponse(HttpStatus status, T data) {
        this(status.value(), getStatusMessage(status), data);
    }

    public HttpResponse(HttpStatus status, String msg) {
        this(status.value(), msg);
    }

    public HttpResponse(HttpStatus status) {
        this(status.value(), getStatusMessage(status));
    }

    public HttpResponse(int code, String msg) {
        this(code, msg, null);
    }

    public static <T> HttpResponse success(T t) {
        return new HttpResponse(HttpStatus.OK, t);
    }

    public static HttpResponse success() {
        return success(null);
    }

    private static String getStatusMessage(HttpStatus status) {
        switch (status) {
            case OK:
                return "请求成功";
            case CREATED:
                return "创建成功";
            case NO_CONTENT:
                return "操作成功";
            case BAD_REQUEST:
                return "错误的请求";
            case UNAUTHORIZED:
                return "用户未登录";
            case FORBIDDEN:
                return "用户无权访问";
            case NOT_FOUND:
                return "找不到资源";
            case INTERNAL_SERVER_ERROR:
                return "请求出错";
            default:
                return status.getReasonPhrase();
        }
    }
}
