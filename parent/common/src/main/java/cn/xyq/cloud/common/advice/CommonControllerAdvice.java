package cn.xyq.cloud.common.advice;

import cn.xyq.cloud.common.exception.BusinessException;
import cn.xyq.cloud.common.resp.CodeMsg;
import cn.xyq.cloud.common.resp.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CommonControllerAdvice {

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception ex) {
        ex.printStackTrace();
        return Result.defaultError();
    }

    @ExceptionHandler(BusinessException.class)
    public Result<?> businessHandleException(BusinessException ex) {
        CodeMsg codeMsg = ex.getCodeMsg();
        System.out.println("1111");
        System.err.println("[business exception] business handle failed, code msg is:{code:" + codeMsg.getCode() + ", msg:" + codeMsg.getMsg() + "}");
        return Result.error(codeMsg);
    }
}
