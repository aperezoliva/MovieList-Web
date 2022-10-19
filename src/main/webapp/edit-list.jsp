<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Existing List</title>
</head>
<body>
<form action = "editListDetailsServlet" method "post">
<input type = "hidden" name ="id" value ="${listToEdit.id }">
List Name: <input type = "text" name = "listName" value = "${listToEdit.listName}"><<br />
Trip Date: <input type = "text" name = "month" placeholder ="mm" size= "4" value = "${month}">,
<input type = "text" name = "day" placeholder = "dd" size="4" value="${date}">,
<input type = "text" name = "year" placeholder = "yyyy" size="4" value ="${year }">

Production Company Name: <input type = "text" name ="productionCompanyName" value="${listToEdit.productioncompany.productionCompanyName }"><br/>

Available Movies: <br />
<select name= "allMoviesToAdd" multiple size ="6">
<c:forEach items="${requestScope.allMovies}" var ="currentMovie">
	<option value = "${currentmovie.id}">${currentmovie.movieName} | ${currentmovie.movieAuthor } | ${currentmovie.releaseDate } </option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">
</form>
<a href = "index.html">Add Movies</a>
</body>
</html>