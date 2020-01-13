<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/movie.css">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<a href="ShowFavourite">Favorites</a> <a href="ShowMovieListAdmin">Movies</a>
		<img src="images/movie crusier image.png">
	</div>
	<c:if test="${message}">
		<div class="success-message">Movie removed from Favorite
			successfully</div>
	</c:if>
	<h1>Favorites</h1>
	<table>
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
		</tr>
		<c:forEach items="${favourite.movieList}" var="movies">
			<tr>
				<td>${movies.title}</td>
				<td>$<fmt:setLocale value="en_IN" /> <fmt:formatNumber
						value="${movies.gross}" type="currency"
						pattern="#,##,##,##,###.00" /></td>
				<td>${movies.genre}</td>
				<td><a href="RemoveFavourite?id=${movies.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td><b>Number of favorites: </b></td>
			<td>${favourite.total}</td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>