<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="header.jsp" %>
<div class="container">
    <h1>Lista trenutnih bruto zarada zaposlenih</h1>
    <c:if test="${!empty employees}">
        <table class="table table-striped" style="margin-top: 20px;">
            <tr>
                <th width="500"> Ime</th>
                <th width="500"> Prezime</th>
                <th width="500"> Tip zaposlenja</th>
                <th width="500"> Fakultet</th>
                <th width="500"> Osnovna zarada jesenji semestar</th>
                <th width="500"> Autorski honorar jesenji semester</th>
                <th width="500"> Osnovna zarada prolecni semestar</th>
                <th width="500"> Autorski honorar prolecni semestar</th>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <div class="row">
                    <tr>
                        <td>${employee.name}</td>
                        <td>${employee.lastname}</td>
                        <td>${employee.employmentType}</td>
                        <td>${employee.faculty}</td>
                        <td>${employee.salaryGrossA}</td>
                        <td>${employee.authorFeeGrossA}</td>
                        <td>${employee.salaryGrossS}</td>
                        <td>${employee.authorFeeGrossS}</td>
                    </tr>
                </div>
            </c:forEach>
        </table>
    </c:if>
</div>
<%@include file="footer.jsp" %>