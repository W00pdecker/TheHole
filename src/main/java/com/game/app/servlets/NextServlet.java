package com.game.app.servlets;

import com.game.app.entities.Player;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NextServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nextLevel = req.getParameter("page");
        Player player = (Player) req.getSession().getAttribute("player");
        if (nextLevel.contains("level")) {
            updatePlayer(player, req);
            req.getSession().setAttribute("level", nextLevel);
        }
        resp.sendRedirect(nextLevel);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Player player = (Player) req.getSession().getAttribute("player");
        updatePlayer(player, req);
        String nextLevel = "/level" + Player.getLevel() + ".jsp";
        req.getSession().setAttribute("level", nextLevel);
        resp.sendRedirect(nextLevel);
    }

    private void updatePlayer(Player player, HttpServletRequest req) {
        if (req.getParameter("name") != null)
            Player.setName(req.getParameter("name"));
        if (req.getParameter("weapon") != null)
            Player.setWeapon(req.getParameter("weapon"));
        if (req.getParameter("ring") != null)
            Player.setRing(req.getParameter("ring"));
        Player.setLevel(Player.getLevel() + 1);
    }


}
