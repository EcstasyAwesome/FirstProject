package com.github.firstproject.servlet.positions;

import com.github.firstproject.dao.DaoService;
import com.github.firstproject.dao.model.PositionDao;
import com.github.firstproject.dao.pojo.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/positions/update")
public class Update extends HttpServlet {

    private PositionDao positionDao = DaoService.getInstance().getPositionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("position", positionDao.read(Long.parseLong(req.getParameter("id"))));
        req.getRequestDispatcher("/WEB-INF/jsp/positions_update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Position position = new Position();
        position.setId(Long.parseLong(req.getParameter("id")));
        position.setName(req.getParameter("name"));
        position.setDescription(req.getParameter("description"));
        positionDao.update(position);
        resp.sendRedirect("/positions");
    }
}