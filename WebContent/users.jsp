<%@page import="java.util.List"%>
<%@include file="/WEB-INF/classes/header.inc" %>
<h2>users.jsp</h2>

<%
List<String> users = (List<String>)application.getAttribute("userList");
%>

<ul>
<% for(String user: users) {%>
	<li><%= user %></li>
<%} %>
</ul>

<%@include file="/WEB-INF/classes/footer.inc" %>
