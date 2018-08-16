<%-- 
    Document   : addVideoGame
    Created on : Aug 12, 2018, 4:27:30 PM
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
        
        <!--NEED TO ADD MORE TO THE FORM-->
        <!--https://lms.thesoftwareguild.com/courses/68/pages/step-08-update-functionality?module_item_id=8649-->
        <div class="container">
            <jsp:include page="/jsp/navbar.jsp"></jsp:include>
                <h1>Edit Video Game</h1>
                <h2>${videoGame.title}</h2>
            <sf:form role="form" action="submitUpdatedGame" method="POST" modelAttribute="VideoGame">
                <label for="title">Title</label>
                <br>
                <input type="text" name="title" value="${videoGame.title}" id="title">
                <br>
                <label for="releaseDate">Release Date</label>
                <br>
                <input type="date" name="date" id="releaseDate">
                <br>
                <label for="publisher">Publisher</label>
                <br>
                <input id="publisher" value=" ${videoGame.publisher}">
                <br>
                <label for="developer">Developer</label>
                <br>
                <input id="developer" value="${videoGame.developer}">
                <br>
                <label for="platforms">Platforms</label>
                <br>
                <input id="platforms" value="${videoGame.platforms}">
                <br>
                <label for="description">Description</label>
                <br>
                <textarea rows="7" cols="100" id="description">${videoGame.description}</textarea>

                <a href="${pageContext.request.contextPath}/library" type="button">Edit</a>

            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
    </body>
</html>
