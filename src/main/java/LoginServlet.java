import database.DBConnection;
import database.Member;
import database.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null && password != null) {
            try {
                Member member = new MemberDAO(DBConnection.getInstance().getConnection()).checkMember(login);
                if (member.getPassword().equals(password)) {
                    session.setAttribute("sessionMember", member);
                    resp.sendRedirect("/company");
                } else {
                    req.setAttribute("login_error", "Ошибка доступа. Не правильный пароль");
                    req.setAttribute("login",login);
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                req.setAttribute("login_error", "Пользователь '" + login + "' не зарегистрирован");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }
}
