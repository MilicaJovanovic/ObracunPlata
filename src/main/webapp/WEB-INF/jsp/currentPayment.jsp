<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="header.jsp" %>

    <h1>Lista trenutnih neto zarada zaposlenih</h1>
    <p>Odaberite semestar:</p>
    <form:form method="POST" commandName="semester">
        <form:select path="semesterName" items="${semesterList}" />
    </form:form>
    <c:if test="${!empty employees}">
        <table class="table table-striped" style="margin-top: 20px;">
            <tr>
                <th width="500"> Ime</th>
                <th width="500"> Prezime</th>
                <th width="500"> Tip zaposlenja</th>
                <th width="500"> Fakultet</th>
                <th width="500"> Osnovna zarada</th>
                <th width="500"> Autorski honorar</th>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <div class="row">
                    <tr>
                        <td>${employee.name}</td>
                        <td>${employee.lastname}</td>
                        <td>${employee.employmentType}</td>
                        <td>${employee.faculty}</td>
                        <td>${employee.salaryNeto}</td>
                        <td>${employee.authorFeeNeto}</td>
                    </tr>
                </div>
            </c:forEach>
        </table>
    </c:if>
    <form action="<c:url value="/currentPayment/pay" />" method="GET">
        <input type="submit" name="action" value="Isplati" class="btn btn-primary" style="background-color: #19B396; margin-top: 30px;" />
    </form>

<%@include file="footer.jsp" %>