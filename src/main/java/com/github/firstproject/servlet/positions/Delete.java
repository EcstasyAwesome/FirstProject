package com.github.firstproject.servlet.positions;

import com.github.firstproject.dao.DaoService;
import com.github.firstproject.dao.model.PositionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/positions/delete")
public class Delete extends HttpServlet {

    private PositionDao positionDao = DaoService.getInstance().getPositionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("position", positionDao.read(Long.parseLong(req.getParameter("id"))));
            req.getRequestDispatcher("/WEB-INF/jsp/positions_delete.jsp").forward(req, resp);
        } catch (NullPointerException error) {
            resp.sendError(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        positionDao.delete(Long.parseLong(req.getParameter("id")));
        resp.sendRedirect("/positions");
    }
}