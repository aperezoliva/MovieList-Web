<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New List Creation</title>
</head>
<body>
<form action = "createNewListServlet" method ="post">
List Name: <input type = "text" name = "listName"><br />
Trip Date: <input type = "text" name = "month" placeholder = "mm" size = "4"> 
<input type = "text" name = "day" placeholder = "dd" size = "4"> <input type = "text" name = "year"
placeholder="yyyy" size="4">
Production Company Name: <input type = "text" name = "productionCompanyName"><br />

Available Movies: <br />
<select name="allMoviesToadd" multiple size ="6">
<c:forEach items="${requestScope.allMovies }" var="currentmovie">
	<option value = "${currentmovie.id}">${currentmovie.movieName} | ${currentmovie.movieAuthor } | ${currentmovie.releaseDate }
	</option>
</c:forEach>	
</select>
</br />
<input type = "submit" value = "Create List and Add Movies">
</form>
<a href = "index.html">Add a Movie</a>
</body>
</html>