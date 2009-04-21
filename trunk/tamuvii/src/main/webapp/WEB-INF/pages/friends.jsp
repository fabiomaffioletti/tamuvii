<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="friends.title"/></title>
    <meta name="heading" content="<fmt:message key='friends.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<display:table name="friends" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="friend" pagesize="25" class="table" export="false">
	<display:column property="id" escapeXml="true" sortable="true" titleKey="id" />
	<display:column escapeXml="false" sortable="false" titleKey="immagine">
		<img src="${friend.imageLink}" height="20px" width="20px;"/>
	</display:column>
    <display:column escapeXml="false" sortable="true" titleKey="username">
    	<a href="/shelf.html?username=${friend.username}">${friend.username}</a> 
    </display:column>
</display:table>

<script type="text/javascript">
    highlightTableRows("friend");
</script>