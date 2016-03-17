package cn.edu.tju.scs.fm.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jack on 2015/10/16.
 */
public class CookieUtil {

    public static String getCookie(String cookieName,HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void deleteCookie(String cookieName,HttpServletResponse response){
        Cookie ltCookie = new Cookie(cookieName,null);
        ltCookie.setMaxAge(0);
        response.addCookie(ltCookie);
    }
}
