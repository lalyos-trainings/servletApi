<%@page import="com.acme.domain.Address"%>
<%
  Address delivery = (Address) session.getAttribute("delivery");
  if (delivery == null) {
      delivery = new Address();
      session.setAttribute("delivery", delivery);
  }

  String zip = request.getParameter("zip");
  if (zip != null && zip.trim().length() > 1) {
      delivery.setZip(zip);
  }

  String city = request.getParameter("city");
  if (city != null && city.trim().length() > 1) {
      delivery.setCity(city);
  }

  String street = request.getParameter("street");
  if (street != null && street.trim().length() > 1) {
      delivery.setStreet(street);
  }

%>

<h2>Address</h2>

<div class="alert alert-success">
  delivery: <%= delivery %>
</div>

<form class="form-horizontal" >
  <div class="control-group">
    <label class="control-label" for="inputStreet">Street</label>
    <div class="controls">
      <input type="text" id="inputStreet" name="street" placeholder="Street">
    </div>
  </div>

  <div class="control-group">
    <label class="control-label" for="inputCity">City</label>
    <div class="controls">
      <input type="text" id="inputCity" name="city" placeholder="City">
    </div>
  </div>

  <div class="control-group">
    <label class="control-label" for="inputZip">Zip</label>
    <div class="controls">
      <input type="text" id="inputZip" name="zip" placeholder="Zip">
    </div>
  </div>

  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn btn-success">Submit</button>
    </div>
  </div>
</form>