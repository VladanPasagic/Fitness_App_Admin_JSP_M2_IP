<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.unibl.etf.ip.dtos.User"%>
<%@page import="org.unibl.etf.ip.beans.UsersBean"%>

<jsp:useBean id="usersBean" type="org.unibl.etf.ip.beans.UsersBean"
	scope="session"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.border {
	border: solid black 1px;
	border-collapse: collapse;
}
</style>
<title>Users view</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<br>
	<h1>Users View</h1>
	<br>
	<table class="border">
		<thead>
			<tr>
				<th class="border">Entity Type</th>
				<th class="border">First Name</th>
				<th class="border">Last Name</th>
				<th class="border">Username</th>
				<th class="border">City</th>
				<th class="border">E-mail</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (User user : usersBean.getUsers()) {
				out.println("<tr>");
				out.println("<td class=\"border\">" + user.getDtype() + "</td>");
				out.println("<td class=\"border\">" + user.getFirstName() + "</td>");
				out.println("<td class=\"border\">" + user.getLastName() + "</td>");
				out.println("<td class=\"border\">" + user.getUsername() + "</td>");
				out.println("<td class=\"border\">" + user.getCity() + "</td>");
				out.println("<td class=\"border\">" + user.getMail() + "</td>");
				out.println("</tr>");
			}
			%>
		</tbody>
	</table>
</body>
</html>