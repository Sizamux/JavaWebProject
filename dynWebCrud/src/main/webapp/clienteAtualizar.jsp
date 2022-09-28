<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="layout_top.jsp" %>
<div class="container">
	<hr>
		<h3>Atualizar Cliente ${param.clienteId}</h3>
	<hr>
	<form action="atualizar" method="POST">
		<div class="mb-3">
		    <label class="form-label">ID</label>
		    <input name="clienteId" type="number" class="form-control" value="${param.clienteId}" ></input>
		</div>
		<div class="mb-3">
		    <label class="form-label">Nome</label>
		    <input name="nome" type="text" class="form-control" placeholder="Nome">
		</div>
		<div class="mb-3">
		    <label class="form-label">Cpf</label>
		    <input name="cpf" type="text" class="form-control" rows="3" placeholder="Cpf, apenas numero"></input>
		</div>
		<div class="mb-3">
		    <label class="form-label">Data de Nascimento</label>
		    <input name="nascimento" type="date" rows="3"></input>
		</div>
		<div>
			<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">Atualizar Cliente</button>
					<button type="reset" class="btn btn-secondary mb-3">Limpar Formulario</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="layout_bottom.jsp" %>    