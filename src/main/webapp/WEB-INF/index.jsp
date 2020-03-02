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
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
<body>
	<nav class="white" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="/" class="brand-logo">Scallopsrecipes<i
				class="material-icons">face</i></a>


			<ul class="right hide-on-med-and-down">
				<li><a href="/admin"><c:out value="${currentUser.username}" /></a>
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
				<br> <br>
				<h1 class="header center teal-text text-lighten-2">Scallopsrecipes</h1>
				<div class="row center">
					<h5 class="header col s12 light">Create your own recipe</h5>
				</div>
				<div class="row center">
					<a href="/recipe/new" id="download-button"
						class="btn-large waves-effect waves-light teal lighten-1">Get
						Started</a>
				</div>
				<br> <br>

			</div>
		</div>
		<div class="parallax">
			<img src="img/b3.jpg" alt="Unsplashed background img 1">
		</div>
	</div>


	<div class="container">
		<div class="section">
			<!--   Icon Section   -->
			<div class="row">
				<c:forEach var="i" begin="0" end="${listTitles.size() - 1}">

					<div class="col s12 m4">
						<div class="icon-block">
								<h6 class="center">
									<a href="/recipes/${listIds.get(i)}"><img src="${listImages.get(i)}" alt=""></a>
								</h6>
								<h6 class="center">
									<a href="${listSourceUrls.get(i)}">${listTitles.get(i)}</a>
								</h6>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>



	<div class="parallax-container valign-wrapper">
		<div class="section no-pad-bot">
			<div class="container">
				<div class="row center">
					<h5 class="header col s12 light">${joke1 }</h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="img/b2.jpg" alt="Unsplashed background img 2">
		</div>
	</div>

<div class="container">
		<div class="section">
			<!--   Icon Section   -->
			<div class="row">
				<c:forEach items="${allRecipes}" var="r">

					<div class="col s12 m4">
						<div class="icon-block">
								<h6 class="center">
									<a href="/recipes/${r.id}"><img src="${r.imageUrl}" alt=""></a>
								</h6>
								<h6 class="center">
									<a href="/recipes/${r.id}">${r.name}</a>
								</h6>
								<h6 class="center">
									${r.creator.username}
								</h6>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>



	<div class="parallax-container valign-wrapper">
		<div class="section no-pad-bot">
			<div class="container">
				<div class="row center">
					<h5 class="header col s12 light">${joke2 }</h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="img/b4.jpg" alt="Unsplashed background img 3">
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
						<li><a class="white-text" href="#!">Aya</a></li>
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
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>

</body>
</html>
