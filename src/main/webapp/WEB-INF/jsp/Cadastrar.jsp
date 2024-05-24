<%@ page import="com.u2.web.SpringDojo.model.LivroModel" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
<form name="form1" method="post" action="/cadastrar">
<table>
<tr>
<td><font color="red" size="14"><%= request.getSession().getAttribute("mensagem") != null ? request.getSession().getAttribute("mensagem") : "" %></font></td>
</tr>
<tr>
<td>Digite os dados do livro</td>
</tr>
<tr>
<td>Título</td>
<td><input type="text" name="titulo"></td>
</tr>
<tr>
<td>Editora</td>
<td><input type="text" name="editora"></td>
</tr>
    <% String redirectURL = "/pesquisarLivro";%>
<tr>
<td><button type="submit">Enviar</button></td>
<td><input type="reset" value="Limpar"></td>
    <td><input type="button" name="pesquisar"  onclick="document.location.href='<%= redirectURL %>'" value="pesquisar"></td>
</tr>
</table>
</form>

<h2>Lista de Livros Cadastrados</h2>
<table border="1">
<tr>
<th>Título</th>
<th>Editora</th>
</tr>
<%
List<LivroModel> livros = (List<LivroModel>) request.getAttribute("livros");
if (livros != null) {
for (LivroModel livro : livros) {
%>
<tr>
<td><a href="${pageContext.request.contextPath}/alterar?titulo=<%= livro.getTitulo() %>&editora=<%= livro.getEditora() %>"><%= livro.getTitulo() %></a></td>
<td><%= livro.getEditora() %></td>
</tr>
<%
}
}
%>
</table>

<% request.getSession().removeAttribute("mensagem"); %>

</body>
</html>