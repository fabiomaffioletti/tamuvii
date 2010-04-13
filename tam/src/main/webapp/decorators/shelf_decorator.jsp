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
	<script type="text/javascript" src="<c:url value='/js/jquery.url.packed.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/ajaxupload.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
	
	<link rel="stylesheet" type="text/css" href="/JSCal2/css/jscal2.css" />
    <link rel="stylesheet" type="text/css" href="/JSCal2/css/border-radius.css" />
    <link rel="stylesheet" type="text/css" href="/JSCal2/css/win2k/win2k.css" />
    <script type="text/javascript" src="/JSCal2/js/jscal2.js"></script>
    <script type="text/javascript" src="/JSCal2/js/lang/it.js"></script>
	
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
				<security:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN">
					<ul>
						<li><a href="/login.jsp">Entra</a></li>
					</ul>
				</security:authorize>
				<security:authorize ifAnyGranted="ROLE_ADMIN">
					<ul>
						<li><a href="/users.html">Utenti</a></li>
						<li><a href="/communication.html">Invia comunicazione</a></li>
						<li><a href="/movies.html">Film</a></li>
						<li><a href="/movieForm.html?method=add">Nuovo film</a></li>
						<li><a href="/logout.jsp">Esci</a></li>
					</ul>
				</security:authorize>
				<security:authorize ifAnyGranted="ROLE_USER">
					<ul>
						<li><a href="/home.html">Home</a></li>
						<li><a href="/${pageContext.request.remoteUser}/movies/">${pageContext.request.remoteUser}</a></li>
						<li><a href="/${pageContext.request.remoteUser}/contacts/">Contatti</a></li>
						<li><a href="/profile.html">Profilo</a></li>
						<li><a href="/logout.jsp">Esci</a></li>
					</ul>
				</security:authorize>
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