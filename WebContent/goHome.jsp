<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<fmt:parseDate pattern="yyyy-MM-dd HH:mm" value="2013-11-28 16:45" var="goHome" />
<jsp:useBean id="most" class="java.util.Date" />

<fmt:setBundle basename="messages"/>
<fmt:message key="gohome.msg"/>
: 
<fmt:formatNumber maxFractionDigits="0"  value="${(goHome.time - most.time) /60000}"/>
