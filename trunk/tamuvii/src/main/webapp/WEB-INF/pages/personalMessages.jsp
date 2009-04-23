<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="messages.title"/></title>
    <meta name="heading" content="<fmt:message key='messages.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

Questi gli utenti con cui hai scambiato messaggi

<display:table name="groupedMessages" cellspacing="0" cellpadding="0" defaultsort="1" id="groupedMessage" pagesize="25" class="table" export="false">
    <display:column property="user.username" escapeXml="true" sortable="true" titleKey="utente"/>
    <display:column escapeXml="false" sortable="false" titleKey="immagine">
		<img src="${groupedMessage.user.imageLink}" height="20px" width="20px;"/>
	</display:column>
    <display:column property="numMessages" escapeXml="true" sortable="true" titleKey="numMessages"/>
</display:table>

Ultimi messaggi recevuti:

<display:table name="groupedMessages" cellspacing="0" cellpadding="0" defaultsort="1" id="myMessage" pagesize="25" class="table" export="false">
    <display:column property="message.message" escapeXml="true" sortable="true" titleKey="id"/>
    <display:column property="message.messagetext" escapeXml="true" sortable="true" titleKey="testo"/>
    <display:column property="message.dateadded" escapeXml="true" sortable="true" titleKey="data"/>
    <display:column property="user.username" escapeXml="true" sortable="true" titleKey="utente"/>
    <display:column escapeXml="false" sortable="false" titleKey="immagine">
		<img src="${myMessage.user.imageLink}" height="20px" width="20px;"/>
	</display:column>
    <display:column property="numMessages" escapeXml="true" sortable="true" titleKey="numMessages"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("groupedMessage");
</script>