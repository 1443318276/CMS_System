<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>400</title>
</head>
<body>
<h5>400</h5>
<ul>
    <li><%= request.getAttribute("javax.servlet.forward.request_uri") %></li>
    <li><%= request.getAttribute("javax.servlet.error.status_code") %></li>
    <li><%= exception.getMessage() %></li>
</ul>

<p>
    <% exception.printStackTrace(new PrintWriter(out)); %>
</p>
</body>
</html>
