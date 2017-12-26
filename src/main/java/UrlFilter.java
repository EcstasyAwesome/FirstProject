import database.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UrlFilter implements Filter {

    private static String url;

    public static String getUrl() {
        return url;
    }

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("-> UrlFilter запущен");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        User sessionUser = (User) session.getAttribute("sessionUser");
        if ((url = req.getPathInfo()) == null) url = "/";
        if (UrlMap.getInstance().getUrlList().containsKey(url)) {
            if (sessionUser != null && (UrlMap.getInstance().getUrlList().get(url).getAccess() | sessionUser.isAdmin()))
                chain.doFilter(request, response);
            else if (req.getRequestURI().equals("/company/login") | req.getRequestURI().equals("/company/register"))
                chain.doFilter(request, response);
            else if (session.getAttribute("sessionUser") == null) resp.sendRedirect("/company/login");
            else resp.sendRedirect("/company/access");
        } else resp.sendRedirect("/company/404");

    }

    @Override
    public void destroy() {
        System.out.println("-> UrlFilter остановлен");
    }
}
