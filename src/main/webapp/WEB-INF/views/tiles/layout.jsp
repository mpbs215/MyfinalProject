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
			<header>
				<th colspan="2" class="layoutHeader"><tiles:insertAttribute
						name="header" /></th>
			</header>
		</tr>
		<tr>
			<sidebar>
			<th class="layoutSideBar"><tiles:insertAttribute name="sidebar" /></th>
			</sidebar>
			<content>
			<th class="layoutContent"><tiles:insertAttribute name="content" /></th>
			</content>
		</tr>

	</table>
	<footer class="layoutFooter">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>

