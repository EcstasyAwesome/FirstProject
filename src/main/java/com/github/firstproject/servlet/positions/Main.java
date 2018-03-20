package com.github.firstproject.servlet.positions;

import com.github.firstproject.dao.DaoService;
import com.github.firstproject.dao.model.PositionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/positions")
public class Main extends HttpServlet {

    private PositionDao positionDao = DaoService.getInstance().getPositionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("positions", positionDao.getList());
        req.getRequestDispatcher("/WEB-INF/jsp/positions_search.jsp").forward(req, resp);
    }
}