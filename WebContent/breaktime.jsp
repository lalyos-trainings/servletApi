<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@include file="/WEB-INF/classes/header.inc" %>

<%
Set<String> breaks = (Set<String>)application.getAttribute("breakTimes");

%>



<table class="table table-striped">
	<thead>
		<tr>
			<th>Break Time xxx</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>

		<% for(String next: breaks) {%>

		<tr>
			<td><%= next %></td>
			<td>X</td>
		</tr>

		<%} %>
	</tbody>
</table>




<%@include file="/WEB-INF/classes/footer.inc" %>
