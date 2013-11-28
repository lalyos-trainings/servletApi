<ul>
	<c:forEach items="${breakTimes}" var="number" varStatus="status">
		<li>${status.count}.${number}</li>
	</c:forEach>
</ul>


<c:url value="secret/topsecret.jsp" var="secretUrl"  >

<a href="${secretUrl}">secret</a>