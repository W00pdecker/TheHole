<%@ page import="com.game.app.entities.Player" %>
<html>
<head>
  <title>RPG: get your weapon</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <meta charset="UTF-8">
</head>
<body>
<%
  pageContext.setAttribute("name", Player.getName());
%>
<div><h2><b>Well, hello ${name}.</b></h2></div>

<div>
  <p>One more thing. You can't go into unknown holes unarmed. It's dangerous to go along. Take this.</p>

</div>

<div>
  <form action="/next" method="post">
  <fieldset>
    <legend>Choose your weapon</legend>

    <input type="radio" id="sword" name="weapon" value="Sword">
    <label for="sword">Sword</label><br>

    <input type="radio" id="axe" name="weapon" value="Axe">
    <label for="axe">Axe</label><br>

    <input type="radio" id="handgun" name="weapon" value="Handgun" />
    <label for="handgun">Handgun</label>
  </fieldset>
    <input type = "submit" value = "Submit" />
  </form>
</div>

</body>
<script>

</script>
</html>
