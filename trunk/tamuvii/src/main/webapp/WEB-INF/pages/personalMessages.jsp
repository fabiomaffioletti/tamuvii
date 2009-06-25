<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="messages.title"/></title>
</head>

<div id="sidebar">
	
	<div id="pal">
		<div class="relationship_title">
			<div style="float:left">Hai scambiato messaggi con: </div>
		</div>
		<div id="pal_list_container">	
			<div id="pal_list_content">
				<ul class="person_list">
					<c:forEach var="groupedMessage" items="${groupedMessages}">
						<li>
							<div class="person_list_info_container">
								<div class="container">
									<img src="${groupedMessage.user.imageLink}" width="30" height="30" class="major" />
									<img class="minor" src="/images/frame_30.png" alt="">
								</div>
								<div class="person_list_info">
									<span class="pal_user"><a href="/shelf.html?username=${groupedMessage.user.username}">${groupedMessage.user.username}</a></span>
									<br/>
									<span class="numMessages"><a href="">${groupedMessage.numMessages} messaggi</a></span>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="relationship_navigation" style="width:100%;">
			<a href="#" id="upFriends" style="display:none;float:left;" onclick="indexFriends = doup(indexFriends, 1, 'friends_list_content', $('friends_list_container').getHeight(), 'downFriends', 'upFriends'); return false;"><img class="relationship_navigation_image" src="bw.png"/></a>
			<a href="#" id="downFriends" style="float:right;display:none;" onclick="indexFriends = dodown(indexFriends, pagesFriends, 1, 'friends_list_content', $('friends_list_container').getHeight(), 'downFriends', 'upFriends'); return false;"><img class="relationship_navigation_image" src="ff.png"/></a>
		</div>
	</div>
</div>





<div id="main">
	<div id="messages_list_container" style="font-size: 12px;">
		<ul>
			<c:forEach var="message" items="${allMessages}">
				<li>
					<div id="message_reply_${message.message.message}" class="message_reply_textarea" style="display:none;">
						<textarea></textarea>
						<a href="#" onclick="hideElement('message_reply_${message.message.message}'); return false;" style="float:left;">Annulla</a>
						<input type="submit" value="Invia" />
					</div>
					<div class="fromto">
						<div class="person_list_info_container">
							<div class="container">
								<img src="${message.user.imageLink}" width="30" height="30" class="major" />
								<img class="minor" src="/images/frame_30.png" alt="">
							</div>
							<div class="person_list_info">
								da
								<br/>
								<b>${message.user.username}</b>
							</div>
						</div>
						<br/>
						<div class="person_list_info_container" style="clear:both;">
							<div class="container">
								<img src="${message.receiver.imageLink}" width="30" height="30" class="major" />
								<img class="minor" src="/images/frame_30.png" alt="">
							</div>
							<div class="person_list_info">
								a
								<br/>
								<b>${message.receiver.username}</b>
							</div>
						</div>
						<div style="clear:both; float:right;">
							<a href="#" id="viewOptionsLink_${message.message.message}" onclick="viewOptions('${message.message.message}', this.id)" style="font-size: 11px;">Opzioni</a>
						</div>
						<div id="options_${message.message.message}" style="border: 1px dotted #ccc; clear:both; padding: 10px; display:none;">
							<a href="">Apri conversazione</a>
							<br/>
							<span class="light_text_italic">oppure</span>
							<br/>
							<a href="#" onclick="displayElement('message_reply_${message.message.message}'); return false;">Rispondi</a>
						</div>
						<br/>
					</div>
					<div class="last_message_text">
						${message.message.messagetext}
					</div>
					<div class="messages_separator">
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>




<script>
	function viewOptions(id, link) {
		var id_to_display = 'options_' + id;
		$(id_to_display).appear({ duration: 0.2 });
		$(link).innerHTML = "Nascondi opzioni";
		$(link).writeAttribute('onclick', "hideOptions('"+id+"', '"+link+"')");
		return false;
	}
	function hideOptions(id, link) {
		var id_to_hide = 'options_' + id;
		$(id_to_hide).fade({ duration: 0.2 });
		$(link).innerHTML = "Opzioni";
		$(link).writeAttribute('onclick', "viewOptions('"+id+"', '"+link+"')");
		return false;
	}

	function displayElement(id) {
		$(id).appear({ duration: 0.2 });
		return false;
	}
	function hideElement(id) {
		$(id).fade({ duration: 0.2 });
		return false;
	}

</script>








<%--

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

--%>