<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="org.unibl.etf.ip.dtos.Category"%>
<%@page import="org.unibl.etf.ip.dtos.SpecificAttribute"%>
<%@page import="org.unibl.etf.ip.beans.CategoriesBean"%>
<%@page import="org.unibl.etf.ip.beans.CategoryBean"%>

<jsp:useBean id="categoriesBean"
	type="org.unibl.etf.ip.beans.CategoriesBean" scope="session"></jsp:useBean>
<jsp:useBean id="categoryBean"
	type="org.unibl.etf.ip.beans.CategoryBean" scope="session"></jsp:useBean>

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
<title>Categories view</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>

	<h1>Categories View</h1>
	<form method="POST" action="?action=save">
		<!-- Category Name -->
		<label for="categoryName">Category Name:</label> <input type="text"
			id="categoryName" name="categoryName" required> <br> <br>

		<!-- Key-Value Parameters -->
		<div id="parameters">
			<div>
				<label for="key1">Attribute:</label> <input type="text" id="key1"
					name="key[]" required> <label for="value1">Value:</label> <input
					type="text" id="value1" name="value[]" required>
			</div>
		</div>

		<!-- Add Button -->
		<button type="button" onclick="addParameter()">Add Parameter</button>
		<br> <br>

		<!-- Save Button -->
		<input type="submit" name="submit" value="Save">
	</form>
	<script>
		// Function to add more parameters
		function addParameter() {
			var div = document.createElement('div');
			div.innerHTML = '<label for="key">Attribute:</label> <input type="text" name="key[]" required> <label for="value">Value:</label> <input type="text" name="value[]" required>';
			document.getElementById('parameters').appendChild(div);
		}
	</script>
	<br>
	<table>
		<thead>
			<tr>
				<th class="border">Name</th>
				<th class="border">View</th>
				<th class="border">Delete</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Category category : categoriesBean.getCategories()) {
				out.println("<tr>");
				out.println("<td class=\"border\">" + category.getName() + "</td>");
				out.println("<td class=\"border\"> <a href=\"?action=view&id=" + category.getId() + "\">View</a>");
				out.println("<td class=\"border\"> <a href=\"?action=delete&id=" + category.getId() + "\">Delete</a>");
				out.println("</tr>");
			}
			%>
		</tbody>
	</table>
	<br>
	<%
	if (categoryBean.getCategory() != null) {
		Category category = categoryBean.getCategory();
		out.println("<h1>" + category.getName() + "</h1>");
		for (SpecificAttribute specificAttribute : category.getSpecificAttributes()) {
			out.println("<p> Attribute: " + specificAttribute.getAttribute() + "<br>Value: " + specificAttribute.getValue()
			+ "</p><br>");
		}
		out.println("<a href=\"?action=close\">Close</a>");
	}
	%>
</body>
</html>