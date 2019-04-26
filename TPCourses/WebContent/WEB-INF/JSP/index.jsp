<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="fr.eni.TPCourses.bo.Liste"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row d-flex flex-column h-75">
			<div class="p-2 border bg-info text-light">
				<h1 class="text-center">Course</h1>
			</div>
			<div class="p-2 border bg-light">
				<h3 class="text-center">Listes prédéfinies</h3>
			</div>
			<div class="p-2 bg-light">
			${ListedeListe}
				<c:choose>
					<c:when test="${!empty ListedeListe }">
						<c:forEach var="liste" items="${ListedeListe}">
							<div class="row">
								<div class="col-8">${liste.getNom()}</div>
								<div class="col-2">
									<form action="ServletCommencerCourses" method="get">
										<input type="submit" value="Panier"
											name="boutonCommencerCourses" />
									</form>
								</div>
								<div class="col-2">
									<form action="ServletSupprimerListe" method="get">
										<input type="submit" value="Supprimer" name="boutonSupprimer" />
									</form>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="col text-center">
							<p>Pas de liste de courses disponible.</p>
						</div>
					</c:otherwise>
				</c:choose>
		</div>
	</div>
	<footer class="page-footer h-25 fixed-bottom text-center">
	<form action="ServletAjouterListe" method="get">
		<input type="submit" value="+"
			class="btn btn-info btn-lg rounded-circle" name="boutonAjouter" />
	</form>
	</footer>
</body>
</html>