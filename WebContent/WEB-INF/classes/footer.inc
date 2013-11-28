<%@page import="java.util.Date, java.text.SimpleDateFormat"%>

<%!

    private static final java.text.SimpleDateFormat hourFormatter = new java.text.SimpleDateFormat("HH:mm");
    private static final java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat("yyyy-MM-dd ");
    private static final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

%>


<%
		Date now = new Date();
        String nowHours = hourFormatter.format(now);
        String nowDate = dateFormatter.format(now);
		String nextBreak = (String) breakTimes.higher(nowHours.toString());

		
		Date breakTime = sdf.parse(nowDate + nextBreak);
        long minutes = (breakTime.getTime() - now.getTime()) / 60000;
		

%>
    </div>
    <footer>
      <p>&copy; Company 2013</p>
    </footer>
  </div> <!-- /container -->

   <div class="progress progress-striped active">
  <div class="bar" style="width: <%=minutes %>%;"></div>
</div>
  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->

<c:if test="${not empty param.debug }" >  
  <b:debug title="session" map="${sessionScope }"/>
  <b:debug title="application" map="${applicationScope }"/>
  <b:debug title="headers" map="${header }"/>
</c:if>  
</body>
</html>
