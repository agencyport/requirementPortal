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
.header{
	background:darkblue;
}

.navbar-brand{
	color:white;
}

.options{
	background:gainsboro;
	margin: 0;
	text-align: right;
	padding: 0.5%;
}

.content-area{
	display: flex;
	padding: 1%;
	border-bottom: 1px solid silver;
}

.vertical-nav{
	width: 15%;
	border-right: 1px solid silver;
}

.nav-container{
	padding: 0;
}


ul {
  list-style-type: none;
}

#login {
	text-decoration: none;
	color: gray;
	border-bottom: 1px solid silver;
	width : 100%;
	display: block;
}

.item{
	padding : 2%;
	width : 80%;
}

.item.active{
	background: deepSkyBlue ;
}

.logo{
	margin-left: 1%;
	width: 7%;
	height: 7%;
	background: white;
}

#main-content{
	padding : 0 1%;
}

#login{
	margin-bottom: 0;
}

.login-table{
	margin-top : 5%;
}



</style>
</head>

<body>
	
	<div class="box">
	  <div class="header">
	  	<img alt="image" class="logo" src="<%=request.getContextPath()%>/resources/images/Accenture-red-arrow-logo.png"></img>
      	<center><label class="navbar-brand">Welcome To Duck creek Requirement Pack!</label></center>
	  </div>
	  <div class="options">
	  </div>
 
	  <div class="content-area">
	  	<div class="vertical-nav">
			  <ul class="nav-container">
			  
			  <li class="item active">
			    <label id="login" >Login</label>
			  </li>			  
			  			  
			</ul>
	  	</div>
	  	<div id="main-content">
		 	<form:form id="form1" name="form1" modelAttribute="employee" method="post" action="login">
			<div>
			<h2> Login to Application </h2>
			<span style="font-size:small;color:red"><% if ( request.getAttribute( "Messages" ) != null ) { %><%=request.getAttribute( "Messages" )%><% } %></span>
			<table class="login-table">
				<tr>
					<td><font face="verdana" size="2px">User Name:</font></td>
					<td><form:input type="text" name="txt_username" id="txt_username" path="username" /></td>
				</tr>
				<tr>
					<td><font face="verdana" size="2px">Password:</font></td>
					<td><form:input type="password" name="txt_password" id="txt_password" path="password" /><br/><br/></td>				
				</tr>
				
				<tr>
					<td><input id="submit" type="submit" value="Login" /></td>
				</tr>

			</table>
		</div>
	</form:form>
	  	</div>
	  </div>
	</div>
</body>
</html>