import javax.servlet.*;
import java.io.IOException;

public class EncodeFilter implements Filter {
    private String encoding = "UTF-8"; // по умолчанию

    @Override
    public void init(FilterConfig filterConfig) {
        String encoding = filterConfig.getInitParameter("encoding");
        if (encoding != null) {
            this.encoding = encoding;
        }
        System.out.println("-> EncodeFilter запущен, кодировка '" + this.encoding + "'");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("-> EncodeFilter остановлен");
    }
}
