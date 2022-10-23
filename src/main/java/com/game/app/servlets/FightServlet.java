package com.game.app.servlets;

import com.game.app.entities.Enemy;
import com.game.app.entities.EnemyFactory;
import com.game.app.entities.Player;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FightServlet extends HttpServlet {
    @Override
    @Test
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String enemy = req.getParameter("enemy");
        String action = req.getParameter("action");
        String loot = req.getParameter("loot");
        if (enemy == null || action == null) {
            throw new NullPointerException("Something wrong");
        }

        if (action.equals("fight")) {
            fight(EnemyFactory.getEnemy(enemy));
            if (Player.getHp() < 0) {
                resp.sendRedirect("/gameover.jsp");
            }
            else {
                Player.addLoot(loot);
                req.getSession().setAttribute("level", "level2-0.jsp");
                resp.sendRedirect("/level2-0.jsp");
            }
        } else if (action.equals("negotiate")) {
            Player.setRing("RingOfNight");
            req.getSession().setAttribute("level", "level2-1.jsp");
            resp.sendRedirect("level2-1.jsp");
        }

        else throw new ServletException("Something wrong");

    }

    protected void fight(Enemy enemy) {
        while (Player.getHp() > 0 && enemy.getHP() > 0) {
            enemy.setHp(enemy.getHP() - Player.hit());
            Player.setHp(Player.getHp() - enemy.hit());
        }
    }
}
