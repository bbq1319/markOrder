package kr.co.markncompany.markorder.util;

import kr.co.markncompany.markorder.member.entity.Member;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static String getCookie(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("innoForest")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void getNewCookie(String token, Member member, HttpServletResponse response) {
        // HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

        // JWT setting
        Cookie cookie = new Cookie("innoForest", token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        // member info setting
        Cookie id = new Cookie("id", member.getMemberId());
        Cookie name = new Cookie("name", member.getName());
        response.addCookie(id);
        response.addCookie(name);
    }

    public static void deleteCookie() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        Cookie cookie = new Cookie("innoForest", null);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
