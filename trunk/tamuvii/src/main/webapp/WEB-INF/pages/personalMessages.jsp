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
			<a href="#" id="upPal" style="display:none;float:left;" onclick="indexPal = doup(indexPal, 1, 'pal_list_content', $('pal_list_container').getHeight(), 'downPal', 'upPal'); return false;"><img class="relationship_navigation_image" src="/images/bw.png"/></a>
			<a href="#" id="downPal" style="float:right;display:none;" onclick="indexPal = dodown(indexPal, pagesPal, 1, 'pal_list_content', $('pal_list_container').getHeight(), 'downPal', 'upPal'); return false;"><img class="relationship_navigation_image" src="/images/ff.png"/></a>
		</div>
	</div>
</div>





<div id="main">
	<div id="messages_list_container" style="font-size: 12px;">
		<c:if test="${conversation}">
			<div style="min-height: 100px; border-bottom: 1px solid #aaa;">
				<c:choose>
					<c:when test="${allMessages[0].user.username == pageContext.request.remoteUser}">
						<c:set var="sender_image" value="${allMessages[0].user.imageLink}"></c:set>
						<c:set var="receiver_image" value="${allMessages[0].receiver.imageLink}"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="sender_image" value="${allMessages[0].receiver.imageLink}"></c:set>
						<c:set var="receiver_image" value="${allMessages[0].user.imageLink}"></c:set>
					</c:otherwise>
				</c:choose>
				<div id="conversation_message_result" style="display:none;"></div>
				<div id="message_reply_conversation" class="message_reply_textarea" style="display:block;">
					<textarea id="message_textarea_conversation"></textarea>
					<a href="#" onclick="emptyTextarea('message_textarea_conversation'); return false;" style="float:left;">Cancella tutto il testo</a>
					<input type="button" value="Spedisci" onclick="sendConversationMessage('${sender_image}', '${receiver_image}')" />
				</div>
			</div>
		</c:if>
		<ul id="personal_messages_list">
			<c:forEach var="message" items="${allMessages}" varStatus="row">
				<li>
					<div id="message_reply_${message.message.message}" class="message_reply_textarea" style="display:none;">
						<form:form name="sendMessageForm" action="/sendMessage.html" method="post">
							<c:choose>
								<c:when test="${message.user.username == pageContext.request.remoteUser}">
									<c:set var="sender" value="${message.user.username}"></c:set>
									<c:set var="receiver" value="${message.receiver.username}"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="sender" value="${message.receiver.username}"></c:set>
									<c:set var="receiver" value="${message.user.username}"></c:set>
								</c:otherwise>
							</c:choose>
							<input type="hidden" name="receiver" value="${receiver}" />
							<textarea name="message_reply_text"></textarea>
							<a href="#" onclick="hideElement('message_reply_${message.message.message}'); return false;" style="float:left;">Annulla</a>
							<input type="submit" value="Invia" />
						</form:form>
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
	function emptyTextarea(id) {
		$(id).value = "";
	}

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
	function sendConversationMessage(sender_image, receiver_image) {
		var sender = "${pageContext.request.remoteUser}";
		var receiver = "${username}";
		var messagetext = $('message_textarea_conversation').value;
		MessageManager.sendPersonalMessageDWR(sender, receiver, messagetext, function(str){
			if(str == true) {
				$('conversation_message_result').innerHTML = "<fmt:message key='tamuvii.message.success'/><b>" + receiver + "</b>";
				displayElement('conversation_message_result');
				new Effect.Highlight('conversation_message_result', {startcolor: '#4F8CC9',	restorecolor: true, afterFinish: function(e) {
					var li = Builder.node('li');

					var fromto = Builder.node('div', { className: 'fromto' });					
					fromto.innerHTML = "<div class=\"person_list_info_container\"><div class=\"container\"><img src=\""+sender_image+"\" width=\"30\" height=\"30\" class=\"major\" /><img class=\"minor\" src=\"/images/frame_30.png\"></div><div class=\"person_list_info\">da<br/><b>"+sender+"</b></div></div><br/><div class=\"person_list_info_container\" style=\"clear:both;\"><div class=\"container\"><img src=\""+receiver_image+"\" width=\"30\" height=\"30\" class=\"major\" /><img class=\"minor\" src=\"/images/frame_30.png\"></div><div class=\"person_list_info\">a<br/><b>"+receiver+"</b></div></div><br/>";
					var last_message_text = Builder.node('div', { className: 'last_message_text' });
					last_message_text.innerHTML = messagetext;
					var message_separator = Builder.node('div', { className: 'messages_separator' });
					li.insert(fromto);
					li.insert(last_message_text);
					li.insert(message_separator);
					$('personal_messages_list').insert({"top":li });					
				}});
			} else {
				displayElement('conversation_message_result');
				$('conversation_message_result').innerHTML = "<fmt:message key='tamuvii.message.error'/>";
				new Effect.Highlight('message_textarea_conversation', {startcolor: '#FFB98C',	restorecolor: true});
			}
		});
	}
</script>



<script>
	var indexPal;
	var totPal;
	var recordsPerRowPal; 
	var pagesPal;
	var heightPal;
	
	Event.observe(window, 'load', function(event) {
		indexPal = 0;
		totPal = ${fn:length(groupedMessages)};
		recordsPerPagePal = 2;
		pagesPal = Math.ceil(totPal/recordsPerPagePal);
		
		if(totPal < recordsPerPagePal) {
			$('pal_list_container').setStyle({
				height: (totPal*35 + totPal*5 + totPal*1) + "px"
			});
		} else {
			$('pal_list_container').setStyle({
				height: (recordsPerPagePal*35 + recordsPerPagePal*5 + recordsPerPagePal*1) + "px"
			});
		}
		
		if(pagesPal > 1) {
    		$('downPal').setStyle({ display: 'block' });
	    }
	});

	//////// FUNZIONI GENERICHE PER LO SCROLLING //////// 
	function doup(index, step, container, h, down, up) {
		index = index-step;
		if(!$(down).visible()) {
			$(down).setStyle({ display: 'block' });
		}
		if(index == 0) {
			$(up).setStyle({ display: 'none' });
		}
		new Effect.Move($(container),{x: 0, y: step*h, duration: 0.3}); return index;
	}

	function dodown(index, pages, step, container, h, down, up) {
		index = index+step;
		if(!$(up).visible()) {
			$(up).setStyle({ display: 'block' });
		}
		if(index == (pages-1)) {
			$(down).setStyle({ display: 'none' });
		} else {
			$(down).setStyle({ display: 'block' });
		}
		new Effect.Move($(container),{x: 0, y: step*-h, duration: 0.3}); return index;
	}
	//////// FINE FUNZIONI GENERICHE PER LO SCROLLING ////////
</script>