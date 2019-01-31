<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requirement Portal!</title>
<link href="<c:url value="/resources/css/displayTable.css" />"
	rel="stylesheet" type="text/css" />
<style type="text/css">
.header {
	background: darkblue;
}

.navbar-brand {
	color: black;
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
.box {
background:#e6f0ff;
}
.horizontal-nav {
background:#f1f1f1;
}

.vertical-nav {
	width: 12%;
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

.button {
	background-color: #e6f0ff;
	border: 2px solid #ccc;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 2px 2px;
	cursor: pointer;
}

.item {
	padding: 2%;
	width: 80%;
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

.tabcontent {
     background:#f1f1f1;
	float: left;
	padding: 1px 1px;
	border: 1px solid #ccc;
	width: 100%;
	border-left: none;
	height: 1600px;
}
/* Style the tab */
.tab1 {
  overflow: hidden;  
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab1 button {
  background-color: inherit;
  float: left;
  border: 1px solid #ccc;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab1 button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab1 button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent1 {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>

<style type="text/css">
table {
	border: 1px solid #666;
	width: 80%;
	margin: 20px 0 20px 0 !important;
}

th, td {
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

th a, th a:visited {
	color: black;
}

th a:hover {
	text-decoration: underline;
	color: black;
}

th.sorted a, th.sortable a {
	background-position: right;
	display: block;
	width: 100%;
}

tr.odd {
	background-color: #fff
}

tr.tableRowEven, tr.even {
	background-color: #CCCCCC
}

.group-1 {
	font-weight: bold;
	padding-bottom: 10px;
	border-top: 1px solid black;
}

.group-2 {
	font-style: italic;
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

	<div class="box">
		<div class="header">
			<img alt="image" class="logo" src="<%=request.getContextPath()%>/resources/images/Accenture-red-arrow-logo.png"></img>
			<center>
				<label class="navbar-brand">Welcome To Duck creek
					Requirement Pack!</label>
			</center>
		</div>
		<div class="options"></div>

		<div class="content-area">
			<div class="vertical-nav">
				<ul class="nav-container">

					<li class="item active">
						<button class="button" onclick="openLob(event, 'FeatureList')"
							id="defaultOpen">
							<label class="navbar-brand">Feature List</label>
						</button>
						<br />
					<br />
						<button class="button" onclick="openLob(event, 'Domain')">
							<label class="navbar-brand">Domain</label>
						</button>
						<br />
					<br />
						<button class="button" onclick="openLob(event, 'BPFs')">
							<label class="navbar-brand">BPFs</label>
						</button>
					</li>

				</ul>
			</div>		
			<div id="FeatureList" class="tabcontent">
			<fieldset>
					<legend>Upload the File</legend>
					<form method="POST" action="uploadFile"
						enctype="multipart/form-data">
						<input type="hidden" name="lobId" value="${lobId}"/>
						File to upload: <input type="file" name="file"> <input
							type="submit" value="Upload">
					</form>
				</fieldset></br>
				
			<div class="tab1">
	
	 <button class="button tablinks1" onclick="openFeatureList(event, 'RuleDetails')" id="defaultOpen1"><label class="navbar-brand">Rule Details</label></button>
  <button class="button tablinks1" onclick="openFeatureList(event, 'RevisionHistory')">	<label class="navbar-brand">Revision History</label></button>
  <button class="button tablinks1"  onclick="openFeatureList(event, 'CoverageDetails')">
							<label class="navbar-brand">Coverage Details</label></button>
	</div>					

			<div id="RuleDetails" class="tabcontent1">				
				<form method="POST" action="updateDelete">
					<c:if test="${ruleDetailsData != null}">
						<display:table name="ruleDetailsData" id="ruleDetails"
							class="table" pagesize="25" cellpadding="4" cellspacing="0"
							style="width:100%" defaultsort="1" defaultorder="ascending"
							sort="list" requestURI="">
							<display:column title="DataId" property="displayId"
								headerClass="topic" sortable="true" />
							<c:forEach items="${ruleDetails.displayData}" var="innerList"
								varStatus="index">
								<display:column title="${ruleDetails.title[index.index]}"
									property="displayData[${index.index}]" headerClass="topic"
									sortable="true" />
							</c:forEach>
							<display:column title="LobId" property="lobId"
								headerClass="topic" sortable="true" />
							<display:column title="Delete">
								<input type="checkbox" name="checkboxdelete"
									value="${ruleDetails.displayId}" />
							</display:column>
							<display:column title="Edit">
								<input type="radio" name="checkboxedit"
									value="${ruleDetails.displayId}" />
							</display:column>
						</display:table>
					</c:if>
					<c:if test="${emptyList!=null}">
						<table width="99%" align="center" border="1" cellspacing="0"
							bordercolor="#6c7fa6" style="border-collapse: collapse"
							class="table">
							<tr class="topic">
								<th width="15%">DataId</th>
								<th width="15%">Column</th>
								<th width="15%">lobId</th>
							</tr>
							<tr class="content_even">
								<td align="center" colspan="4"><c:out value="${emptyList}" />
								</td>
							</tr>
						</table>
					</c:if>
					<!-- Content ends here -->
					<input type="submit" name="update" value="Edit"> <input
						type="submit" name="delete" value="Delete">
				</form>
				<form method="POST" action="viewPDF">
					<div align="right">
						<input type="submit" value="Export to PDF">
					</div>
				</form>
			</div>
			<div id="RevisionHistory" class="tabcontent1">
				<form method="POST" action="updateDelete">
					<c:if test="${revisionHistoryData != null}">
						<display:table name="revisionHistoryData" id="revisionHistory"
							class="table" pagesize="25" cellpadding="4" cellspacing="0"
							style="width:100%" defaultsort="1" defaultorder="ascending"
							sort="list" requestURI="">
							<display:column title="DataId" property="displayId"
								headerClass="topic" sortable="true" />
							<c:forEach items="${revisionHistory.displayData}" var="innerList"
								varStatus="index">
								<display:column title="${revisionHistory.title[index.index]}"
									property="displayData[${index.index}]" headerClass="topic"
									sortable="true" />
							</c:forEach>
							<display:column title="LobId" property="lobId"
								headerClass="topic" sortable="true" />
							<display:column title="Delete">
								<input type="checkbox" name="checkboxdelete"
									value="${revisionHistory.displayId}" />
							</display:column>
							<display:column title="Edit">
								<input type="radio" name="checkboxedit"
									value="${revisionHistory.displayId}" />
							</display:column>
						</display:table>
					</c:if>
					<c:if test="${emptyList!=null}">
						<table width="99%" align="center" border="1" cellspacing="0"
							bordercolor="#6c7fa6" style="border-collapse: collapse"
							class="table">
							<tr class="topic">
								<th width="15%">DataId</th>
								<th width="15%">Column</th>
								<th width="15%">lobId</th>
							</tr>
							<tr class="content_even">
								<td align="center" colspan="4"><c:out value="${emptyList}" />
								</td>
							</tr>
						</table>
					</c:if>
					<!-- Content ends here -->
					<input type="submit" name="update" value="Edit"> <input
						type="submit" name="delete" value="Delete">
				</form>
				<form method="POST" action="viewPDF">
					<div align="right">
						<input type="submit" value="Export to PDF">
					</div>
				</form>				
			</div>
			<div id="CoverageDetails" class="tabcontent1">
				<form method="POST" action="updateDelete">
					<c:if test="${featureListingData != null}">
						<display:table name="featureListingData" id="featureListing"
							class="table" pagesize="25" cellpadding="4" cellspacing="0"
							style="width:100%" defaultsort="1" defaultorder="ascending"
							sort="list" requestURI="">
							<display:column title="DataId" property="displayId"
								headerClass="topic" sortable="true" />
							<c:forEach items="${featureListing.displayData}" var="innerList"
								varStatus="index">
								<display:column title="${featureListing.title[index.index]}"
									property="displayData[${index.index}]" headerClass="topic"
									sortable="true" />
							</c:forEach>
							<display:column title="LobId" property="lobId"
								headerClass="topic" sortable="true" />
							<display:column title="Delete">
								<input type="checkbox" name="checkboxdelete"
									value="${featureListing.displayId}" />
							</display:column>
							<display:column title="Edit">
								<input type="radio" name="checkboxedit"
									value="${featureListing.displayId}" />
							</display:column>
						</display:table>
					</c:if>
					<c:if test="${emptyList!=null}">
						<table width="99%" align="center" border="1" cellspacing="0"
							bordercolor="#6c7fa6" style="border-collapse: collapse"
							class="table">
							<tr class="topic">
								<th width="5%">DataId</th>
								<th width="5%">Column</th>
								<th width="5%">lobId</th>
							</tr>
							<tr class="content_even">
								<td align="center" colspan="4"><c:out value="${emptyList}" />
								</td>
							</tr>
						</table>
					</c:if>
					<!-- Content ends here -->
					<input type="submit" name="update" value="Edit"> <input
						type="submit" name="delete" value="Delete">
				</form>
				<form method="POST" action="viewPDF">
					<div align="right">
						<input type="submit" value="Export to PDF">
					</div>
				</form>
			</div>	
			</div>
			<div id="Domain" class="tabcontent">
				<h3>Domain</h3>
				<img alt="image" class="logo" src="<%=request.getContextPath()%>/resources/images/domain.png"></img>
				<form method="POST" action="viewImagePDF">
					<input type="submit" value="Export to PDF">
				</form>
			</div>
			<div id="BPFs" class="tabcontent">
				<h3>BPFs</h3>
				 <iframe src="<%=request.getContextPath()%>/resources/file/3_Workers Comp.vsdx" height="700" width="1000"></iframe>  
				<form method="POST" action="viewImagePDF">
					<input type="submit" value="Export to PDF">
				</form>
			</div>
		</div>
	</div>
	<script>
		function openLob(evt, lobNm) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(lobNm).style.display = "block";
			evt.currentTarget.className += " active";
		}
		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
		function openFeatureList(evt, lobNm1) {
			var i, tabcontent1, tablinks1;
			tabcontent1 = document.getElementsByClassName("tabcontent1");
			for (i = 0; i < tabcontent1.length; i++) {
				tabcontent1[i].style.display = "none";
			}
			tablinks1 = document.getElementsByClassName("tablinks1");
			for (i = 0; i < tablinks1.length; i++) {
				tablinks1[i].className = tablinks1[i].className.replace(
						" active", "");
			}
			document.getElementById(lobNm1).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen1").click();
	</script>
</body>
</html>