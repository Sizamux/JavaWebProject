<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<div class="container">
	<hr>
    	<h3>Clientes Cadastrados</h3>>
   	<hr>
   	<table class="table">
   		<thead>
   			<tr>
   				<th>#</th>
   				<th>Nomne</th>
   				<th>cpf</th>
   				<th>Data de Nascimento</th>
   				<th>Data de Registro</th>
   			</tr>
   		</thead>
   		<tbody>
   			<c:forEach items="${clientes}" var="cliente">
   				<tr>
   					<td>${cliente.id}</td>
   					<td>${cliente.nome}</td>
   					<td>${cliente.cpf}</td>
   					<td>${cliente.data_de_nascimento}</td>
   					<td>${cliente.data_de_registro}</td>
   					<td>
   						<a href="delete?clienteId=${cliente.id}">deletar</a>
   						<a href="clienteAtualizar.jsp?clienteId=${cliente.id}">atualizar</a>
    					</td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>
</div>