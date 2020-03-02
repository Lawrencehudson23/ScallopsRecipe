<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE >
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Parallax Template - Materialize</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="../css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="../css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
<body>
	<nav class="white" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="/" class="brand-logo">Scallopsrecipes<i
				class="material-icons">face</i></a>


			<ul class="right hide-on-med-and-down">
				<li><a href="/login"><c:out value="${currentUser.username}" /></a>
			</ul>
			<ul class="right hide-on-med-and-down">
				<li><a href="/favorite"><i class="material-icons">favorite</i></a></li>
			</ul>

			<ul id="nav-mobile" class="sidenav">
				<li><a href="/login"><i class="material-icons">account_circle</i></a></li>
			</ul>

			<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
		</div>
	</nav>

	<div id="index-banner" class="parallax-container">
		<div class="section no-pad-bot">
			<div class="container">
				<br>
				<br>
				<h1 class="header center teal-text text-lighten-2">Create
					Recipe</h1>
				<div class="row center">
					<h5 class="header col s12 light">Create your own recipe</h5>
					<h2>Create new recipe</h2>

					<div class="container">
						<form:form action="/recipe/new" method="post"
							modelAttribute="recipeObj" enctype="multipart/form-data">

							<div>
								<form:input type="hidden" path="id" />

								<form:label path="name">Name:</form:label>
								<%-- <form:errors path="name" /> --%>
								<form:input path="name" />
<%-- 
								<form:label path="prepTime">Prep Time:</form:label>
								<form:errors path="prepTime" />
								<form:input path="prepTime" />

								<form:label path="cookTime">Cook Time:</form:label>
								<form:errors path="cookTime" />
								<form:input path="cookTime" />

								<form:label path="servings">Servings:</form:label>
								<form:errors path="servings" />
								<form:input path="servings" />


								<form:label path="source">Source:</form:label>
								<form:errors path="source" />
								<form:input path="source" />  --%>

								<label>Image:</label>
								<input type="file" name="image" /> 
							</div>
							<br>
							<br>
<%-- 							<div>
								<form:label path="ingredients">Ingredients:</form:label>
								<form:errors path="ingredients" />
								<form:input path="ingredients" />
							</div> --%>
							<div>
								<form:label path="directions">Directions:</form:label>
								<%-- <form:errors path="directions" /> --%>
								<form:input path="directions" />
							</div>

							<div class="row center">
								<button id="download-button"
									class="btn-large waves-effect waves-light teal lighten-1">
									Create Recipe</button>
							</div>
							
						</form:form>
					</div>
				</div>

				<br>
				<br>

			</div>
		</div>
		<div class="parallax">
			<img src="../img/b3.jpg" alt="Unsplashed background img 1">
		</div>
	</div>


	<div class="container">
		<div class="section">
			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center brown-text">
							<i class="material-icons">fingerprint</i>
						</h2>
						<h5 class="center">Roasted Chicken</h5>

						<p class="light">We did most of the heavy lifting for you to
							provide a default stylings that incorporate our custom
							components. Additionally, we refined animations and transitions
							to provide a smoother experience for developers.</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center brown-text">
							<i class="material-icons">group</i>
						</h2>
						<h5 class="center">Grandma's Lemon Meringue Pie</h5>

						<p class="light">By utilizing elements and principles of
							Material Design, we were able to create a framework that
							incorporates components and animations that provide more feedback
							to users. Additionally, a single underlying responsive system
							across all platforms allow for a more unified user experience.</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center brown-text">
							<i class="material-icons">settings</i>
						</h2>
						<h5 class="center">Easy to work witChocolate Chocolate Chip
							Cookies</h5>

						<p class="light">We have provided detailed documentation as
							well as specific code examples to help new users get started. We
							are also always open to feedback and can answer any questions a
							user may have about Materialize.</p>
					</div>
				</div>
			</div>

		</div>
	</div>


	<div class="parallax-container valign-wrapper">
		<div class="section no-pad-bot">
			<div class="container">
				<div class="row center">
					<h5 class="header col s12 light">java is great</h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="../img/b2.jpg" alt="Unsplashed background img 2">
		</div>
	</div>

	<div class="container">
		<div class="section">

			<div class="row">
				<div class="col s12 center">
					<h3>
						<i class="mdi-content-send brown-text"></i>
					</h3>
					<h4>Contact Us</h4>
					<p class="left-align light">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Nullam scelerisque id nunc nec
						volutpat. Etiam pellentesque tristique arcu, non consequat magna
						fermentum ac. Cras ut ultricies eros. Maecenas eros justo,
						ullamcorper a sapien id, viverra ultrices eros. Morbi sem neque,
						posuere et pretium eget, bibendum sollicitudin lacus. Aliquam
						eleifend sollicitudin diam, eu mattis nisl maximus sed. Nulla
						imperdiet semper molestie. Morbi massa odio, condimentum sed ipsum
						ac, gravida ultrices erat. Nullam eget dignissim mauris, non
						tristique erat. Vestibulum ante ipsum primis in faucibus orci
						luctus et ultrices posuere cubilia Curae;</p>
				</div>
			</div>

		</div>
	</div>


	<div class="parallax-container valign-wrapper">
		<div class="section no-pad-bot">
			<div class="container">
				<div class="row center">
					<h5 class="header col s12 light">I love java</h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="../img/b4.jpg" alt="Unsplashed background img 3">
		</div>
	</div>

	<footer class="page-footer teal">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">Company Bio</h5>
					<p class="grey-text text-lighten-4">We are a team of scallops
						working on this project like it's our full time job. Any amount
						would help support and continue development on this project and is
						greatly appreciated.</p>


				</div>
				<div class="col l3 s12">
					<h5 class="white-text">Settings</h5>
					<ul>
						<li><a class="white-text" href="#!">Monkey D Luffy</a></li>
						<li><a class="white-text" href="#!">Roronoa Zoro</a></li>
						<li><a class="white-text" href="#!">Nami</a></li>
						<li><a class="white-text" href="#!">Usopp</a></li>
						<li><a class="white-text" href="#!">Vinsmoke Sanji</a></li>
						<li><a class="white-text" href="#!">Tony Tony Chopper</a></li>
						<li><a class="white-text" href="#!">Nico Robin</a></li>
						<li><a class="white-text" href="#!">Franky</a></li>
						<li><a class="white-text" href="#!">Lawrence</a></li>
					</ul>
				</div>
				<div class="col l3 s12">
					<h5 class="white-text">Connect</h5>
					<ul>
						<li><a class="white-text" href="#!">1(234)567-8901</a></li>
						<li><a class="white-text" href="#!">1(234)567-8902</a></li>
						<li><a class="white-text" href="#!">1(234)567-8903</a></li>
						<li><a class="white-text" href="#!">1(234)567-8904</a></li>
						<li><a class="white-text" href="#!">1(234)567-8905</a></li>
						<li><a class="white-text" href="#!">1(234)567-8906</a></li>
						<li><a class="white-text" href="#!">1(234)567-8907</a></li>
						<li><a class="white-text" href="#!">1(234)567-8908</a></li>
						<li><a class="white-text" href="#!">1(234)567-8909</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">
				Made by <a class="brown-text text-lighten-3"
					href="http://materializecss.com">Materialize</a>
			</div>
		</div>
	</footer>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="../js/materialize.js"></script>
	<script src="../js/init.js"></script>

</body>
</html>
