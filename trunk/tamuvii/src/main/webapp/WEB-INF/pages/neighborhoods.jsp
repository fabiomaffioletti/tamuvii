<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="neighborhoods.title"/></title>
    <meta name="heading" content="<fmt:message key='neighborhoods.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<display:table name="neighborhoods" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="neighborhood" pagesize="25" class="table" export="false">
    <display:column property="id" escapeXml="true" sortable="true" titleKey="id" />
	<display:column escapeXml="false" sortable="false" titleKey="immagine">
		<img src="${neighborhood.imageLink}" height="20px" width="20px;"/>
	</display:column>
    <display:column escapeXml="false" sortable="true" titleKey="username">
    	<a href="/shelf.html?username=${neighborhood.username}">${neighborhood.username}</a> 
    </display:column>
</display:table>