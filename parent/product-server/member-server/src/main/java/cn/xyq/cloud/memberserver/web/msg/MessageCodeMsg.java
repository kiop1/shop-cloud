package cn.xyq.cloud.memberserver.web.msg;

import cn.xyq.cloud.common.resp.CodeMsg;

public class MessageCodeMsg extends CodeMsg {
    public MessageCodeMsg(int code, String msg) {
        super(code, msg);
    }

    public static final MessageCodeMsg USERNAME_NULL_MSG = new MessageCodeMsg(500100, "账号不能为空");
    public static final MessageCodeMsg USERNAME_ERROR_MSG = new MessageCodeMsg(500101, "账号或密码不正确");//账号不正确
    public static final MessageCodeMsg PASSWORD_ERROR_MSG = new MessageCodeMsg(500102, "账号或密码不正确");//密码不正确
}
