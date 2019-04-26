<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nouvelle Liste</title>
</head>
<body>
	<h1>Courses</h1>
	
	<h2>Nouvelle liste</h2>
	
	<form action="ServletAjouterListe" method="POST">
	<label>Nom: </label>
	<input type="textbox" placeholder="Saississez le nom de votre liste" name="textboxListe"/>
	
	<c:choose>
		<c:when test="${!empty listeEnCours }">
			<c:forEach var="article" items="${listeEnCours.getArticles()}">
				<div class="row">
						${article.getNom()}
				</div>		
			</c:forEach>
		</c:when>
		<c:otherwise>
				<p>Pas de liste de courses disponible.</p>
		</c:otherwise>
	</c:choose>
	
	<label>Article: </label>
	<input type="textbox" placeholder="Saississez le nom de votre article" name="textboxArticle"/>
	<input type="submit" name="boutonAjouterArticle" value="+"/>
	
	</form>
	
	<form action="ServletIndex" method="get">
		<input type="submit" value="->" name="retourIndex"/>
	</form>
	
</body>
</html>