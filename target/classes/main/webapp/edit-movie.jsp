<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Movie</title>
</head>
<body>
<form action = "editMovieServlet" method="post">
Movie Title: <input type= "text" name="movie" value = "${movieToEdit.movie}">
Movie Director: <input type="text" name="director" value = "${movieToEdit.director}">
Release Date: <input type="text" name="date" value = "${movieToEdit.date}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value ="Save Edited Movie">
</form>
</body>
</html>