
import database.DBConnection;
import database.Position;
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
        String url = req.getRequestURI().substring(req.getServletPath().length());
        if (URLmap.getURLList().containsKey(url)) {
            String key = req.getParameter("key");
            String value = req.getParameter("value");
            req.setAttribute("users", new UserDAO(connection).getUsersList(key, value));
            req.setAttribute("positions", new PositionDAO(connection).getPositionsList(key, value));
            if (key == null && value == null) {
                req.setAttribute("button", false);
            } else req.setAttribute("button", true);
            req.getRequestDispatcher(URLmap.getURLList().get(url)).forward(req, resp);
        } else req.getRequestDispatcher(URLmap.getURLList().get("404")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String method = req.getParameter("method");
            if (method != null && method.equals("PUT")) {
                doPut(req, resp);
            }
            if (method != null && method.equals("DELETE")) {
                doDelete(req, resp);
            }
        } catch (Exception e) {
            System.out.println(e);
            resp.sendRedirect("/company");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
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
                if (form.equals("addUser")) {
                    surname = new String(req.getParameter("user_surname").getBytes("ISO-8859-1"), "UTF-8");
                    firstName = new String(req.getParameter("user_firstName").getBytes("ISO-8859-1"), "UTF-8");
                    secondName = new String(req.getParameter("user_secondName").getBytes("ISO-8859-1"), "UTF-8");
                    phoneNumber = Long.parseLong(req.getParameter("user_phoneNumber"));
                    position = Integer.parseInt(req.getParameter("position_id"));
                    new UserDAO(connection).addUser(surname, firstName, secondName, phoneNumber, position);
                    resp.sendRedirect("/company/users");
                }
                if (form.equals("updateUser")) {
                    surname = new String(req.getParameter("user_surname").getBytes("ISO-8859-1"), "UTF-8");
                    firstName = new String(req.getParameter("user_firstName").getBytes("ISO-8859-1"), "UTF-8");
                    secondName = new String(req.getParameter("user_secondName").getBytes("ISO-8859-1"), "UTF-8");
                    phoneNumber = Long.parseLong(req.getParameter("user_phoneNumber"));
                    position = Integer.parseInt(req.getParameter("position_id"));
                    id = Integer.parseInt(req.getParameter("user_id"));
                    new UserDAO(connection).updateUser(id, surname, firstName, secondName, phoneNumber, position);
                    resp.sendRedirect("/company/users?key=user_id&value=" + id);
                }
                if (form.equals("addPosition")) {
                    name = new String(req.getParameter("position_name").getBytes("ISO-8859-1"), "UTF-8");
                    description = new String(req.getParameter("position_description").getBytes("ISO-8859-1"), "UTF-8");
                    new PositionDAO(connection).addPosition(name, description);
                    resp.sendRedirect("/company/positions");
                }
                if (form.equals("updatePosition")) {
                    id = Integer.parseInt(req.getParameter("position_id"));
                    name = new String(req.getParameter("position_name").getBytes("ISO-8859-1"), "UTF-8");
                    description = new String(req.getParameter("position_description").getBytes("ISO-8859-1"), "UTF-8");
                    new PositionDAO(connection).updatePosition(id, name, description);
                    resp.sendRedirect("/company/positions");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            resp.sendRedirect("/company");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String form = req.getParameter("form");
            int id;
            if (form != null) {
                if (form.equals("deleteUser")) {
                    id = Integer.parseInt(req.getParameter("user_id"));
                    new UserDAO(connection).deleteUser(id);
                    resp.sendRedirect("/company/users");
                }
                if (form.equals("deletePosition")) {
                    id = Integer.parseInt(req.getParameter("position_id"));
                    new PositionDAO(connection).deletePosition(id);
                    resp.sendRedirect("/company/positions");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            resp.sendRedirect("/company");
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
            System.out.println(e);
        }
    }

}