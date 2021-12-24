package cn.xyq.cloud.common.advice;

import cn.xyq.cloud.common.exception.BusinessException;
import cn.xyq.cloud.common.resp.CodeMsg;
import cn.xyq.cloud.common.resp.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CommonControllerAdvice {

    private CodeMsg codeMsg;

    public CommonControllerAdvice(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception ex) {
        ex.printStackTrace();
        return Result.defaultError();
    }

    @ExceptionHandler(BusinessException.class)
    public Result<?> businessHandleException(Exception ex) {
        ex.printStackTrace();
        return Result.error(codeMsg);
    }
}
