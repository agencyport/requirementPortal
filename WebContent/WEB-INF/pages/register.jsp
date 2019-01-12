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
			    <label id="register" >Register</label>
			  </li>			  
			  			  
			</ul>
	  	</div>
	  	<div id="main-content">
		 	<form:form id="form1" name="form1" modelAttribute="employee" method="post" action="register">
		<table width="200" border="0" align="center">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><fieldset>
						<legend>Register</legend>
						<table width="609" border="0" align="center">

							<tr>
								<td width="69">&nbsp;</td>
								<td colspan="2">Username</td>
								<td colspan="3"><label> <form:input type="text"
											name="txt_username" id="txt_username" path="username" />
								</label></td>
								<td width="56">&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td colspan="2">Password</td>
								<td colspan="3"><form:input type="password"
										name="txt_password" id="txt_password" path="password" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td colspan="2">Name</td>
								<td colspan="3"><form:input type="text" name="txt_name"
										id="txt_name" path="name" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td colspan="2">Email</td>
								<td colspan="3"><form:input type="text" name="txt_email"
										id="txt_email" path="email" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td colspan="2">User Permission</td>
								<td colspan="3">								 
								<form:radiobutton path="permission" value="Read" label ="Read" /> 
								<form:radiobutton	path="permission" value="Read/Write" label ="Read/Write"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td width="60">&nbsp;</td>
								<td width="68"><input type="submit" name="btn_submit"
									id="btn_submit" value="Submit" /></td>
								<td width="164"><a href="login">Click here to login >>></a></td>
								<td>&nbsp;</td>
							</tr>

						</table>

					</fieldset></td>
			</tr>
		</table>

	</form:form>
	  	</div>
	  </div>
	</div>
</body>
</html>