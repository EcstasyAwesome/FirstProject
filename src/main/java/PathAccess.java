
public class PathAccess {
    private String path;
    private boolean access;

    public PathAccess(String path, boolean access){
        this.path = path;
        this.access = access;
    }

    public String getPath() {
        return path;
    }

    public boolean getAccess() {
        return access;
    }
}
