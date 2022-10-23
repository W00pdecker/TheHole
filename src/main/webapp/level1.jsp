<%@ page import="com.game.app.entities.Player" %>
<html>
<head>
    <title>RPG: into the Hole!</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8">
</head>
<body>
<%
    pageContext.setAttribute("name", Player.getName());
%>
<div><h2><b>Ok, ${name}, time to dive in!</b></h2></div>

<div>
    <p>For adventures they are a-waiting</p>

</div>

<div>
    <form action="/next" method="get">
        <fieldset>
            <input type="radio" id="ready" name="page" value="/level2.jsp">
            <label for="ready">I'm ready! </label><br>

            <input type="radio" id="notReady" name="page" value="/status.jsp">
            <label for="notReady">Wait, i want to check my stuff!</label><br>
        </fieldset>
        <input type = "submit" value = "Submit" />
    </form>
</div>

</body>
<script>

</script>
</html>
