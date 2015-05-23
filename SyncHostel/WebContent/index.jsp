<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>:: SyncHostel ::</title>
        <link rel="stylesheet" href="css/style.css">
  </head>

  <body>
    <div class="wrapper">
	<div class="container">
		<h1>SyncHostel</h1>
		<form id="loginForm" action="LoginServlet" method="post" class="form">
			<input type="text" name="run" placeholder="RUN">
			<input type="password" name="password" placeholder="Password">
			<button type="submit" name="submit" id="login-button">Login</button>
			<input type="hidden" value="login" name="accion"/>
			<br>
			<a href="">Registar</a>
			<a href="">Recuperar Contraseña</a>
		</form>
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
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="js/index.js"></script>
  </body>
</html>
