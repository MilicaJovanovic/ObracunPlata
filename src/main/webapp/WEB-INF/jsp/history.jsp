<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="header.jsp" %>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <h1>Lista dokumenata</h1>
        
         <c:if test="${!empty files}">
            <table class="table table-striped" style="margin-top: 20px;">
                <tr>
                    <th width="500"> Naziv dokumenta </th>
                    <th width="500"> Preuzmi </th>
                </tr>
                <c:forEach items="${files}" var="file">
                    <div class="row">
                        <tr>
                            <td>${file}</td>
                            <td>
                                <form action="<c:url value="/history/download/${file}" />" method="GET">
                                    <input type="submit" name="action" value="Preuzmi" class="btn btn-primary" style="background-color: #19B396; width: 30%; height: 30px; padding: 0px !important;" />
                                </form>  
                            </td>
                        </tr>
                    </div>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
<%@include file="footer.jsp" %>