<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>movimentacao</title>
</head>

<body>
			<h1>Consulta de Movimentação</h1>
	<form name="frmConsultaMovimentacao" action="consultarMovimentacao">

		<input type="text" name="cpf" placeholder="cpf do cliente"></br></br>
		<input type="submit" value="consultar"/></br>
	</form>

	<h3>Preencha novamente se quiser editar e depois botão "salvar"</h3>

				<form name="frmMovimentacao"  action="modificarMovimentacao">
				<label>Cpf do Cliente</label></br>
				<input type="text" name="cpf"
				value="<%out.print(request.getAttribute("cpf"));%>" readonly /></br> </br> 
				
				<h3>Tipo de movimentação</h3>
				<table>
							<tr>
							<td><label>Embarque:</label></td>
							<td><input type="text" name="em"
							value="<%out.print(request.getAttribute("em"));%>"  />  </td>
							
							<td><label>Descarga:</label></td>
							<td><input type="text" name="des"
							value="<%out.print(request.getAttribute("des"));%>"  /> </td>
							
							<td><label>Gate in:</label></td>
							<td><input type="text" name="gin"
							value="<%out.print(request.getAttribute("gin"));%>"  /></td>
							
							<td><label>Gate out:</label><td>
							<td><input type="text" name="gout"
							value="<%out.print(request.getAttribute("gout"));%>"  /></td>
						</tr>
						<tr>
						
								<td><label>Reposicionamento:</label></td>
								<td><input type="text" name="rep"
								value="<%out.print(request.getAttribute("rep"));%>"  /> </td>
								
								<td><label>Pesagem:</label></td>
								<td><input type="text" name="pes"
								value="<%out.print(request.getAttribute("pes"));%>"  /> </td>
								
								<td><label>Scanner:</label></td>
								<td><input type="text" name="sca"
								value="<%out.print(request.getAttribute("sca"));%>"  /></td>
						</tr>
						<tr>
								<td><label>Total de movimentação:</label></td>
								<td><input type="text" name="mov"
								value="<%out.print(request.getAttribute("mov"));%>"  /></td>
						</tr>
						
				</table>	</br>	
				
				
				
				<label>Data de início:</label>
				<input type="text" name="dataInicio"
				value="<%out.print(request.getAttribute("dataInicio"));%>"  />
				
				<label>Hora de início:</label>
				<input type="text" name="horaInicio"
				value="<%out.print(request.getAttribute("horaInicio"));%>"  /></br> </br>  
				
				<label>Data do fim:</label>
				<input type="text" name="dataFim"
				value="<%out.print(request.getAttribute("dataFim"));%>"  />
				
				<label>Hora do fim:</label>
				<input type="text" name="horaFim"
				value="<%out.print(request.getAttribute("horaFim"));%>"  /></br> </br>  
				
				
				
				</br><input type="submit" value="salvar" />
				<input type="submit" value="excluir" onclick="confirmarM()" />
				
				
			</form>
			</br><a href="movimentacao.jsp"><button>voltar</button></a>
	<script src="confirmar.js"></script>	
</body>
</html>