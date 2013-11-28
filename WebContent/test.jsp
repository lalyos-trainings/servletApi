<ul>
	<c:forEach items="${breakTimes}" var="number" varStatus="status">
		<li>${status.count}.${number}</li>
	</c:forEach>
</ul>

<c:import url="http://api.icndb.com/jokes/random
"></c:import>
