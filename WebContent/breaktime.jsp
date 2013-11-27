<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@include file="/WEB-INF/classes/header.inc" %>

<%
Set<String> breaks = (Set<String>)application.getAttribute("breakTimes");
if ("post".equalsIgnoreCase(request.getMethod())) {
    String newBreak = request.getParameter("break");
    breaks.add(newBreak);
}

%>



<table class="table table-striped">
	<thead>
		<tr>
			<th>Break Time</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>

		<% for(String next: breaks) {%>

		<tr>
			<td><%= next %></td>
			<td><a href="delete?break=<%= next %>">X</a></td>
		</tr>

		<%} %>
	</tbody>
</table>


<h2>Add new break time</h2>
<form  method="post">
  <input type="text" name="break" />
  <input type="submit" value="add">
</form>

<%@include file="/WEB-INF/classes/footer.inc" %>
