<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="users.title" /></title>
	<meta name="menu" content="AdminMenu"/>
</head>

<h2><fmt:message key="users.title" /></h2>

<%@ include file="/common/messages.jsp"%>

<form name="search_users" action="/users.html" method="get">
	Cerca: <input type="text" name="filter" />
	<input type="submit" value="Cerca" />
</form>

<display:table name="userList" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" class="table" id="u" pagesize="10" export="true">
	 <display:column property="id" escapeXml="true" sortable="true" titleKey="user.id" />
	 <display:column property="username" escapeXml="true" sortable="true" titleKey="user.username" url="/userForm.html?from=list" paramId="id" paramProperty="id"/>
	 <display:column property="firstName" escapeXml="true" sortable="true" titleKey="user.firstName" />
	 <display:column property="lastName" escapeXml="true" sortable="true" titleKey="user.lastName" />
	 <display:column property="email" escapeXml="true" sortable="true" titleKey="user.email" />
	 
	 <display:column escapeXml="false" sortable="true" titleKey="user.enabled" media="html">
	 	<input type="checkbox" disabled="disabled" <c:if test="${u.enabled}">checked="checked"</c:if>/>
	 </display:column>
	 <display:column escapeXml="false" sortable="true" titleKey="user.can.invite" media="html">
	 	<input type="checkbox" disabled="disabled" <c:if test="${u.canInvite}">checked="checked"</c:if>/>
	 </display:column>
	 <display:column property="enabled" escapeXml="false" sortable="true" titleKey="user.enabled" media="excel pdf" />
	 
	 <display:setProperty name="export.excel.filename" value="users.xls" />
	 <display:setProperty name="export.pdf.filename" value="users.pdf" />
</display:table>