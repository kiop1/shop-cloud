package cn.xyq.cloud.memberserver.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    private static final String inputSalt = "1a2b3c4";

    /**
     * 一次加盐md5
     *
     * @param password
     * @return
     */
    public static String inputPassToFormPass(String password) {
        password = "" + inputSalt.charAt(1) + inputSalt.charAt(2) + password + inputSalt.charAt(4) + inputSalt;
        return DigestUtils.md5Hex(password);
    }

    /**
     * 再次加盐md5
     *
     * @param password
     * @return
     */
    public static String formPassToDbPass(String password, String salt) {
        password = salt.charAt(1) + salt.charAt(2) + password + salt.charAt(4) + salt;
        return DigestUtils.md5Hex(password);
    }

    public static void main(String[] args) {
        String s = inputPassToFormPass("123456");
        System.out.println(s);
        System.out.println(formPassToDbPass(s, "1a2d3c4d"));
    }

}
