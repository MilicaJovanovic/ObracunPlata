<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="header.jsp" %>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <h1>Lista dokumenata</h1>
<!--        <h2><a href="/history/download">Click here to download file</a></h2>
        
        <form action="<c:url value="/history/download" />" method="GET">
            <input type="submit" name="action" value="Azuriraj podatke" class="btn btn-primary" style="background-color: #19B396; margin-top: 30px;" />
        </form>-->
         <c:if test="${!empty files}">
            <table class="table table-striped" style="margin-top: 20px;">
                <tr>
                    <th width="500"> Naziv dokumenta </th>
                </tr>
                <c:forEach items="${files}" var="file">
                    <div class="row">
                        <tr>
                            <td>${file}</td>
                        </tr>
                    </div>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
<%@include file="footer.jsp" %>