<%@ page language="java"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" 	prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>:: SyncHostel ::</title>
    <link rel="stylesheet" href=<c:url value='/resources/css/style.css'/> >
  </head>

  <body>
    <div class="wrapper">
	<div class="container">
		<h1>SyncHostel</h1>
		<form:form  method="POST" action="/login.htm" class="form" >
			<form:input path="run" />
			<form:password path="pass" />	
			<button type="submit" name="submit" id="login-button" value="Submit">Login</button>
			<br>
			<a href="">Registar</a>
			<a href="">Recuperar Contraseña</a>
		</form:form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	</div>
  </body>
</html>
