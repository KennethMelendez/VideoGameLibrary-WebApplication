<%-- 
    Document   : library
    Created on : Aug 12, 2018, 2:44:42 PM
    Author     : kmlnd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    </head>
    <body>

        <div class="container">
            <jsp:include page="/jsp/navbar.jsp"></jsp:include>
                <h1>Hello! Welcome to your library.</h1>



                <table>
                    <thead>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                    <c:forEach var="currentGame" items="${gameList}">
                        <tr>
                            <td><b><a href="${pageContext.request.contextPath}/viewGame?videoGameId=${currentGame.videogameid}"><c:out value="${currentGame.title}"/></a></b></td>
                            <td><c:out value="${currentGame.description}"/></td>
                            <td><a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/editVideoGame?videoGameId=${currentGame.videogameid}" role="button">Edit</a></td>
                            <td><a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/removeGame?videoGameId=${currentGame.videogameid}" role="button">Delete</a></td>                    
                        </tr>

                    </c:forEach>
                </tbody>
            </table>



        </div>



        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>

    </body>
</html>
