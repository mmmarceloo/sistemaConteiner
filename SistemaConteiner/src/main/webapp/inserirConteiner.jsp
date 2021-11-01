<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>conteiner</title>

<body>
			<h1>Cadastro de Contêiners</h1>
			
			<form name="frmConteiner"  action="inserirConteiner">
				<input type="text" name="cpf" placeholder="cpf do cliente"></br></br>
				<input type="text" name="numero" placeholder="ex: ABCD1234567"></br></br>
				
				<label>Tipo:</label></br>
				<input type="radio" id="20" name="tipo" value="20" required>
				<label for="20">20</label></br>
				<input type="radio" id="40" name="tipo" value="40" required>
				<label for="40">40</label></br>
				
				<label>Status:</label></br>
				<input type="radio" id="cheio" name="sttus" value="cheio" required>
				<label for="cheio">cheio</label></br>
				<input type="radio" id="vazio" name="sttus" value="vazio" required>
				<label for="vazio">vazio</label></br>
				
				<label>Categoria:</label></br>
				<input type="radio" id="importacao" name="categoria" value="importacao" required>
				<label for="importacao">importação</label></br>
				<input type="radio" id="exportacao" name="categoria" value="exportacao" required>
				<label for="exportacao">exportação</label></br>
				
				</br><input type="submit" value="cadastrar"  onclick="validar()"/></br>
				
			</form>
			</br><a href="conteiner.jsp"><button>voltar</button></a>
			<script src="validador.js"></script>
</body>
</html>