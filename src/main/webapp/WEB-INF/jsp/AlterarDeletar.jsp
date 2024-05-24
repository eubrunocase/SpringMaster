<%@ page import="com.u2.web.SpringDojo.model.LivroModel" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro - Com campos preenchidos</title>
</head>
<body>
<h2>Detalhes do Livro</h2>
<%
LivroModel livro = (LivroModel) request.getAttribute("livro");
%>
<form name="form1" method="get" action="/alterar">
<table>
<tr>
<td><font color="red" size="14"><%= request.getSession().getAttribute("mensagem") != null ? request.getSession().getAttribute("mensagem") : "" %></font></td>
</tr>
<tr>
<td>Cadastro - Campos preenchidos</td>
</tr>
<tr>
<td>TÃtulo</td>
<td><input type="text" name="titulo" value="<%= livro != null ? livro.getTitulo() : "" %>"></td>
</tr>
<tr>
<td>Editora</td>
<td><input type="text" name="editora" value="<%= livro != null ? livro.getEditora() : "" %>"></td>
</tr>
<tr>
<td><button type="submit" formaction="/alterar">Alterar</button></td>
<td><button type="submit" formaction="/remover">Remover</button></td>
</tr>
</table>
</form>
</body>
</html>