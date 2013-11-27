<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@include file="/WEB-INF/classes/header.inc" %>

<%
Set<String> breaks = (Set<String>)application.getAttribute("breakTimes");

%>

<ul>
<% for(String next: breaks) {%>
	<li><%= next %></li>
<%} %>
</ul>




<%@include file="/WEB-INF/classes/footer.inc" %>
