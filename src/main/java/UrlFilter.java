import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UrlFilter implements Filter {

    private static String url;

    public static String getUrl() {
        return url;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-> UrlFilter запущен");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getPathInfo() == null) {
            url = "/";
        } else url = req.getPathInfo();

        if (UrlMap.getInstance().getUrlList().containsKey(url)) chain.doFilter(request, response);
        else req.getRequestDispatcher(UrlMap.getInstance().getUrlList().get("404")).forward(request, response);

    }

    @Override
    public void destroy() {
        System.out.println("-> UrlFilter остановлен");
    }
}
