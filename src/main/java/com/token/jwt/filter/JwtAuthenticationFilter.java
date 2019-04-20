package com.token.jwt.filter;

import com.token.jwt.util.JwtUtil;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haort
 * @date 2018/3/13
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (!isWhiteUrl(request) && isProtectedUrl(request)) {
                String token = request.getHeader("Authorization");
                Object user = JwtUtil.validateToken(token);
                request.getSession().setAttribute("user", user);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未获得授权，请登录");
            return;
        }
        filterChain.doFilter(request, response);
    }


    private boolean isProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match("/api/**", request.getServletPath());
    }

    private boolean isWhiteUrl(HttpServletRequest request) {
        return pathMatcher.match("/**/excel", request.getServletPath()) || pathMatcher.match("/rest/**", request.getServletPath());
    }

}
