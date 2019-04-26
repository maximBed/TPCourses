<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">

		<h1>COURSES</h1>
		
		<h2>Listes prédéfinies</h2>
		
			<c:choose>
				<c:when test="${!empty ListedeListe }">
					<c:forEach var="liste" items="${ListedeListe}">
						<div class="row">
								${liste.getNom()}
								<form action="ServletCommencerCourses" method="get">
									<input type="submit" value="Panier" name="boutonCommencerCourses"/>
								</form>
								<form action="ServletSupprimerListe" method="get">
									<input type="submit" value="Supprimer" name="boutonSupprimer"/>
								</form>
						</div>	
							
					</c:forEach>
				</c:when>
				<c:otherwise>
						<p>Pas de liste de courses disponible.</p>
				</c:otherwise>
			</c:choose>
		
		<form action="ServletAjouterListe" method="get">
			<input type="submit" value="+" name="boutonAjouter"/>
		</form>
</div>	
		
</body>
</html>