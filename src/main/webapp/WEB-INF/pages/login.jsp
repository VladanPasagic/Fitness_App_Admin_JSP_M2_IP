<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<h2>Login</h2>
		<form action="?action=login" method="post">
			<label for="username">Username:</label><br> <input type="text"
				id="username" name="username" required><br> <label
				for="password">Password:</label><br> <input type="password"
				id="password" name="password" required><br> <input
				type="submit" value="Login">
		</form>
	</div>
</body>
</html>