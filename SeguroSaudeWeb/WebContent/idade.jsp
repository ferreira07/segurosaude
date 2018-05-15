<%@page import="entities.FaixaEtaria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
<form action="ListarFaixas">
	<input name="idade" placeholer="Digite a idade"/> <input type="submit" value="Enviar"> 
</form>
</div>
<% 

for( FaixaEtaria f : (java.util.List<entities.FaixaEtaria>) request.getAttribute("faixas")) { %>
<div>
Plano (<%= f.getPlanoId() %>)
<%= f.getValor() %>
</div>
<% } %>

</body>
</html>