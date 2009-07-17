<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="wishlist.pagetitle"/></title>
    <script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/ShelfManager.js"> </script>
    <script type="text/javascript" src="/dwr/interface/MessageManager.js"> </script>
</head>

<div id="sidebar">
	<div id="user_profile">
		<div id="user_profile_image">	
				<c:choose>
					<c:when test="${not empty userPublicInfo.imageLink}">
						<div id="user_image_div" style="background-image: url(${userPublicInfo.imageLink});" >
						</div>				
					</c:when>
					<c:otherwise>
						<div id="user_image_div" style="background-image: url(/images/placeholder_user_48.jpg);" >
						</div>
					</c:otherwise>
				</c:choose>
			<div id="user_profile_info" style="margin-bottom: 10px;">
				<b>${userPublicInfo.username}</b>
				<br/>
				<span class="light_text_italic font12">${userPublicInfo.totMovies} 
					<c:choose>
						<c:when test="${userPublicInfo.totMovies > 1}">
							<fmt:message key="label.movies" />		
						</c:when>
						<c:otherwise>
							<fmt:message key="label.movie" />
						</c:otherwise>
					</c:choose>
				</span>
				<br/>
				<a href="#" id="other_info_link" onclick="displayOtherInfo('other_info_container')">Vedi altre informazioni</a>
			</div>
		</div>
		<div id="other_info_container" style="display: none;">
			<div id="other_info">
				<span class="light_text_italic font12">
					<c:if test="${not empty userPublicInfo.sex}">
						<c:choose>
							<c:when test="${userPublicInfo.sex == 'M'}">
								Maschio,
							</c:when>
							<c:otherwise>
								Femmina,
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${not empty userPublicInfo.age && userPublicInfo.age != -1}">${userPublicInfo.age} anni,</c:if> Italy
					<br/>	
				</span>
				<c:if test="${not empty userPublicInfo.website}">
					<span class="font12">Sito web: <a href="${userPublicInfo.website}" target="_blank">${userPublicInfo.websiteTitle}</a></span>
					<br/>
				</c:if>
				<c:if test="${not empty userPublicInfo.quotation}">
					<span class="font12">Citazione preferita: </span><span class="light_text_italic font12">${userPublicInfo.quotation}</span>
				</c:if>
			</div>
		</div>
		<div id="user_profile_options">
			<ul>
				<c:if test="${not empty username && username != pageContext.request.remoteUser}">
					<li><a href="#" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('Invia un messaggio privato')" onclick="chooseOption('send_message')"><img src="/images/message.png" /></a></li>
				</c:if>
				<c:if test="${not empty username && username != pageContext.request.remoteUser}">
				<li><a href="#" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('Relazioni')" onclick="chooseOption('relationship')"><img src="/images/add_friend.png" /></a></li>
				</c:if>
				<c:if test="${not empty username && username != pageContext.request.remoteUser}">
				<li><a href="#" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('Calcola compatibilit&agrave;')" onclick="chooseOption('compatibility')"><img src="/images/calculator.png" /></a></li>
				</c:if>
				<c:if test="${not empty username && username != pageContext.request.remoteUser}">
				<li><a href="/shelf.html?username=${username}" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('Vedi la sua videoteca')"><img src="/images/video.png" /></a></li>
				</c:if>
			</ul>
		</div>
		<c:if test="${not empty username && username != pageContext.request.remoteUser}">
			<div id="option_hint_container">
				<div id="option_hint">Cosa vuoi fare?</div>
			</div>
		</c:if>
	</div>
	
	
	<div id="relationship_area">
		<div id="relationship_container">
			<div id="relationship" style="display:none;">
				<c:choose>
					<c:when test="${not empty username && username != pageContext.request.remoteUser}">
						<c:choose>
							<c:when test="${areFriends}">
								<ul>
									<li onclick="document.location.href='/relationshipManagement.html?action=moveToNeighborhoods&username=${username}'">Cambia a vicino</li>
									<li onclick="document.location.href='/relationshipManagement.html?action=deleteFriend&username=${username}'">Cancella dagli amici</li>
								</ul>
							</c:when>
							<c:when test="${areNeighborhoods}">
								<ul>
									<li onclick="document.location.href='/relationshipManagement.html?action=moveToFriends&username=${username}'">Cambia a amico</li>
									<li onclick="document.location.href='/relationshipManagement.html?action=deleteNeighborhood&username=${username}'">Cancella dai vicini</li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul>
									<li onclick="document.location.href='/relationship.html?mode=friends&username=${username}'">Aggiungi come amico</li>
									<li onclick="document.location.href='/relationship.html?mode=neighborhoods&username=${username}'">Aggiungi come vicino</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</c:when>
				</c:choose>
				<div style="float: left;"><a href="#" onclick="Effect.toggle('relationship', 'slide',{ duration: 0.2 }); return false;">Chiudi</a></div>
			</div>
		</div>
	</div>
	
	<div id="compatibility_area">
		<div id="compatibility_container">
			<div id="compatibility" style="width:100%; display:none;">
				<div id="compatibility_message">
					<div style="font-size: 12px; color: black;">La compatibilit&agrave; con questo utente &egrave;:</div>
					<div id="compatibility_value">94%</div>
				</div>
				<div style="float: left;"><a href="#" onclick="Effect.toggle('compatibility', 'slide',{ duration: 0.2 }); return false;">Chiudi</a></div>
				<div style="float: right;"><a href="#">Dettagli</a></div>
			</div>
		</div>
	</div>

	<div id="message_area">
		<div id="send_message_container">
			<div id="send_message" style="width:100%; display:none;">
				<textarea id="messagetext" name="messagetext" style="width: 98%" rows="5"></textarea>
				<span style="float: right;"><input type="button" name="sendMessage" value="Spedisci" onclick="sendMessage()" /></span>
				<span style="float: left;"><a href="#" onclick="cancelSendingMessage(); return false;">Annulla</a></span>
			</div>
		</div>
	</div>

	
	<div id="friends">
		<div class="relationship_title">
			<div style="float:left">Amici</div>
			<div style="float:right"><span id="friends_view_all" style="display:none;">vedi tutti </span><a href="/relationship.html?mode=friends" onmouseover="displayElement('friends_view_all')" onmouseout="hideElement('friends_view_all')">(${fn:length(friends)})</a></div>
		</div>
		<div id="friends_list_container">	
			<div id="friends_list_content">
				<ul class="person_list">
					<c:forEach var="friend" items="${friends}">
						<li onclick="document.location.href='/shelf.html?username=${friend.username}'">
							<div class="person_list_info_container">
								<div class="container">
									<img src="${friend.imageLink}" width="30" height="30" class="major" />
									<img class="minor" src="/images/frame_30.png" alt="">
								</div>
								<div class="person_list_info">
									<b>${friend.username}</b>
									<br/>
									<span class="light_text_italic">
										<c:if test="${not empty friend.sex}">
											<c:choose>
												<c:when test="${friend.sex == 'M'}">
													Maschio,
												</c:when>
												<c:otherwise>
													Femmina,
												</c:otherwise>
											</c:choose>
										</c:if>
										<c:if test="${not empty friend.age && friend.age != -1}">${friend.age} anni,</c:if> ${friend.address.country}
									</span>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="relationship_navigation" style="width:100%;">
			<a href="#" id="upFriends" style="display:none;float:left;" onclick="indexFriends = doup(indexFriends, 1, 'friends_list_content', $('friends_list_container').getHeight(), 'downFriends', 'upFriends'); return false;"><img class="relationship_navigation_image" src="/images/bw.png"/></a>
			<a href="#" id="downFriends" style="float:right;display:none;" onclick="indexFriends = dodown(indexFriends, pagesFriends, 1, 'friends_list_content', $('friends_list_container').getHeight(), 'downFriends', 'upFriends'); return false;"><img class="relationship_navigation_image" src="/images/ff.png"/></a>
		</div>
	</div>


	<div id="neighbors">
		<div class="relationship_title">
			<div style="float:left">Vicini</div>
			<div style="float:right"><span id="neighbors_view_all" style="display:none;">vedi tutti </span><a href="/relationship.html?mode=neighborhoods" onmouseover="displayElement('neighbors_view_all')" onmouseout="hideElement('neighbors_view_all')">(${fn:length(neighborhoods)})</a></div>
		</div>
		<div id="neighbors_list_container">	
			<div id="neighbors_list_content">
				<ul class="person_list">
					<c:forEach var="neighborhood" items="${neighborhoods}">
						<li onclick="document.location.href='/shelf.html?username=${neighborhood.username}'">
							<div class="person_list_info_container">
								<div class="container">
									<img src="${neighborhood.imageLink}" width="30" height="30" class="major" />
									<img class="minor" src="/images/frame_30.png" alt="">
								</div>
								<div class="person_list_info">
									<b>${neighborhood.username}</b>
									<br/>
									<span class="light_text_italic">
										<c:if test="${not empty neighborhood.sex}">
											<c:choose>
												<c:when test="${neighborhood.sex == 'M'}">
													Maschio,
												</c:when>
												<c:otherwise>
													Femmina,
												</c:otherwise>
											</c:choose>
										</c:if>
										<c:if test="${not empty neighborhood.age && neighborhood.age != -1}">${neighborhood.age} anni,</c:if> ${neighborhood.address.country}
									</span>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="relationship_navigation" style="width:100%;">
			<a href="#" id="upNeighbors" style="display:none;float:left;" onclick="indexNeighbors = doup(indexNeighbors, 1, 'neighbors_list_content', $('neighbors_list_container').getHeight(), 'downNeighbors', 'upNeighbors'); return false;"><img class="relationship_navigation_image" src="/images/bw.png"/></a>
			<a href="#" id="downNeighbors" style="float:right;display:none;" onclick="indexNeighbors = dodown(indexNeighbors, pagesNeighbors, 1, 'neighbors_list_content', $('neighbors_list_container').getHeight(), 'downNeighbors', 'upNeighbors'); return false;"><img class="relationship_navigation_image" src="/images/ff.png"/></a>
		</div>
	</div>
</div>


<div id="main">
	<div id="options">
		<div id="order_div">
			<select id="order" name="">
				<option value="0">Ordina per:</option>
				<option value="1">priorit&agrave; (dalla pi&ugrave; alta)</option>
				<option value="2">priorit&agrave; (dalla pi&ugrave; bassa)</option>
				<option value="3">data inserimento (dal pi&ugrave; recente) </option>
				<option value="4">data inserimento (dal meno recente) </option>
			</select>
		</div>
	</div>
		
	<div id="movies">
		<div id="movies_list_container">
			<ul class="movie_list">
				<c:forEach var="wishedItem" items="${wishedItems}">
					<c:set var="displayOriginalTitle" value="n" />
					
					<li class="movie_image">
						<c:choose>
							<c:when test="${not empty wishedItem.localizedImage}">
								<img src="${wishedItem.localizedImage}" />
							</c:when>
							<c:otherwise>
								<img src="${wishedItem.originalImage}" />
							</c:otherwise>
						</c:choose>
					</li>
					
					<li class="movie_data">
						<div class="title" id="title_${wishedItem.movie}">
							<c:choose>
					    		<c:when test="${empty wishedItem.localizedTitle}">
						    		<a href="/socialMovie.html?movie=${wishedItem.movie}"><b>${wishedItem.originalTitle}</b></a> 
						    	</c:when>
						    	<c:otherwise>
						    		<a href="/socialMovie.html?movie=${wishedItem.movie}"><b>${wishedItem.localizedTitle}</b></a>
						    		<c:set var="displayOriginalTitle" value="y" />
						    	</c:otherwise>
					    	</c:choose>
						</div>
						
						<c:if test="${wishedItem.originalTitle != wishedItem.localizedTitle && displayOriginalTitle == 'y'}">
				    		<div class="localized_title">
				    			<i>Titolo originale: ${wishedItem.originalTitle}</i>
				    		</div>
				    	</c:if>
				    	
						<div class="directed_by">di <a href="/directorDetail.html?director=${wishedItem.directorId}">${wishedItem.director}</a></div>
					</li>
					<c:if test="${empty username || username == pageContext.request.remoteUser}">
						<li class="movie_actions">
							<div class="action action_title">Opzioni</div>
							<div class="action"><a href="/wishlistManagement.html?action=move&movie=${wishedItem.movie}">Sposta nella videoteca</a></div>
					    	<div class="action"><a href="/wishlistManagement.html?action=delete&movie=${wishedItem.movie}">Cancella dalla wishlist</a></div>
						</li>
					</c:if>
					
					<li class="separator">
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>


<script>
	function cancelSendingMessage() {
		$('messagetext').value = "";
		new Effect.Fade('send_message', { duration: 0.4 });
		return false;
	}
	function sendMessage() {
		var sender = "${pageContext.request.remoteUser}";
		var receiver = "${username}";
		var messagetext = $('messagetext').value;
		MessageManager.sendPersonalMessageDWR(sender, receiver, messagetext, function(str){
			if(str == true) {
				$('messagetext').value = "<fmt:message key='tamuvii.message.success'/>" + receiver;
				new Effect.Highlight('messagetext', {startcolor: '#4F8CC9',	restorecolor: true, afterFinish: function(e) {
					setTimeout("endSendingMessage()", 3000);
				}});
			} else {
				$('messagetext').value = "<fmt:message key='tamuvii.message.error'/>";
				new Effect.Highlight('messagetext', {startcolor: '#FFB98C',	restorecolor: true});
			}
		});
	}
	function endSendingMessage() {
		$('messagetext').value = "";
		Effect.Fade('send_message');
	}
	
</script>
		
<script>
	function displayElement(id) {
		$(id).appear({ duration: 0.2 });
		return false;
	}
	function hideElement(id) {
		$(id).fade({ duration: 0.2 });
		return false;
	}
	
	function chooseOption(id) {
		if($(id).visible()) {
			new Effect.Fade(id, { duration: 0.4 });
		} else {
			new Effect.Appear(id, { duration: 0.4 });
		}
		return false;
	}
	function displayOptionHint(hint) {
		$('option_hint').innerHTML = hint;		
		return false;
	}
	function resetOptionHint() {
		$('option_hint').innerHTML = 'Cosa vuoi fare?';		
		return false;
	}
	function displayOtherInfo() {
		$('other_info_container').appear({ duration: 0.2 });
		$('other_info_link').innerHTML = "Nascondi altre informazioni";
		$('other_info_link').onclick = hideOtherInfo;
		return false;
	}
	function hideOtherInfo() {
		$('other_info_container').fade({ duration: 0.2 });
		$('other_info_link').innerHTML = "Vedi altre informazioni";
		$('other_info_link').onclick = displayOtherInfo;
		return false;
	}
	function toggleAndMove(id, title) {	
		new Effect.toggle(id, 'slide', { duration: 0.5, afterFinish: function(effect) {
	      new Effect.ScrollTo(title);
	    }});
	}
</script>

<script>
	var indexFriends;
	var totFriends;
	var recordsPerRowFriends; 
	var pagesFriends;
	var heightFriends;
	
	var indexNeighbors;
	var totNeighbors;
	var recordsPerRowNeighbors; 
	var pagesNeighbors;
	var heightNeighbors;
	
	Event.observe(window, 'load', function(event) {
		
		indexFriends = 0;
		totFriends = ${fn:length(friends)};
		recordsPerPageFriends = 5;
		pagesFriends = Math.ceil(totFriends/recordsPerPageFriends);
		
		indexNeighbors = 0;
		totNeighbors = ${fn:length(neighborhoods)};
		recordsPerPageNeighbors = 5;
		pagesNeighbors = Math.ceil(totNeighbors/recordsPerPageNeighbors);
		

		if(totFriends < recordsPerPageFriends) {
			$('friends_list_container').setStyle({
				height: (totFriends*35 + totFriends*5 + totFriends*1) + "px"
			});
		} else {
			$('friends_list_container').setStyle({
				height: (recordsPerPageFriends*35 + recordsPerPageFriends*5 + recordsPerPageFriends*1) + "px"
			});
		}
		if(totNeighbors < recordsPerPageNeighbors) {
			$('neighbors_list_container').setStyle({
				height: (totNeighbors*35 + totNeighbors*5 + totNeighbors*1) + "px"
			});
		} else {
			$('neighbors_list_container').setStyle({
				height: (recordsPerPageNeighbors*35 + recordsPerPageNeighbors*5 + recordsPerPageNeighbors*1) + "px"
			});
		}
		
		
	    if(pagesFriends > 1) {
    		$('downFriends').setStyle({ display: 'block' });
	    }
		if(pagesNeighbors > 1) {
    		$('downNeighbors').setStyle({ display: 'block' });
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