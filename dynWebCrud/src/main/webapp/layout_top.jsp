<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<!-- CSS only -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
		<title>Projeto Web - Com Banco de Dados</title>
	</head>
	<body>
		<!-- NavBarr-Bootstrap -->
		<nav class="navbar navbar-expand-lg bg-light">
			<div class="container-fluid">
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        	<li class="nav-item">
			          		<a class="nav-link active" aria-current="page" href="main">Home</a>
		        		</li>
		        		<li class="nav-item">
			          		<a class="nav-link active" aria-current="page" href="contato.jsp">Contato</a>
		        		</li>
				        <li class="nav-item">
				          	<a class="nav-link" href="clientes">Clientes</a>
				        </li>
			      	</ul>
			      	<form class="d-flex" role="search">
				        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
				        <button class="btn btn-outline-success" type="submit">Buscar</button>
			      	</form>
			    </div>
			</div>
		</nav>
