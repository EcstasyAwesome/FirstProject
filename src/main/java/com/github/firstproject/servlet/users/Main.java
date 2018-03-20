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

@WebServlet("/users")
public class Main extends HttpServlet {

    private UserDao userDao = DaoService.getInstance().getUserDao();
    private PositionDao positionDao = DaoService.getInstance().getPositionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userDao.getList());
        req.setAttribute("positions", positionDao.getList());
        req.getRequestDispatcher("/WEB-INF/jsp/users_search.jsp").forward(req, resp);
    }
}