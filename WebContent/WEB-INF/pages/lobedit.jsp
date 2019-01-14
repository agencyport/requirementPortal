<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requirement Pack</title>
<link href="css/bootstrap.css" rel="stylesheet">
<style type="text/css">
.header {
	background: darkblue;
}

.myid {
	width: 30px;
}

.category {
	width: 80px;
}

.coverage {
	width: 220px;
}

.desc {
	width: 700px;
}

.navbar-brand {
	color: white;
}

.options {
	background: gainsboro;
	margin: 0;
	text-align: right;
	padding: 0.5%;
}

.content-area {
	display: flex;
	padding: 1%;
	border-bottom: 1px solid silver;
}

.vertical-nav {
	width: 15%;
	border-right: 1px solid silver;
}

.nav-container {
	padding: 0;
}

ul {
	list-style-type: none;
}

#login {
	text-decoration: none;
	color: gray;
	border-bottom: 1px solid silver;
	width: 100%;
	display: block;
}

.item {
	padding: 2%;
	width: 80%;
}

.item.active {
	background: deepSkyBlue;
}

.logo {
	margin-left: 1%;
	width: 7%;
	height: 7%;
	background: white;
}

#main-content {
	padding: 0 1%;
}

#login {
	margin-bottom: 0;
}

.login-table {
	margin-top: 5%;
}
</style>
</head>

<body>

	<div class="box">
		<div class="header">
			<img alt="image" class="logo"
				src="<%=request.getContextPath()%>/resources/images/Accenture-red-arrow-logo.png"></img>
			<center>
				<label class="navbar-brand">Welcome To Duck creek
					Requirement Pack!</label>
			</center>
		</div>
		<div class="options"></div>

		<div class="content-area">
			<div class="vertical-nav">
				<ul class="nav-container">

					<li class="item active"><label id="LOB">Edit Lob</label></li>

				</ul>
			</div>
			<div id="main-content">
			<form action="lobMenu" method="post">
				<input type="submit" value="back" />
				</form>
				<form action="update" method="post">
					<c:if test="${dynDisplayColumnBean != null}">
						<table width="200" border="0" align="center">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<input type="text" name="displayId" id="displayId"
									value="${dynDisplayColumnBean.displayId}" class="myid" readonly />
								<input type="text" name="category" id="category"
									value="${dynDisplayColumnBean.displayData[0]}" class="category" />
								<input type="text" name="coverage" id="coverage"
									value="${dynDisplayColumnBean.displayData[1]}" class="coverage" />
								<input type="text" name="desc" id="desc"
									value="${dynDisplayColumnBean.displayData[2]}" class="desc" />
								<input type="text" name="lobId" id="lobId"
									value="${dynDisplayColumnBean.lobId}" class="myid" readonly />
							</tr>
						</table>
						<input type="submit" value="update" />
					</c:if>					
					<c:if test="${empty dynDisplayColumnBean}">
					 <span style="font-size:small;color:red"><b><p>Please select any records to update</p></b></span>
                    </c:if>
				</form>
				
</body>
</html>