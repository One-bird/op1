package cn.zjf.online_xd.execption;

/**
 * @author OneBird
 * @date 2022/3/19 9:59
 **/
public class XdException extends RuntimeException {
    private Integer code;
    private String msg;

    public XdException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
