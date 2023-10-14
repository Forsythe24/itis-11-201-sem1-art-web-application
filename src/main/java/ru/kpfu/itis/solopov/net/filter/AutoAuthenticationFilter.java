package ru.kpfu.itis.solopov.net.filter;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.service.Impl.UserServiceImpl;
import ru.kpfu.itis.solopov.net.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="autoAuthenticationFilter", urlPatterns = "/signin")
public class AutoAuthenticationFilter implements Filter {
    UserService userService = new UserServiceImpl();
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

        HttpSession httpSession = httpServletRequest.getSession();
        Cookie[] cookies = httpServletRequest.getCookies();

        Boolean isUserFound = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("login")) {
                    UserDto userDto = userService.get(c.getValue());
                    httpSession.setAttribute("user", userDto);
                    httpSession.setAttribute("dateOfBirth", userDto.getBirthDate().toString());
                    httpSession.setAttribute("userAuthorized", true);

                    httpServletResponse.sendRedirect("/profile");

                    isUserFound = true;
                    break;
                }
            }
        }
        if (!isUserFound) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
