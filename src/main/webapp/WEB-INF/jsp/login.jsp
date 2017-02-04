<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://code.jquery.com/jquery-3.1.1.js" integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css"/>
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <title>Obracun plata</title>
    </head>
    <body style="background-color: #EDEDED; -webkit-font-smoothing: antialiased; font: normal 14px Roboto,arial,sans-serif;">
        <div class="container">
            <div style="width: 40%; margin-left: auto; margin-right: auto; margin-top: 100px; height: 50px; color: #2C3E50; text-align: center; font-size: 26px; text-shadow: 2px 2px #fff;">
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>
            </div>
            <div class="row">
            	<form name='loginForm' action="<c:url value='/j_spring_security_check'/>" method='POST'>
                    <div class="form-login" style="margin-top: 80px !important; width: 40% !important; background-color: #2C3E50; padding-top: 10px; padding-bottom: 20px; padding-left: 20px; padding-right: 20px; border-radius: 15px; border-color:#d2d2d2; border-width: 5px; box-shadow:0 1px 0 #cfcfcf; margin-left: auto; margin-right: auto;">
                        <h4 style=" border:0 solid #fff; border-bottom-width:1px; padding-bottom:10px; text-align: center; color: #fff;">Dobrodosli u sistem za obracun plata</h4>
                        <br>
                        <input type="text" id="username" name="username" class="form-control input-sm chat-input" placeholder="Unesite korisncko ime" style="border-radius: 10px;" />
                        <br>
                        <input type="password" id="password" name="password" class="form-control input-sm chat-input" placeholder="Unesite lozinku" style="border-radius: 10px;"/>
                        <br>
                        <div class="wrapper" style="text-align: center;">
                            <span class="group-btn">     
                                <input type="submit" class="btn btn-primary btn-md" style="background-color: #19B396; width: 100%;" name="submit" value="Prijavi se" />
                            </span>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>
        </div>
    </body>
</html>