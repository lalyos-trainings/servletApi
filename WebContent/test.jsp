<ul>
	<c:forEach items="${breakTimes}" var="number" varStatus="status">
		<li>${status.count}.${number}</li>
	</c:forEach>
</ul>


