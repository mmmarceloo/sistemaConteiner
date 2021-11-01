<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>movimentacao</title>
</head>

<body>
			<h1>Cadastro de Movimentação</h1>
			
			<form name="frmMovimentacao"  action="inserirMovimentacao">
				<input type="text" name="cpf" placeholder="cpf do cliente"></br></br>
				
				
				<label>Tipo:</label></br>
				<input type="radio"  name="tipoMov" value="em" required>
				<label for="em">embarque</label></br>
				<input type="radio"  name="tipoMov" value="des" required>
				<label for="des">descarga</label></br>
				<input type="radio"  name="tipoMov" value="gin" required>
				<label for="gin">gate in</label></br>
				<input type="radio"  name="tipoMov" value="gout" required>
				<label for="gout">gate out</label></br>
				<input type="radio"  name="tipoMov" value="rep" required>
				<label for="rep">reposicionamento</label></br>
				<input type="radio"  name="tipoMov" value="pes" required>
				<label for="pes">pesagem</label></br>
				<input type="radio"  name="tipoMov" value="sca" required>
				<label for="sca">scanner</label></br>
				
				<input type="text" name="dataInicio" placeholder="data do inicio">
				<input type="text" name="horaInicio" placeholder="hora do inicio">
				</br></br><input type="text" name="dataFim" placeholder="data do fim">
				<input type="text" name="horaFim"  placeholder="hora do fim"></br>
				
					</br><input type="submit" value="cadastrar"/></br>
				
				
				
			</form>
			</br><a href="movimentacao.jsp"><button>voltar</button></a>
			
</body>
</html>