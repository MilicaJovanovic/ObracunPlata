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
<div class="container">
    <h2>Korisnice ${pageContext.request.userPrincipal.name}, dobro dosli na sistem za obracun plata zaposlenih na Univerzitetu Metropolitan!</h2>
</div>

<%@include file="footer.jsp" %>