package com.github.firstproject.servlet.users;

import com.github.firstproject.dao.DaoService;
import com.github.firstproject.dao.model.PositionDao;
import com.github.firstproject.dao.model.UserDao;
import com.github.firstproject.dao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/update")
public class Update extends HttpServlet {

    private UserDao userDao = DaoService.getInstance().getUserDao();
    private PositionDao positionDao = DaoService.getInstance().getPositionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("user", userDao.read(Long.parseLong(req.getParameter("id"))));
            req.setAttribute("positions", positionDao.getList());
            req.getRequestDispatcher("/WEB-INF/jsp/users_update.jsp").forward(req, resp);
        } catch (NullPointerException error) {
            resp.sendError(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        user.setId(Long.parseLong(req.getParameter("id")));
        user.setSurname(req.getParameter("surname"));
        user.setFirstName(req.getParameter("firstName"));
        user.setMiddleName(req.getParameter("middleName"));
        user.setPhone(Long.parseLong(req.getParameter("phone")));
        user.setPosition(Long.parseLong(req.getParameter("position")));
        userDao.update(user);
        resp.sendRedirect("/users");
    }
}