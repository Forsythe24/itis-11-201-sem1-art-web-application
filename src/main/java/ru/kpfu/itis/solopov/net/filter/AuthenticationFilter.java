//package ru.kpfu.itis.solopov.net.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName="authenticationFilter", urlPatterns = "/*")
//public class AuthenticationFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//
//        String uri = httpServletRequest.getRequestURI();
//        HttpSession httpSession = httpServletRequest.getSession(false);
//        if (httpSession == null && !uri.contains("signin") && !uri.contains("userinfo") && !uri.contains("homepage")) {
//            ((HttpServletResponse) servletResponse).sendRedirect("/homepage");
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//
//        if (httpSession != null && (uri.contains("signin") || uri.contains("userinfo/authinfo")) || uri.endsWith("/homepage")) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            ((HttpServletResponse) servletResponse).sendRedirect("/homepage");
//        }
//    }
//}
