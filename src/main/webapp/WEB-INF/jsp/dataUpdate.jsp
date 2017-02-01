<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="header.jsp" %>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <h1>Product list</h1>
        <%--<c:if test="${!empty products}">
            <table>
                <tr>
                    <th width="500"> name</th>
                    <th width="500"> description</th>
                    <th width="500"> price</th>
                    <th width="500"> category</th>
                </tr>
                <c:forEach items="${products}" var="product">
                    <div class="row">
                        <tr>
                            <td>${product.name}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.category}</td>
                            <td><a href="<c:url value='/product/${product.id}' />">see</a></td>
                            <td><a href="<c:url value='/product/${product.id}' />">edit</a></td>
                            <td><a href="<c:url value='/deleteproduct/${product.id}' />">delete</a></td>
                        </tr>
                    </div>
                </c:forEach>
            </table>
        </c:if>--%>
        <form action="<c:url value="/test" />" method="GET">
            <input type="submit" name="action" value="save" />
        </form>

    </div>
</div>
<%@include file="footer.jsp" %>