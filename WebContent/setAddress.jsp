<%@ taglib tagdir="/WEB-INF/tags" prefix="b"%>

<%@page errorPage="errorHandling.jsp" %>


<jsp:useBean id="delivery" class="com.acme.domain.Address" scope="session"></jsp:useBean>

<jsp:setProperty name="delivery" property="*" />

<%
if ("xxx".equalsIgnoreCase(delivery.getCity())){
    out.println("<h2>exception ...</h2>");
    throw new RuntimeException("BAD CITUY");
}
%>

<h2>Address 1</h2>
</div>

<div class="row">

<div class="span8">
<form class="form-horizontal" >

  <b:field name="street"/>
  <b:field name="city"/>
  <b:field name="zip"/>

  <b:submit caption="Submit"/>
</form>
</div>

<div class="alert alert-success span3">
  <i class="icon icon-envelope"></i><br/>
  
  ${delivery.street}<br/>
  ${delivery.city}<br/>
  ${delivery.zip}<br/>
  
</div>

