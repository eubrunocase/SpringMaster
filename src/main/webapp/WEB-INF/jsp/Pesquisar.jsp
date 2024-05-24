
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pesquisar</title>
</head>
<body>


<form name="form1" method="get" action="/pesquisar">
    <table>
        <tr>
            <td><font color="red" size="14"><%= request.getSession().getAttribute("mensagem")!= null ?request.getSession().getAttribute("mensagem"):""  %></font>
        </tr>
        <tr>
            <td>Digite os dados do livro</td>
        </tr>

        <tr>
            <td>Título</td>
            <td><input type="text" name="titulo"></td>
        </tr>
        <tr>
            <td><button type="submit" >Enviar</button></td>
            <td><input type="reset" value="Limpar"></td>
        </tr>

    </table>
    <table>
        <tr>
            <td>
            <td><font color="red" size="14"><%= request.getSession().getAttribute("livros")!= null ?request.getSession().getAttribute("livros"):""  %></font>
            </td>
        </tr>

    </table>
</form>
<% request.getSession().removeAttribute("livros"); %>
<% request.getSession().removeAttribute("mensagem"); %>

</body>
</html>
