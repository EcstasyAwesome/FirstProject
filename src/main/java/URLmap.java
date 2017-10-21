
import java.util.HashMap;
import java.util.Map;

class URLmap {

    private static Map<String, String> URLList = new HashMap<>();

    static {

        URLList.put("", "/main.jsp");
        URLList.put("/about", "/about.jsp");
        URLList.put("/users", "/users_search.jsp");
        URLList.put("/users/add", "/users_add.jsp");
        URLList.put("/users/update", "/users_update.jsp");
        URLList.put("/users/delete", "/users_delete.jsp");
        URLList.put("/positions", "/positions_search.jsp");
        URLList.put("/positions/add", "/positions_add.jsp");
        URLList.put("/positions/update", "/positions_update.jsp");
        URLList.put("/positions/delete", "/positions_delete.jsp");
        URLList.put("404", "/404.jsp");
    }

    static Map<String, String> getURLList() {
        return URLList;
    }

    private URLmap() {
    }

}
