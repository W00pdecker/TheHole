<html>
<head>
    <title>RPG: gettin' started</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8">
</head>
<body>
<div><h2><b>OK LET'S BEGIN</b></h2></div>

<div>
    <p>You are standing at the entrance to the hole.<br>
However, we don't know whether this is the entrance or the exit.<br>
    At this point, it's safe to say it's a hole.</p>

<p>Oh, no, there's something else we can say with certainty: your name.</p>
</div>

<div>
    <form action="/start?" method="post">
        Your name is: <input type="text" id="playerNameInput" name="name">
        <input type = "submit" value = "Submit" />
    </form>
</div>

</body>
<script>
</script>
</html>
