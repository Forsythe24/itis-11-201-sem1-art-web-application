package ru.kpfu.itis.solopov.net.filter;

import ru.kpfu.itis.solopov.net.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="authenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String uri = httpServletRequest.getRequestURI();

        HttpSession httpSession = httpServletRequest.getSession(false);

        Boolean isSessionNull = httpSession == null;
        UserDto userDto = isSessionNull ? null : (UserDto) httpSession.getAttribute("user");

        if (userDto == null && !uri.contains("signin") && !uri.contains("userinfo") && !uri.contains("authinfo")  && !uri.contains("homepage")) {
            if (isSessionNull) {
                httpServletResponse.sendRedirect("/homepage");
            } else {
                httpServletResponse.sendRedirect("/signin");
            }
        } else {
            if (uri.contains("authinfo") && !isUserInfoProvided(httpSession)) {
                httpServletResponse.sendRedirect("/userinfo");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }

        }
    }

    private boolean isUserInfoProvided(HttpSession httpSession) {
        if (httpSession == null) {
            return false;
        }
        String userName = (String) httpSession.getAttribute("username");
        return userName != null;
    }
}
