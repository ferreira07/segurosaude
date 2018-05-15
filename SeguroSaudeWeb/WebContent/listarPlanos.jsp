<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 

for( entities.Plano p : (java.util.List<entities.Plano>) request.getAttribute("planos")) { %>
<div>
<%= p.getNome() %> | 
<a href="RemoverPlano?id=<%= p.getId() %>">remover</a>
</div>
<% } %>

<div>
<form action="AdicionarPlano">
	<input name="nome" placeholer="novo Plano"/> <input type="submit" value="Cadastrar"> 
</form>
</div>
</body>
</html>