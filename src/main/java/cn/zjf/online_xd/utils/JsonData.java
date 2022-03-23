package cn.zjf.online_xd.utils;

/**
 * 返回数据工具类
 * @author OneBird
 * @date 2022/3/18 17:20
 **/
public class JsonData {
    /**
     * code: 1:执行中   0:成功，-1:失败
     */
    private Integer code;
    private Object data;
    private String msg;

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 成功不返回数据
     * @return
     */
    public static JsonData buildSuccess(){
        return new JsonData(0,null,null);
    }

    /**
     * 成功且返回数据
     * @return
     */
    public static JsonData buildSuccess(Object object){
        return new JsonData(0,object,null);
    }

    /**
     * 失败，返回错误信息
     * @return
     */
    public static JsonData buildError(String msg){
        return new JsonData(-1,null,msg);
    }

    /**
     * 失败，返回错误信息和自定义状态码
     * @return
     */
    public static JsonData buildError(Integer code,String msg){
        return new JsonData(code,null,msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
