<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="Messaggi"/></title>
    <script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/MessageManager.js"> </script>
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
									<span class="numMessages"><a href="/personalMessages.html?username=${groupedMessage.user.username}">${groupedMessage.numMessages} messaggi</a></span>
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
		<c:if test="${conversation}">
			<div id="message_reply_conversation" class="message_reply_textarea" style="display:none;">
				<textarea id="message_textarea_conversation"></textarea>
				<a href="#" onclick="hideElement('message_reply_conversation'); displayElement('reply_conversation_link'); return false;" style="float:left;">Annulla</a>
				<input type="button" value="Spedisci" onclick="sendConversationMessage()" />
			</div>
			<div id="reply_conversation_link" style="display:block;">
				<a href="#" onclick="displayElement('message_reply_conversation'); hideElement('reply_conversation_link'); return false;">Invia una risposta</a>
			</div>
		</c:if>
		<ul id="personal_messages_list">
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
						<c:if test="${!conversation}">
							<div style="clear:both; float:right;">
								<a href="#" id="viewOptionsLink_${message.message.message}" onclick="viewOptions('${message.message.message}', this.id)" style="font-size: 11px;">Vedi opzioni</a>
							</div>
							<div id="options_${message.message.message}" style="border: 1px dotted #ccc; clear:both; padding: 10px; display:none;">
								<c:choose>
									<c:when test="${message.user.username == pageContext.request.remoteUser}">
										<a href="/personalMessages.html?username=${message.receiver.username}">Apri conversazione</a>									
									</c:when>
									<c:otherwise>
										<a href="/personalMessages.html?username=${message.user.username}">Apri conversazione</a>
									</c:otherwise>
								</c:choose>
								<br/>
								<span class="light_text_italic">oppure</span>
								<br/>
								<a href="#" onclick="displayElement('message_reply_${message.message.message}'); return false;">Rispondi</a>
							</div>
						</c:if>
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
		$(link).innerHTML = "Vedi opzioni";
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


<script>
	function sendConversationMessage() {
		var sender = "${pageContext.request.remoteUser}";
		var receiver = "${username}";
		var messagetext = $('message_textarea_conversation').value;
		MessageManager.sendPersonalMessageDWR(sender, receiver, messagetext, function(str){
			if(str == true) {
				$('message_textarea_conversation').value = "<fmt:message key='tamuvii.message.success'/>" + receiver;
				new Effect.Highlight('message_textarea_conversation', {startcolor: '#4F8CC9',	restorecolor: true, afterFinish: function(e) {
					var li = Builder.node('li');
					var fromto = Builder.node('div', { className: 'fromto' });
					fromto.innerHTML = "<div class=\"person_list_info_container\"><div class=\"container\"><img src=\"${message.user.imageLink}\" width=\"30\" height=\"30\" class=\"major\" /><img class=\"minor\" src=\"/images/frame_30.png\"></div><div class=\"person_list_info\">da<br/><b>"+sender+"</b></div></div>";
					li.insert(fromto);
					$('personal_messages_list').insert({"top":li });					
					setTimeout("endSendingMessage()", 3000);
				}});
			} else {
				$('message_textarea_conversation').value = "<fmt:message key='tamuvii.message.error'/>";
				new Effect.Highlight('message_textarea_conversation', {startcolor: '#FFB98C',	restorecolor: true});
			}
		});
	}
</script>