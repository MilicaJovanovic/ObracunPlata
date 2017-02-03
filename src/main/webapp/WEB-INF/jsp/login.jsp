<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <title>Prijava</title>
    </head>
    <body>
        <h1>Unesite svoje korisnicke podatke</h1>
        <form name='loginForm'  method='POST'>
            <table>
                <tr>
                    <td>Korisnicko ime</td>
                    <td><input type='text' name='username'></td>
                </tr>
                <tr>
                    <td>Lozinka</td>
                    <td><input type='password' name='password'/></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>