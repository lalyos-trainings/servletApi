<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="map" description="" required="true"
	type="java.util.Map"%>
<%@ attribute name="title" description="" required="false"%>

<%@ tag language="java" pageEncoding="US-ASCII"%>

<c:if test="${not empty title}">
	<h2>${title }</h2>
</c:if>


<c:choose>
	<c:when test="${empty map}">
	  is empty
	</c:when>
	<c:otherwise>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>key</th>
					<th>value</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${map}" var="entry">
					<tr>
						<td>${entry.key }</td>
						<td>${entry.value }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:otherwise>
</c:choose>
