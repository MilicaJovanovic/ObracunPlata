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
         <script>
            $(document).ready(function(){
                $("table").DataTable();
            });
        </script>
    </head>
    <body style="background-color: #EDEDED; -webkit-font-smoothing: antialiased; font: normal 14px Roboto,arial,sans-serif;">
        <div class="container">
            <div class="row">
<!--                <div class="form-login" style="margin-top: 200px !important; width: 40% !important; background-color: #2C3E50; padding-top: 10px; padding-bottom: 20px; padding-left: 20px; padding-right: 20px; border-radius: 15px; border-color:#d2d2d2; border-width: 5px; box-shadow:0 1px 0 #cfcfcf; margin-left: auto; margin-right: auto;">
                    <h4 style=" border:0 solid #fff; border-bottom-width:1px; padding-bottom:10px; text-align: center; color: #fff;">Dobrodosli u sistem za obracun plata</h4>
                    </br>
                    <input type="text" id="username" class="form-control input-sm chat-input" placeholder="Unesite korisncko ime" style="border-radius: 10px;" />
                    </br>
                    <input type="text" id="password" class="form-control input-sm chat-input" placeholder="Unesite lozinku" style="border-radius: 10px;"/>
                    </br>
                    <div class="wrapper" style="text-align: center;">
                        <span class="group-btn">     
                            <a href="#" class="btn btn-primary btn-md" style="background-color: #19B396; width: 100%;">Prijavi se <i class="fa fa-sign-in"></i></a>
                        </span>
                    </div>
                </div>-->
                <h3>Izvestaj o zaradi za zaposlene nastavnike</h3>
                <label>Ime i prezime: </label><br>
                <label>Zvanje: </label><br>
                <label>Radni odnos: </label><br>
                <label>Broj predmeta na OAS: </label><br>
                <label>KBP: </label><br>
                <label>KRO: </label><br>
                <label>KT: </label><br>
                <label>KPR: </label><br>
                <label>Vrednost boda: </label><br>
                <label>Specijalni dodatak: </label><br>
                <label>Funcionalni dodatak: </label><br>
                <label>Osnovna zarada: </label><br>
                
                <h3>Angazovanje u nastavi</h3>
                <table class="table table-striped">
                    <tr>
                        <th width="500"> Predmet</th>
                        <th width="500"> Predavanja</th>
                        <th width="500"> Grupne vezbe</th>
                        <th width="500"> Individualne vezbe</th>
                        <th width="500"> ESPB</th>
                        <th width="500"> Broj grupa</th>
                        <th width="500"> Tip nastave</th>
                        <th width="500"> Lokacija</th>
                        <th width="500"> Zarada na predmetu</th>
                    </tr>
                     <div class="row">
                        <tr>
                            <td>CS101</td>
                            <td>3</td>
                            <td>1</td>
                            <td>3</td>
                            <td>8</td>
                            <td>2</td>
                            <td>Tradicionalna</td>
                            <td>Nis</td>
                            <td>68000</td>
                        </tr>
                    </div>
                    <%--<c:forEach items="${products}" var="product">--%>
<!--                        <div class="row">
                            <tr>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.price}</td>
                                <td>${product.category}</td>
                                <td><a href="<c:url value='/product/${product.id}' />">see</a></td>
                                <td><a href="<c:url value='/product/${product.id}' />">edit</a></td>
                                <td><a href="<c:url value='/deleteproduct/${product.id}' />">delete</a></td>
                            </tr>
                        </div>-->
                    <%--</c:forEach>--%>
                </table>
                
            </div>
        </div>
    </body>
</html>