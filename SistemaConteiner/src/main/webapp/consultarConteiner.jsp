<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Conteiners</title>
</head>
<body>
	<h1>Consulta de Conteiner</h1>
	<form name="frmConsultaConteiner" action="consultaConteiner">

		<input type="text" name="numero" placeholder="numero do conteiner" />
		<input type="submit" value="consultar"/></br>
	</form>

	<h3>Preencha novamente se quiser editar e depois botão "salvar"</h3>

	<form name="frmConteiner" action="modificarConteiner">
		</br> 
		<label>Cpf do Cliente</label></br>
		<input type="text" name="cpf"
			value="<%out.print(request.getAttribute("cpf"));%>" readonly /></br> </br> 
			
			<label>Número do contêiner</label></br>
			<input type="text" name="numero" id="numero"
			value="<%out.print(request.getAttribute("numero"));%>" />
			
			</br> <label>Tipo:</label></br>
			<input type="text" name="tipo"
			value="<%out.print(request.getAttribute("tipo"));%>" /></br>
			
			   <label>Status:</label></br>
			 <input type="text" name="status"
			value="<%out.print(request.getAttribute("status"));%>" /></br> 
			
			<label>Categoria:</label></br>
			<input type="text" name="categoria"
			value="<%out.print(request.getAttribute("categoria"));%>" /><br>

		</br><input type="submit" value="salvar" />
		<input type="submit" value="excluir" onclick="confirmarC()" />
	</form>
	</br>
	

	<a href="conteiner.jsp">
		<button>voltar</button>
	</a>
	<script src="confirmar.js"></script>
	
</body>
</html>