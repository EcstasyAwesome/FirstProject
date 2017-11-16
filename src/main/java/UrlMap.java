
import java.util.HashMap;
import java.util.Map;

public class UrlMap {

    private Map<String, String> urlList = new HashMap<>();
    private static UrlMap instance;

    private UrlMap() {
        urlList.put("/", "/main.jsp");
        urlList.put("/about", "/about.jsp");
        urlList.put("/users", "/users_search.jsp");
        urlList.put("/users/add", "/users_add.jsp");
        urlList.put("/users/update", "/users_update.jsp");
        urlList.put("/users/delete", "/users_delete.jsp");
        urlList.put("/positions", "/positions_search.jsp");
        urlList.put("/positions/add", "/positions_add.jsp");
        urlList.put("/positions/update", "/positions_update.jsp");
        urlList.put("/positions/delete", "/positions_delete.jsp");
        urlList.put("404", "/404.jsp");
    }

    public static UrlMap getInstance(){
        if (instance == null)
            return instance = new UrlMap();
        return instance;
    }

    public Map<String, String> getUrlList() {
        return urlList;
    }
}
