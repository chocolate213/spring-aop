package cn.jxzhang.demo.spring.common;

/**
 * ResponseMessage
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class ResponseMessage<T> {
    private T data;

    private String msg;

    private int code;

    private static final String SUCCESS = "success";

    public static <T> ResponseMessage<T> SUCCESS(T data) {
        return new ResponseMessage<>(data, SUCCESS, 0);
    }

    public static <T> ResponseMessage<T> SUCCESS() {
        return new ResponseMessage<>(null, SUCCESS, 0);
    }

    public ResponseMessage() {
    }

    private ResponseMessage(T data, String msg, int code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
