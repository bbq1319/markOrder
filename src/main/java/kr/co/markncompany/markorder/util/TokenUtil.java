package kr.co.markncompany.markorder.util;

import kr.co.markncompany.markorder.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class TokenUtil {

    private final JwtTokenProvider jwtTokenProvider;
    private static final String TOKEN_PREFIX = "Bearer ";

    private String getJwt(HttpServletRequest request) {
        String authToken = request.getHeader("X-AUTH-TOKEN");
        if (authToken != null && authToken.startsWith(TOKEN_PREFIX))
            return authToken.replace(TOKEN_PREFIX, "");
        return null;
    }

    public boolean checkJwt(HttpServletRequest request) {
        boolean isValidJwt = true;
        String jwt = getJwt(request);
        if (jwt != null)
            isValidJwt = jwtTokenProvider.validateToken(jwt);
        return isValidJwt;
    }
}
