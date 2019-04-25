<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h1>COURSES</h1>
		
		<h2>Listes prédéfinies</h2>
		<div class="container">
		
			<c:choose>
				<c:when test="${!empty ListedeListe }">
					<c:forEach var="liste" items="${ListedeListe}">
						<div class="row">
								${liste.getNom()}
								
						</div>	
							
					</c:forEach>
				</c:when>
				<c:otherwise>
						<p>Pas de liste de courses disponible.</p>
				</c:otherwise>
			</c:choose>
		</div>
		
		<form action="ServletAjouterListe" method="get">
			<input type="submit" value="+" name="boutonAjouter"/>
		</form>
		
		
</body>
</html>