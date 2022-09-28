<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ include file="layout_top.jsp" %>
<div class="container">
	<hr>
		<h3>Sejam bem vindos ao Projeto de Crud da Danniele</h3>
		<br>
		<h3>Este projeto utiliza os conceitos de:</h3>
		<ol>
			<li> Linguagem de programação: JAVA; IDE utilizada: Elclipse para web; Tipo de Projeto: Dynamic WEB</li>
			<li> MVC(Model[Java],Views[em Jsp],Controllers[Servlet])</li>
			<li> CRUD(com Existencia de uma Interface onde Crud de tabelas as herdam)</li>
			<li> DAO(estabelecendo Conexão com o BD)</li>
			<li> Containers(Trabalhados em JSP)</li>
		</ol>
		<h3>Servidores utilizados:</h3>
		<ol>
			<li> TomCat 10</li>
			<li> Mysql Server 8.0.30</li>
		</ol>
		<h3>Bibliotecas adicionadas para conexão MYSQL e TomCat10:</h3>
		<ol>
			<li> /dynWebCrud/src/main/webapp/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar</li>
			<li> /dynWebCrud/src/main/webapp/WEB-INF/lib/jakarta.servlet.jsp.jstl-api-2.0.0.jar</li>
			<li> /dynWebCrud/src/main/webapp/WEB-INF/lib/mysql-connector-java-8.0.30.jar</li>
		</ol>
		<h3>Notas:</h3>
		<ol>
			<li> Utilização de Bootstrap</li>
			<li> String de conexão ao servidor MySql em db.DAO</li>
		</ol>
	<hr>
</div>
<%@ include file="layout_bottom.jsp" %>    