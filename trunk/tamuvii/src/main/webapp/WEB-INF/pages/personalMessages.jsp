<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="messages.title"/></title>
    <meta name="heading" content="<fmt:message key='messages.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

Questi gli utenti con cui hai scambiato messaggi

<display:table name="groupedMessages" cellspacing="0" cellpadding="0" defaultsort="1" id="groupedMessage" pagesize="25" class="table" export="false">
    <display:column escapeXml="false" sortable="true" titleKey="username">
		<a href="/shelf.html?username=${groupedMessage.user.username}">${groupedMessage.user.username}</a>
	</display:column>
    <display:column escapeXml="false" sortable="false" titleKey="immagine">
		<img src="${groupedMessage.user.imageLink}" height="20px" width="20px;"/>
	</display:column>
    <display:column property="numMessages" escapeXml="true" sortable="true" titleKey="numMessages"/>
</display:table>

Ultimi messaggi scambiati:

<display:table name="allMessages" cellspacing="0" cellpadding="0" defaultsort="1" id="myMessage" pagesize="25" class="table" export="false">
    <display:column property="message.message" escapeXml="true" sortable="true" titleKey="id"/>
    <display:column property="message.messagetext" escapeXml="true" sortable="true" titleKey="testo"/>
    <display:column property="message.dateadded" escapeXml="true" sortable="true" titleKey="data"/>
    <display:column escapeXml="false" sortable="true" titleKey="username">
		<a href="/shelf.html?username=${myMessage.user.username}">${myMessage.user.username}</a>
	</display:column>
    <display:column escapeXml="false" sortable="false" titleKey="immagine">
		<img src="${myMessage.user.imageLink}" height="20px" width="20px;"/>
	</display:column>
	<display:column escapeXml="false" sortable="false" titleKey="actions">
		<a href="/personalMessages.html?username=${myMessage.user.username}">Apri</a>
	</display:column>
</display:table>

<script type="text/javascript">
    highlightTableRows("groupedMessage");
</script>

<script type="text/javascript">
    highlightTableRows("myMessage");
</script>