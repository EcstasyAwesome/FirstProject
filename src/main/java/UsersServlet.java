
import database.DBConnection;
import database.PositionDAO;
import database.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class UsersServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        req.setAttribute("users", new UserDAO(connection).getUsersList(key, value));
        req.setAttribute("positions", new PositionDAO(connection).getPositionsList(key, value));
        if (req.getQueryString() == null) {
            req.setAttribute("button", false);
        } else req.setAttribute("button", true);
        req.getRequestDispatcher(URLmap.getURLList().get(URLFilter.getUrl())).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null) {
            switch (method) {
                case "PUT":
                    doPut(req, resp);
                    break;
                case "DELETE":
                    doDelete(req, resp);
                    break;
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String form = req.getParameter("form");
        int id;
        String surname;
        String firstName;
        String secondName;
        long phoneNumber;
        int position;
        String name;
        String description;
        if (form != null) {
            switch (form) {
                case "addUser":
                    surname = new String(req.getParameter("user_surname").getBytes("ISO-8859-1"), "UTF-8");
                    firstName = new String(req.getParameter("user_firstName").getBytes("ISO-8859-1"), "UTF-8");
                    secondName = new String(req.getParameter("user_secondName").getBytes("ISO-8859-1"), "UTF-8");
                    phoneNumber = Long.parseLong(req.getParameter("user_phoneNumber"));
                    position = Integer.parseInt(req.getParameter("position_id"));
                    new UserDAO(connection).addUser(surname, firstName, secondName, phoneNumber, position);
                    resp.sendRedirect("/company/users");
                    break;
                case "updateUser":
                    surname = new String(req.getParameter("user_surname").getBytes("ISO-8859-1"), "UTF-8");
                    firstName = new String(req.getParameter("user_firstName").getBytes("ISO-8859-1"), "UTF-8");
                    secondName = new String(req.getParameter("user_secondName").getBytes("ISO-8859-1"), "UTF-8");
                    phoneNumber = Long.parseLong(req.getParameter("user_phoneNumber"));
                    position = Integer.parseInt(req.getParameter("position_id"));
                    id = Integer.parseInt(req.getParameter("user_id"));
                    new UserDAO(connection).updateUser(id, surname, firstName, secondName, phoneNumber, position);
                    resp.sendRedirect("/company/users?key=user_id&value=" + id);
                    break;
                case "addPosition":
                    name = new String(req.getParameter("position_name").getBytes("ISO-8859-1"), "UTF-8");
                    description = new String(req.getParameter("position_description").getBytes("ISO-8859-1"), "UTF-8");
                    new PositionDAO(connection).addPosition(name, description);
                    resp.sendRedirect("/company/positions");
                    break;
                case "updatePosition":
                    id = Integer.parseInt(req.getParameter("position_id"));
                    name = new String(req.getParameter("position_name").getBytes("ISO-8859-1"), "UTF-8");
                    description = new String(req.getParameter("position_description").getBytes("ISO-8859-1"), "UTF-8");
                    new PositionDAO(connection).updatePosition(id, name, description);
                    resp.sendRedirect("/company/positions");
                    break;
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String form = req.getParameter("form");
        int id;
        if (form != null) {
            switch (form) {
                case "deleteUser":
                    id = Integer.parseInt(req.getParameter("user_id"));
                    new UserDAO(connection).deleteUser(id);
                    resp.sendRedirect("/company/users");
                    break;
                case "deletePosition":
                    id = Integer.parseInt(req.getParameter("position_id"));
                    new PositionDAO(connection).deletePosition(id);
                    resp.sendRedirect("/company/positions");
                    break;
            }
        }
    }

    @Override
    public void init() throws ServletException {
        connection = new DBConnection().getConnection();
        System.out.println("Connection up");
    }

    @Override
    public void destroy() {
        try {
            connection.close();
            System.out.println("Connection down");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
