<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
    <script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/ShelfManager.js"> </script>
</head>

<div id="main">
	<div id="options">
		<div id="order_div">
			<select id="order" name="">
				<option value="0">Ordina per:</option>
				<option value="1">data visto (dal pi&ugrave; recente)</option>
				<option value="2">data visto (dal pi&ugrave; vecchio)</option>
				<option value="3">giudizio (dal pi&ugrave; alto) </option>
				<option value="4">giudizio (dal pi&ugrave; basso) </option>
			</select>
		</div>
		<div id="search_div">
			<form>
				<input type="text" name="searchbox" id="searchbox_text" value="Cerca in questa videoteca" />
				<input type="image" src="/images/search.png" name="doSearchShelf" id="searchbox_button" />
			</form>
		</div>
	</div>
		
	<div id="movies">
		<div id="movies_list_container">
			<ul class="movie_list">
				<c:forEach var="shelfItem" items="${shelfItems}">
					<c:set var="displayOriginalTitle" value="n" />
					
					<li class="movie_image">
						<c:choose>
							<c:when test="${not empty shelfItem.localizedImage}">
								<img src="${shelfItem.localizedImage}" />
							</c:when>
							<c:otherwise>
								<img src="${shelfItem.originalImage}" />
							</c:otherwise>
						</c:choose>
					</li>
					
					<li class="movie_data">
						<div class="title" id="title_${shelfItem.movie}">
							<c:choose>
					    		<c:when test="${empty shelfItem.localizedTitle}">
						    		<a href="/socialMovie.html?movie=${shelfItem.movie}"><b>${shelfItem.originalTitle}</b></a> 
						    	</c:when>
						    	<c:otherwise>
						    		<a href="/socialMovie.html?movie=${shelfItem.movie}"><b>${shelfItem.localizedTitle}</b></a>
						    		<c:set var="displayOriginalTitle" value="y" />
						    	</c:otherwise>
					    	</c:choose>
						</div>
						
						<c:if test="${shelfItem.originalTitle != shelfItem.localizedTitle && displayOriginalTitle == 'y'}">
				    		<div class="localized_title">
				    			<i>Titolo originale: ${shelfItem.originalTitle}</i>
				    		</div>
				    	</c:if>
				    	
						<div class="directed_by">di <a href="/directorDetail.html?director=${shelfItem.directorId}">${shelfItem.director}</a></div>
						
						
						<c:if test="${not empty shelfItem.dateViewed}">
					    	<div class="date_viewed">Visto il: <fmt:formatDate pattern="${df}" value="${shelfItem.dateViewed}" /></div> 
					    </c:if>
				    	
						
						<c:if test="${shelfItem.mark > 0}">
					    	<div class="mark">
						    	<c:forEach begin="1" end="${shelfItem.mark}">
									<img src="/images/sun.png"/>	    		
						    	</c:forEach>
					    	</div>
				    	</c:if>
	
					</li>
					<li class="movie_actions">
						<div class="action action_title">Opzioni</div>
							<c:if test="${not empty shelfItem.originalPlot || not empty shelfItem.localizedPlot}">
								<div class="action"><a href="#" onclick="toggleAndMove('movie_plot_${shelfItem.movie}', 'title_${shelfItem.movie}'); return false;">Vedi trama</a></div>
							</c:if>
							<c:if test="${not empty shelfItem.review}">
								<div class="action"><a href="#" onclick="toggleAndMove('movie_review_${shelfItem.movie}', 'title_${shelfItem.movie}'); return false;">Vedi recensione</a></div>
							</c:if>
							<c:choose>
							    <c:when test="${empty username || username == pageContext.request.remoteUser}">
								    <div class="action"><a href="/personalMovie.html?movie=${shelfItem.movie}">Modifica</a></div>
							    </c:when>
							    <c:when test="${not empty username && username != pageContext.request.remoteUser}">
							    	<c:set var="isInPersonalMovies" value="0" />
						    		<c:set var="isWished" value="0" />
							    	<c:forEach var="personalMovieId" items="${personalMoviesIdsAndWishedFlags}">
							    		<c:if test="${personalMovieId.movie == shelfItem.movie}">
							    			<c:set var="isInPersonalMovies" value="1" />
							    			<c:if test="${personalMovieId.wished == 1}">
							    				<c:set var="isWished" value="1" />
							    			</c:if>
							    		</c:if>
							    	</c:forEach>
							    	<c:choose>
				    					<c:when test="${isInPersonalMovies == 0}">
				    						<div class="action"><a href="/shelfManagement.html?action=add&movie=${shelfItem.movie}">Aggiungi alla videoteca</a></div>
				    						<div class="action"><a href="/wishlistManagement.html?action=wish&movie=${shelfItem.movie}">Aggiungi alla wishlist</a></div>
				    					</c:when>
				    					<c:otherwise>
				    						<div class="action">Presente in 
				    							<c:if test="${isWished == 0}"> videoteca</c:if>
								    			<c:if test="${isWished == 1}"> wishlist</c:if>
				    						</div>
								    	</c:otherwise>
				    				</c:choose>
							    </c:when>
							</c:choose>
					</li>
					<li class="movie_plot" id="movie_plot_${shelfItem.movie}" style="display: none;">
						<div class="plot_text">
							 <c:choose>
					    		<c:when test="${empty shelfItem.localizedPlot}">
						    		${shelfItem.originalPlot}
						    	</c:when>
						    	<c:otherwise>
						    		${shelfItem.localizedPlot}
						    	</c:otherwise>
					    	</c:choose>
						</div>
					</li>
					<li class="movie_review" id="movie_review_${shelfItem.movie}" style="display: none;">
						<div class="review_text">
							${shelfItem.reviewText}
						</div>
					</li>
					
					<li class="separator">
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>












	
<div id="sidebar">
	<div id="user_profile">
		<div id="user_profile_image">	
			<div class="container_48">
				<img src="${userPublicInfo.imageLink}" width="48" height="48" class="major_48" />
				<img class="minor_48" src="/images/frame_48.png" alt="">
			</div>
			<div id="user_profile_info" style="margin-bottom: 10px;">
				<b>${userPublicInfo.username}</b>
				<br/>
				<span class="light_text_italic font12">12 film</span>
				<br/>
				<a href="#" id="other_info_link" onclick="displayOtherInfo('other_info_container')">Vedi altre informazioni</a>
			</div>
		</div>
		<div id="other_info_container" style="display: none;">
			<div id="other_info">
				<span class="light_text_italic font12">Maschio, 27 anni, Italy</span>
				<br/>
				<span class="font12">Sito web: <a href="${userPublicInfo.website}" target="_blank">${userPublicInfo.websiteTitle}</a></span>
				<br/>
				<span class="font12">Citazione preferita: </span><span class="light_text_italic font12">Mi piace il mio iPod Touch</span>
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
				<li><a href="#" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('Visualizza statistiche')" onclick="chooseOption('statistics')"><img src="/images/statistics.png" /></a></li>
			</ul>
		</div>
		<div id="option_hint_container">
			<div id="option_hint">Cosa vuoi fare?</div>
		</div>
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
				<span style="float: left;"><a href="#" onclick="Effect.toggle('send_message', 'slide',{ duration: 0.2 }); return false;">Annulla</a></span>
			</div>
		</div>
	</div>

	
	<div id="directors">
		<div class="relationship_title">
			<div style="float:left">Film per regista</div>
			<div style="float:right"><span id="directors_view_all" style="display:none;">vedi tutti </span><a href="#" onmouseover="displayElement('directors_view_all')" onmouseout="hideElement('directors_view_all')">(${fn:length(shelfDirectorReportList)})</a></div>
		</div>
		<div id="directors_list_container">
			<div id="directors_list_content">
				<ul class="person_list" id="directors_ul">
					<c:forEach var="shelfDirectorReportItem" items="${shelfDirectorReportList}">
						<li onclick="document.location.href='/directorDetail.html?director=${shelfDirectorReportItem.director}'">
							<div class="person_list_info_container">
								<div class="container">
									<img src="/images/placeholder_user.jpg" width="30" height="30" class="major" />
									<img class="minor" src="/images/frame_30.png" alt="">
								</div>
								<div class="person_list_info">
									<span class="bold_text">${shelfDirectorReportItem.name} ${shelfDirectorReportItem.surname}</span>
									<br/>
									<span class="light_text_italic">Film (${shelfDirectorReportItem.numMovies})</span>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="relationship_navigation" style="width:100%;">
			<a href="#" id="upDirectors" style="display:none;float:left;" onclick="indexDirectors = doup(indexDirectors, 1, 'directors_list_content', $('directors_list_container').getHeight(), 'downDirectors', 'upDirectors'); return false;"><img class="relationship_navigation_image" src="/images/bw.png"/></a>
			<div style="float:left; margin-left: 53px;">
				<span class="font12">Ordina: </span>
				<a href="#" onclick="orderShelfDirectorReportBySurname('${userPublicInfo.username}'); return false;">A-Z</a>
				<a href="#" onclick="orderShelfDirectorReportByNumMovies('${userPublicInfo.username}'); return false;"># Film</a>
			</div>
			<a href="#" id="downDirectors" style="float:right;display:none;" onclick="indexDirectors = dodown(indexDirectors, pagesDirectors, 1, 'directors_list_content', $('directors_list_container').getHeight(), 'downDirectors', 'upDirectors'); return false;"><img class="relationship_navigation_image" src="/images/ff.png"/></a>
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
									<span class="light_text_italic">Nessun informazione aggiunta</span>
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
									<span class="light_text_italic">Nessun informazione aggiunta</span>
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
		new Effect.toggle(id, 'slide', { duration: 0.2 });
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
	var indexDirectors;
	var totDirectors;
	var recordsPerRowDirectors; 
	var pagesDirectors;
	var heightDirectors;
	
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
		indexDirectors = 0;
		totDirectors = ${fn:length(shelfDirectorReportList)};
		recordsPerPageDirectors = 5;
		pagesDirectors = Math.ceil(totDirectors/recordsPerPageDirectors);
		
		indexFriends = 0;
		totFriends = ${fn:length(friends)};
		recordsPerPageFriends = 5;
		pagesFriends = Math.ceil(totFriends/recordsPerPageFriends);
		
		indexNeighbors = 0;
		totNeighbors = ${fn:length(neighborhoods)};
		recordsPerPageNeighbors = 5;
		pagesNeighbors = Math.ceil(totNeighbors/recordsPerPageNeighbors);
		
		if(totDirectors < recordsPerPageDirectors) {
			$('directors_list_container').setStyle({
				height: (totDirectors*35 + totDirectors*5 + totDirectors*1) + "px"
			});
		} else {
			$('directors_list_container').setStyle({
				height: (recordsPerPageDirectors*35 + recordsPerPageDirectors*5 + recordsPerPageDirectors*1) + "px"
			});
		}
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
		
		
		if(pagesDirectors > 1) {
    		$('downDirectors').setStyle({ display: 'block' });
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

<script>
	function sendMessage() {
		var receiver = "${username}";
		var messagetext = $('messagetext').value;
		new Ajax.Request('/sendMessage.html?ajax=true&receiver='+receiver+'&messagetext='+messagetext, {
			  method: 'post',
			  onSuccess: function(response) {
			    var notice = $('messagetext');
			    notice.value = response.responseText;
			    setTimeout("endEffect()", 2000);
			}
		});
	}
	
	function endEffect() {
		$('messagetext').value = "";
		Effect.BlindUp('sendMessage');
	}
</script>

<script>
	//////// FUNZIONI DI AGGIORNAMENTO PER IL REPORT DEI REGISTI ////////
	// Ordina per cognome
	function orderShelfDirectorReportBySurname(username) {
		ShelfManager.getShelfDirectorReport(username, null, null, "surname", function(str) {
			refreshShelfDirectorReportList(str);
		});
	}
	// Ordina per numero di film
	function orderShelfDirectorReportByNumMovies(username) {
		ShelfManager.getShelfDirectorReport(username, null, null, null, function(str) {
			refreshShelfDirectorReportList(str);
		});
	}
	// Aggiorna la ul
	function refreshShelfDirectorReportList(str) {
		dwr.util.removeAllOptions('directors_ul');
		for(var x=0; x<str.length; x++) {
			var li = Builder.node('li', { onclick: "document.location.href='/directorDetail.html?director="+str[x].director+"'" });
			var person_list_info_container = Builder.node('div', { className: 'person_list_info_container' });
			var container = Builder.node('div', { className: 'container' });
			var director_image = Builder.node('img', {className: 'major', height: '30', width: '30', src: '/images/placeholder_user.jpg'});
			var director_image_frame = Builder.node('img', {className: 'minor', src: '/images/frame_30.png'});

			var div_person_list_info = Builder.node('div', { className: 'person_list_info' });
			var span_director_name = Builder.node('span', { className: 'bold_text' }, str[x].name + ' ' + str[x].surname);
			var span_director_numMovies = Builder.node('span', { className: 'light_text_italic' }, 'Film (' + str[x].numMovies + ')');
			var br = Builder.node('br');
			
			container.insert(director_image);
			container.insert(director_image_frame);

			div_person_list_info.insert(span_director_name);
			div_person_list_info.insert(br);
			div_person_list_info.insert(span_director_numMovies);

			person_list_info_container.insert(container);
			person_list_info_container.insert(div_person_list_info);

			li.insert(person_list_info_container);
			$('directors_ul').insert(li);
		}
	}
	//////// FINE FUNZIONI DI AGGIORNAMENTO PER IL REPORT DEI REGISTI ////////
</script>