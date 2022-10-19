<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
	<table>
	<c:forEach items="${requestScope.allMovies}" var="currentmovie">
	<tr>
		<td><input type="radio" name="id" value="${currentmovie.id}"></td>
		<td>${currentmovie.movieName}</td>
		<td>${currentmovie.movieAuthor}</td>
		<td>${currentmovie.releaseDate}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisToItem">
	<input type = "submit" value = "delete" name="doThisToItem">
	<input type="submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>