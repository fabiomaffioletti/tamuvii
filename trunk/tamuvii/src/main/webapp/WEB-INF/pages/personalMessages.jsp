<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="messages.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div id="sx">
	<display:table name="groupedMessages" cellspacing="0" cellpadding="0" defaultsort="1" id="groupedMessage" class="table" export="false">
	    <display:column escapeXml="false" sortable="true" titleKey="u">
			<a href="/shelf.html?username=${groupedMessage.user.username}">${groupedMessage.user.username}</a>
		</display:column>
	    <display:column escapeXml="false" sortable="false" titleKey="i">
			<img src="${groupedMessage.user.imageLink}" height="20px" width="20px;"/>
		</display:column>
	    <display:column property="numMessages" escapeXml="true" sortable="true" titleKey="n"/>
	    <display:column escapeXml="false" sortable="false" titleKey="a">
			<a href="/personalMessages.html?username=${groupedMessage.user.username}">Apri</a>
		</display:column>
	</display:table>
</div>

<div id="cont">

<c:if test="${conversation}">
	<a href="#" onclick="Effect.toggle('sendMessage', 'slide',{ duration: 0.2 }); return false;">Rispondi</a>
	<div id="sendMessage" style="width:180px;display:none;">
		<form:form name="sendMessageForm" action="/sendMessage.html?returnView=personalMessages" method="POST">
			<textarea id="messagetext" name="messagetext" cols="20" rows="5"></textarea>
			<input type="hidden" id="receiver" name="receiver" value="${username}" />
			<input type="submit" name="sendMessage" value="Spedisci" />
			<a href="#" onclick="Effect.toggle('sendMessage', 'slide',{ duration: 0.2 }); return false;">Annulla</a>
		</form:form>
	</div>
	<br/>
	<br/>
</c:if>

<display:table name="allMessages" cellspacing="0" cellpadding="0" id="myMessage" pagesize="25" class="table" export="false">
    <display:column property="message.message" escapeXml="true" sortable="true" titleKey="id"/>
    <display:column property="message.messagetext" escapeXml="true" sortable="true" titleKey="testo"/>
    <display:column property="message.dateadded" escapeXml="true" sortable="true" titleKey="data"/>
    <display:column escapeXml="false" sortable="true" titleKey="username">
		<a href="/shelf.html?username=${myMessage.user.username}">${myMessage.user.username}</a>
	</display:column>
    <display:column escapeXml="false" sortable="false" titleKey="immagine">
		<img src="${myMessage.user.imageLink}" height="20px" width="20px;"/>
	</display:column>
	<c:if test="${!conversation}">	
		<display:column escapeXml="false" sortable="false" titleKey="actions">
			<a href="/personalMessages.html?username=${myMessage.user.username}">Apri</a>
		</display:column>
	</c:if>
</display:table>

</div>