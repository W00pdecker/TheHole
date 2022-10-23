<%@ page import="com.game.app.entities.Player" %>
<html>
<head>
    <title>RPG: first fight</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8">
</head>
<body>
<%
    pageContext.setAttribute("name", Player.getName());
%>
<div><h2><b>You dive into The Hole. Oh my.</b></h2></div>

<div>
    <p>First thing you see is, well, nothing. It's too dark.</p>
    <p>But then a small creature appears, waving a burning torch. How fortunate that you are armed</p>

</div>

<div>
    <form action="/fight?enemy=goblin&loot=torch" method="post" >
        <fieldset>
            <legend>Will you fight?</legend>

            <input type="radio" id="yes" name="action" value="fight">
            <label for="yes">Yes, i'm armed and dangerous</label><br>

            <input type="radio" id="no" name="action" value="negotiate">
            <label for="no">No, i'll try to negotiate</label><br>
        </fieldset>
        <input type = "submit" value = "Submit" />
    </form>
</div>

</body>
<script>

</script>
</html>
