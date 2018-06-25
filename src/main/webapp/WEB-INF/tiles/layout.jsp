<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>string</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sidebar.css">
</head>
<body>
	<table class="layout">
		<tr>
			<th colspan="2" class="layoutHeader"><header>
					<tiles:insertAttribute name="header" />
				</header></th>
		</tr>
		<tr>
			<th class="layoutSideBar"><sidebar> <tiles:insertAttribute
					name="sidebar" /></sidebar></th>

			<th class="layoutContent"><content> <tiles:insertAttribute
					name="content" /> </content></th>
		</tr>
	</table>
	<footer class="layoutFooter">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>

