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

  <break:field name="street"/>
  <break:field name="city"/>
  <break:field name="zip"/>

  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn btn-success">Submit</button>
    </div>
  </div>
</form>
</div>

<div class="alert alert-success span3">
  <i class="icon icon-envelope"></i><br/>
  <jsp:getProperty property="street" name="delivery"/><br/>
  <jsp:getProperty property="city" name="delivery"/><br/>
  <jsp:getProperty property="zip" name="delivery"/>
  
</div>
