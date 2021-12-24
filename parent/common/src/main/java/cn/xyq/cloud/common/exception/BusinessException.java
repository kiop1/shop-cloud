package cn.xyq.cloud.common.exception;

import cn.xyq.cloud.common.resp.CodeMsg;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private CodeMsg codeMsg;

    public BusinessException(CodeMsg codeMsg) {
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
    }
}
