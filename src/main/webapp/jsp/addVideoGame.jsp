<%-- 
    Document   : addVideoGame
    Created on : Aug 12, 2018, 7:23:11 PM
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
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    </head>
    <body>

        <div class="container">
            <jsp:include page="/jsp/navbar.jsp"></jsp:include>

            <h1>Add Video Game</h1>

            <form role="form" method="POST" action="submitGame">
                <label for="title">Title</label>
                <input type="text" name="title" id="title">
                
                <label for="releaseDate">Release Date</label>
                <input type="date" name="date" id="releaseDate">

                <label for="publisher">Publisher</label>
                <input type="text" name="publisher" id="publisher">

                <label for="developer">Developer</label>
                <input type="text" name="developer" id="developer">

                <label for="platforms">Platforms</label>
                <input type="text" name="platforms" id="platforms">

                <label for="description">Description</label>
                <textarea name="description" rows="7" cols="100" id="description"></textarea>


                <input type="submit" value="Add Game">
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
    </body>
</html>
