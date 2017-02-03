<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="header.jsp" %>
<div class="container">
    <!--<div class="col-md-6 col-md-offset-3">-->
        <h1>Lista trenutnih bruto zarada zaposlenih</h1>
        <c:if test="${!empty employees}">
            <table>
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
                            <td>${employee.surname}</td>
                            <td>${employee.type}</td>
                            <td>${employee.faculty}</td>
                            <td>${employee.bacisSelary}</td>
                            <td>${employee.authorFee}</td>
                        </tr>
                    </div>
                </c:forEach>
            </table>
        </c:if>
    <!--</div>-->
</div>
<%@include file="footer.jsp" %>