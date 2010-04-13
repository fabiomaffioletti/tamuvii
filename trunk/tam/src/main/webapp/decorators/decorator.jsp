<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/common/meta.jsp" %>
	<title>Tam | <decorator:title /></title>
	<link rel="icon" href="/images/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="/css/nav-horizontal.css" />
	<link rel="stylesheet" type="text/css" href="/css/decorator.css" />
	<link rel="stylesheet" type="text/css" href="/css/displaytag.css" />
	<link rel="stylesheet" type="text/css" href="/css/userForm.css" />
	<script type="text/javascript" src="<c:url value='/js/jquery-1.4.min.js'/>"></script> 
	<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
	<decorator:head />
</head>

<body <decorator:getProperty property="body.id" writeEntireProperty="true"/> <decorator:getProperty property="body.class" writeEntireProperty="true"/>>

	<div id="wrapper">
		<div id="header">
			<h1>Tam</h1>
		</div>
		<div id="navigation">
			<div class="wrapper">
				<c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
				<menu:useMenuDisplayer name="Velocity" config="decoratorMenu.vm" permissions="rolesAdapter">
					<ul id="primary-nav" class="menuList">
						<menu:displayMenu name="HomeMenu"/>
					    <menu:displayMenu name="AdminMenu"/>
					    <menu:displayMenu name="UserMenu"/>
					    <menu:displayMenu name="Logout"/>
					</ul>
				</menu:useMenuDisplayer>
			</div>
		</div>
		<div id="content">
			<table style="border-collapse: collapse; width: 100%;">
				<tr>
					<td>
						<decorator:body/>
					</td>
				</tr>
			</table>
		</div>
		<div id="footer">Tam - 22/12/2009</div>
	</div>

</body>
</html>