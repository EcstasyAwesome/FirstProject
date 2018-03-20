package com.github.firstproject.filter;

import com.github.firstproject.util.Info;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Encoding filter", urlPatterns = "/*")
public class EncodeFilter implements Filter {

    private static final String ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) {
        Info.print(EncodeFilter.class, ENCODING);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        response.setContentType("text/html; charset=" + ENCODING);
        chain.doFilter(request, response);
    }
}