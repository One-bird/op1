package cn.zjf.online_xd.execption;

import cn.zjf.online_xd.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author OneBird
 * @date 2022/3/19 10:00
 **/
@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e){
        logger.error("系统异常，{}",e.getMessage());
        if (e instanceof XdException){
            XdException xdException = (XdException) e;
            return JsonData.buildError(xdException.getCode(),xdException.getMsg());
        }else {
            return JsonData.buildError("全局异常，未知错误");
        }
    }
}
