<%@page import="java.util.List"%>
<h2>users.jsp</h2>

<%
List<String> users = (List<String>)application.getAttribute("userList");
%>

<ul>
<% for(String user: users) {%>
	<li><%= user %></li>
<%} %>
</ul>

