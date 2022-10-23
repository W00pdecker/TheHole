package com.game.app.servlets;

import com.game.app.entities.Player;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {


    @Test
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Player player = (Player) req.getSession().getAttribute("player");
        String name = req.getParameter("name");
        if (Objects.isNull(name)) {
            resp.sendRedirect("/index.jsp");
        }
        if (player == null) {
            player = Player.getInstance(name);
        }

        req.getSession().setAttribute("player", player);
        resp.sendRedirect("/level0.jsp");

    }
}