<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.unibl.etf.ip.dtos.Log"%>
<%@page import="org.unibl.etf.ip.beans.StatsBean"%>

<jsp:useBean id="statsBean" type="org.unibl.etf.ip.beans.StatsBean"
	scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<style>
.border {
	border: solid black 1px;
	border-collapse: collapse;
}
</style>
<meta charset="UTF-8">
<title>Stats view</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<br>
	<h1>Stats View</h1>
	
	<br>
	<table class="border">
		<thead>
			<tr>
				<th class="border">Level</th>
				<th class="border">Message</th>
				<th class="border">Date</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Log log : statsBean.getLogs()) {
				out.println("<tr>");
				out.println("<td class=\"border\">" + log.getLevel());
				out.println("<td class=\"border\">" + log.getMessage());
				out.println("<td class=\"border\">" + log.getTimestamp());
				out.println("</tr>");
			}
			%>
		</tbody>
	</table>
</body>
</html>