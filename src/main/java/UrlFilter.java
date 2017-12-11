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
        if (req.getPathInfo() == null) url = "/"; // получение ссылки
        else url = req.getPathInfo();
        if (UrlMap.getInstance().getUrlList().containsKey(url)) { // валидация ссылки
            if (req.getRequestURI().equals("/company/login")) { // ниже логика авторизации
                if (session.getAttribute("sessionMember") != null)
                    resp.sendRedirect("/company");// profile page in future
                else chain.doFilter(request, response);
            } else if (session.getAttribute("sessionMember") != null) chain.doFilter(request, response);
            else if (session.getAttribute("sessionMember") == null)
                resp.sendRedirect("/company/login");
        } else resp.sendRedirect("/company/404"); // если ссылка не валидна

    }

    @Override
    public void destroy() {
        System.out.println("-> UrlFilter остановлен");
    }
}
