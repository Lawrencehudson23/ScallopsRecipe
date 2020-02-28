

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
      <h2>Create new recipe</h2>

	<div class="container">
	<form:form action="/recipe/new" method="post"
		modelAttribute="recipeObj">
	
		<div>
			<form:input type="hidden" path="id" />

			<form:label path="description">Description:</form:label>
			<%-- <form:errors path="description" /> --%>
			<form:input path="description" />

			<form:label path="prepTime">Prep Time:</form:label>
			<%-- <form:errors path="prepTime" /> --%>
			<form:input path="prepTime" />

			<form:label path="cookTime">Cook Time:</form:label>
			<%-- <form:errors path="cookTime" /> --%>
			<form:input path="cookTime" />

			<form:label path="servings">Servings:</form:label>
			<%-- <form:errors path="servings" /> --%>
			<form:input path="servings" />

			<form:label path="servings">Servings:</form:label>
			<%-- <form:errors path="servings" /> --%>
			<form:input path="servings" />

			<form:label path="source">Source:</form:label>
			<%-- <form:errors path="source" /> --%>
			<form:input path="source" />

			<form:label path="url">Url:</form:label>
			<%-- <form:errors path="url" /> --%>
			<form:input path="url" />
		</div>
		<div>
			<form:label path="directions">Directions:</form:label>
			<%-- <form:errors path="directions" /> --%>
			<form:textarea path="directions" />
		</div>
		<div>
			<form:label path="notes">Notes:</form:label>
			<%-- <form:errors path="notes" /> --%>
			<form:textarea path="notes" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
	</div>
      


	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>