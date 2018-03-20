package com.github.firstproject.servlet.users;

import com.github.firstproject.dao.DaoService;
import com.github.firstproject.dao.model.PositionDao;
import com.github.firstproject.dao.model.UserDao;
import com.github.firstproject.dao.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/delete")
public class Delete extends HttpServlet {

    private UserDao userDao = DaoService.getInstance().getUserDao();
    private PositionDao positionDao = DaoService.getInstance().getPositionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.read(Long.parseLong(req.getParameter("id")));
        req.setAttribute("user", user);
        req.setAttribute("position", positionDao.read(user.getPosition()));
        req.getRequestDispatcher("/WEB-INF/jsp/users_delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userDao.delete(Long.parseLong(req.getParameter("id")));
        resp.sendRedirect("/users");
    }
}