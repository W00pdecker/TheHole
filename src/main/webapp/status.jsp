<%@ page import="com.game.app.entities.Player" %><%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 10/22/2022
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your status</title>
</head>
<body>
    <%="Hello, " + Player.getName()
            + "! You are now on level "
            + Player.getLevel()
            + "You have " + Player.getHp() + " HP"%><br/><br/>
    <%="This is some stuff you got:"%><br/>
    <% if (Player.getWeapon() != null)
        out.println("You are wielding " + Player.getWeapon());%><br/>
    <% if (Player.getRing() != null)
        out.println("You are wearing " + Player.getRing());%><br/>
    <% if (!Player.getLoot().isEmpty())
        out.println("Also you have " + Player.getLoot().toString());%><br/>
    <br/><br/>
    <a href="${pageContext.session.getAttribute("level")}">Ok, got it!</a>
</body>
</html>
