<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet">
<link href="css/reset.css" rel="stylesheet">
<title>Main</title>
</head>
<body>
	<div id="header">
		<h1>Система управления складом товаров</h1>
		<span class="action"> <a href="register.jsp"><input
				type="submit" value="Регистрация"></a>
		</span>
	</div>
	<div class="main">
		<div class="login">
			<form action=LoginController method="post">
				<span class="formspan">Логин:</span> <input class="inp" name="login" />
				<span class="formspan">Пароль:</span> <input type="password"
					class="inp" name="password" /> <span class="cb"> <input
					class="cbutton" type="submit" value="войти" />
				</span>
			</form>
		</div>
	</div>
</body>
</html>