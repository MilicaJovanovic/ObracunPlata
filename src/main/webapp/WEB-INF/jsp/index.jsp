<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page session="true"%>
<%@include file="header.jsp" %>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	} 
</script>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<h2>Username je : ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()"> Logout</a>
	</h2>
</c:if>
<h2 class="container">Dobro dosli na sistem za obracun plata zaposlenih na Univerzitetu Metropolitan!</h2>
<%@include file="footer.jsp" %>