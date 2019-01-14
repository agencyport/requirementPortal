<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Screen</title>
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
	  	<img class="logo" src="images/Accenture-red-arrow-logo.png"></img>
      		<center><label class="navbar-brand">Welcome To Duck creek Requirement Pack!</label></center>
	  </div>
	  <div class="options">
	  </div>
 
	  <div class="content-area">
	  	<div class="vertical-nav">
			  <ul class="nav-container">
			  
			  <li class="item active">
			    <a href="lob"><label class="navbar-brand">Line of Business Page</label></a><br /><br />
				<a href="login"><label class="navbar-brand">Logout</label></a><br/>
				<a href="test"><label class="navbar-brand">test</label></a>
			  </li>			  
			  			  
			</ul>
	  	</div>
	  	</div>
	  	</div>
</body>
</html>