package com.game.app.servlets;

import com.game.app.entities.Enemy;
import com.game.app.entities.EnemyFactory;
import com.game.app.entities.Player;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FightServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enemy = req.getParameter("enemy");
        String action = req.getParameter("action");
        String loot = req.getParameter("loot");
        if (action.equals("fight")) {
            fight(EnemyFactory.getEnemy(enemy));
            if (Player.getHp() < 0) {
                resp.sendRedirect("/gameover.jsp");
            }
            else resp.
        }

    }

    protected void fight(Enemy enemy) {
        while (Player.getHp() > 0 && enemy.getHP() > 0) {
            enemy.setHp(enemy.getHP() - Player.hit());
            Player.setHp(Player.getHp() - enemy.hit());
        }
    }
}
