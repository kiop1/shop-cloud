package cn.xyq.cloud.common.utils;

import cn.xyq.cloud.common.exception.BusinessException;
import cn.xyq.cloud.common.resp.CodeMsg;

public class AssertUtil {

    /**
     * 对象非空判断，为空抛出异常
     *
     * @param obj     判断的对象
     * @param codeMsg 错误信息
     */
    public static void notNull(Object obj, CodeMsg codeMsg) {
        if (obj == null)
            throw new BusinessException(codeMsg);
    }

    /**
     * 字符串非空判断，为空抛出异常
     *
     * @param str     判断的字符串
     * @param codeMsg 错误信息
     */
    public static void hasLength(String str, CodeMsg codeMsg) {
        if (str == null || str.length() == 0)
            throw new BusinessException(codeMsg);
    }

    /**
     * 判断两个字符串是否相等，不相等则抛出异常
     *
     * @param str1
     * @param str2
     * @param codeMsg 错误信息
     */
    public static void notEquals(String str1, String str2, CodeMsg codeMsg) {
        if (!str1.equals(str2)) {
            throw new BusinessException(codeMsg);
        }
    }

}
