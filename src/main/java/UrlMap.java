
import java.util.HashMap;
import java.util.Map;

public class UrlMap {

    private final Map<String, PathAccess> urlList = new HashMap<>();
    private static UrlMap instance;

    private UrlMap() {
        urlList.put("/", new PathAccess("/main.jsp",true));
        urlList.put("/login", new PathAccess("/login.jsp",true));
        urlList.put("/profile", new PathAccess("/profile.jsp",true));
        urlList.put("/edit", new PathAccess("/edit.jsp",true));
        urlList.put("/register", new PathAccess("/register.jsp",true));
        urlList.put("/about", new PathAccess("/about.jsp",true));
        urlList.put("/access", new PathAccess("/access.jsp",true));
        urlList.put("/users", new PathAccess("/users_search.jsp",true));
        urlList.put("/users/add", new PathAccess("/users_add.jsp",false));
        urlList.put("/users/update", new PathAccess("/users_update.jsp",false));
        urlList.put("/users/delete", new PathAccess("/users_delete.jsp",false));
        urlList.put("/positions", new PathAccess("/positions_search.jsp",true));
        urlList.put("/positions/add", new PathAccess("/positions_add.jsp",false));
        urlList.put("/positions/update", new PathAccess("/positions_update.jsp",false));
        urlList.put("/positions/delete", new PathAccess("/positions_delete.jsp",false));
        urlList.put("/404", new PathAccess("/404.jsp",true));
    }

    public static UrlMap getInstance(){
        if (instance == null)
            return instance = new UrlMap();
        return instance;
    }

    public Map<String, PathAccess> getUrlList() {
        return urlList;
    }
}
