<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.JavaBeans" %>
    <%@ page import="java.util.ArrayList" %>
    <%
    ArrayList<JavaBeans> lista =(ArrayList<JavaBeans>) request.getAttribute("dados");
    int importacao = (int)  request.getAttribute("importacao");
    int exportacao = (int)  request.getAttribute("exportacao");
    
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Relatório</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
		<h1>Relatório</h1>

	<h1>Relatório de movimentacao de conteiner</h1>
			<table>
				<thead>
					<tr>
						<th>Cpf</th>
						<th>movimentações</th>
						<th>embarque</th>
						<th>descarga</th>
						<th>gate in</th>
						<th>gate out</th>
						<th>reposicionamento</th>
						<th>pesagem</th>
						<th>scanner</th>
									
					</tr>
				
				</thead>
				<tbody>
				<% System.out.println(lista.get(0).getMov() + "Mov  ja no relatorio");
				for(int i = 0; i < lista.size(); i++){
						%><tr><td><%= lista.get(i).getCpf()%></td>
						<td><%= lista.get(i).getMov()%></td>
						<td><%= lista.get(i).getEm()%></td>
						<td><%= lista.get(i).getDes()%></td>
						<td><%= lista.get(i).getGin()%></td>
						<td><%= lista.get(i).getGout()%></td>
						<td><%= lista.get(i).getRep()%></td>
						<td><%= lista.get(i).getPes()%></td>
						<td><%= lista.get(i).getSca()%></td></tr>
						<%}; %>
						 
						
				
						
				
				
				</tbody>
						
			</table>
			
			<h1>Totais de movimentações</h1>
			<table>
			<thead>
					<tr>
						<th>Tipo</th>
						<th>Totais</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>importação</td>
						<td><%=importacao %></td>
					<tr>
					<td>exportação</td>
					<td><%=exportacao %></td>
					</tr>
					
				</tbody>
					
			
			</table>
	</br><a href="index.html"><button>voltar</button></a>
	
	
</body>	
</html>