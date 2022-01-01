package cn.xyq.cloud.memberserver.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static final String USER_TOKEN = "userToken";

    public static void addCookie(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setMaxAge(1800); //cookie存活时间
        response.addCookie(cookie);
    }
}
