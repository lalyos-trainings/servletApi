<%@include file="/WEB-INF/classes/header.inc" %>
<%@page import="java.util.TreeSet"%>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%!
private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

long getMinutes() throws Exception {
    Date coffeeDate = sdf.parse("2013-11-27 10:45");
    Date now = new Date();
    
    long minutes = (coffeeDate.getTime() - now.getTime()) / 60000;
	return minutes;
}
%>

<%
// comment
TreeSet <String> breakTimes =  (TreeSet<String>) application.getAttribute("breakTimes");
%>



	<h1>Coffee Break</h1>

<!-- itt jartam -->
<%-- itt azt irtam hogy bla bla --%>
	
	 minutes left till coffee break :  <%= getMinutes() %>

    <hr/>
	defined breaks: <%= breakTimes%>
	<ul>
	<% 
	  for(String next: breakTimes) {
	      %>
	      <li><%= next %></li>
	      <%
	  } 
	 %>
	</ul>

<%@include file="/WEB-INF/classes/footer.inc" %>
