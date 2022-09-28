<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ include file="layout_top.jsp" %>
<form action="clientes" method="GET" class="d-flex" role="search">
<div class="container">
	<h1>Clientes</h1>
	<div class="row">
		<div class="cold-md-7">
			<form action="cliente" method="GET" class="d-flex" role="search">
		        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
		        <button class="btn btn-outline-success" type="submit">Buscar</button>
	      	</form>
	      	<%@ include file="clientesView.jsp" %>
	      	<%@ include file="clienteCadastro.jsp" %>
	      	
	      	
		</div>
	</div>
</div>

<%@ include file="layout_bottom.jsp" %>