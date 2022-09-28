<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="container">
	<hr>
		<h3>Cadastro de Clientes</h3>
	<hr>
	<form action="cadastrar" method="POST">
		<div class="mb-3">
		    <label class="form-label">Nome</label>
		    <input name="nome" type="text" class="form-control" placeholder="name@example.com">
		</div>
		<div class="mb-3">
		    <label class="form-label">Cpf</label>
		    <input name="cpf" name="cpf" type="text" class="form-control" rows="3"></input>
		</div>
		<div class="mb-3">
		    <label class="form-label">Data de Nascimento</label>
		    <input name="nascimento" type="date" rows="3"></input>
		</div>
		<div>
			<div class="col-auto">
			
					<button type="submit" class="btn btn-primary mb-3">Cadastrar Cliente</button>
					<button type="reset" class="btn btn-secondary mb-3">Limpar Formulario</button>
			</div>
		</div>
	</form>
</div>
