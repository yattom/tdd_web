<%@ page import="java.util.List" %>
<%@ page import="java.net.URLEncoder" %>

<html>
<body>TODO INDEX
<ul>
<% for(String todo: (List<String>)request.getAttribute("todos")) {%>
<li class="todo-item">
<%= todo %>
<a href="done?text=<%= URLEncoder.encode(todo) %>">DONE</a>
</li>
<% } %>
</ul>

<form action="create" method="POST">
TODO: <input name="text">
<input type="submit">
</body>
</html>
