<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://displaytag.sf.net" prefix="display" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requirement Portal!</title>
<link href="<c:url value="/resources/css/displayTable.css" />" rel="stylesheet"  type="text/css" /> 
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

.button {
  background-color: deepSkyBlue; 
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
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
	width: 17%;
	height: 17%;
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

<style  type="text/css">
table {
	border: 1px solid #666;
	width: 80%;
	margin: 20px 0 20px 0 !important;
}
th,td {
	padding: 2px 4px 2px 4px !important;
	text-align: left;
	vertical-align: top;
}
thead tr {
	background-color: #999999;
}
th.sorted {
	background-color: #CCCCCC;
}
th a,th a:visited {
	color: black;
}
th a:hover {
	text-decoration: underline;
	color: black;
}
th.sorted a,th.sortable a {
	background-position: right;
	display: block;
	width: 100%;
}
tr.odd {
	background-color: #fff
}

tr.tableRowEven,tr.even {
	background-color: #CCCCCC
}
.group-1 {
    font-weight:bold;
    padding-bottom:10px;
    border-top:1px solid black;
}
.group-2 {
    font-style:italic;
    border-top: 1px solid black;

}
.grouped-table tr.even {
    background-color: #fff;
}
.grouped-table tr.odd {
    background-color: #fff;
}
</style>
</head>
<body>
<!-- <div class="tab">
  <button class="tablinks" onclick="openLob(event, 'FeatureList')" id="defaultOpen">Feature List</button>
  <button class="tablinks" onclick="openLob(event, 'Domain')">Domain</button>
  <button class="tablinks" onclick="openLob(event, 'BPFs')">BPFs</button>
</div> -->
<div class="box">
	  <div class="header">
	  	<img class="logo" src="images/Accenture-red-arrow-logo.png"></img>
      	<label class="navbar-brand">Welcome To Duck creek Requirement Pack!</label>
	  </div>
	  <div class="options">
	  </div>

	  <div class="content-area">
	  	<div class="vertical-nav">
			  <ul class="nav-container">
			  
			  <li class="item active">
			    <button class="button" onclick="openLob(event, 'FeatureList')" id="defaultOpen" ><label class="navbar-brand">Feature List</label></button><br /><br />
				<button class="button" onclick="openLob(event, 'Domain')"><label class="navbar-brand">Domain</label></button><br /><br />
				<button class="button" onclick="openLob(event, 'BPFs')"><label class="navbar-brand">BPFs</label></button>
			  </li>		  
			  			  
			</ul>
	  	</div>
 	  	
<div id="FeatureList" class="tabcontent">
<fieldset>
<legend>Upload the File</legend>
  <form method="POST" action="uploadFile" enctype="multipart/form-data">
		File to upload: <input type="file" name="file">
		<input type="submit" value="Upload"> 
	</form>	 
</fieldset>
	<!--Contents here -->
  
  <c:if test="${excelDataDetails != null}">  
    <display:table name="excelDataDetails" id="excelData" class="table" pagesize="25"
    cellpadding="4" cellspacing="0" style="width:100%" defaultsort="1" defaultorder="ascending" sort="list"
    requestURI="">
    <display:column title="DataId" property="displayId" headerClass="topic" sortable="true" />
    <c:forEach items="${excelData.displayData}" var="innerList" varStatus="index">    	 
  		 <display:column title="Column[${index.index}]" property="displayData[${index.index}]"  headerClass="topic" sortable="true"/>   		    		   
	</c:forEach>
	<display:column title="LobId" property="lobId"  headerClass="topic" sortable="true" />    
   </display:table>
  </c:if>
   <c:if test="${emptyList!=null}"> 
    <table width="99%" align="center" border="1" cellspacing="0" bordercolor="#6c7fa6" 
     style="border-collapse: collapse" class = "table">
     <tr class="topic">
     <th width="15%">
       DataId</th>
     <th width="15%">
       Column</th>
     <th width="15%">
       lobId</th>     
     </tr>     
     <tr class="content_even">
     <td align="center" colspan="4">
      <c:out value="${emptyList}"/>
     </td>  
     </tr>      
    </table>
  </c:if>
<!-- Content ends here -->
</div>
<div id="Domain" class="tabcontent">
  <h3>Domain</h3>  
</div>
<div id="BPFs" class="tabcontent">
  <h3>BPFs</h3>  
</div>
</div>
</div>
<script>
function openLob(evt,lobNm) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(lobNm).style.display = "block";
  evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
</body>
</html>