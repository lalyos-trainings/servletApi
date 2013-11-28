<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>

<%
if ("post".equalsIgnoreCase(request.getMethod())) {
    String newBreak = request.getParameter("break");
    breakTimes.add(newBreak);
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

		<c:forEach items="${breakTimes }" var="next">
		<tr>
			<td>${next }</td>
			<c:url value="delete" var="deleteUrl">
				<c:param name="break" value="${next}"></c:param>
			</c:url>
			<td><a href="${deleteUrl }" class="btn btn-danger"> <i class="icon icon-white icon-trash"></i></a></td>
		</tr>

		</c:forEach>
	</tbody>
</table>



<h2>Add new break time</h2>
<form  method="post" class="form-inline">
<fieldset>
  <input type="text" name="break" />
  <button type="submit" class="btn btn-success"><i class="icon icon-white icon-plus-sign"></i></button>
 </fieldset>
  
</form>

