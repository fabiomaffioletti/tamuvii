<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
    <script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/ShelfManager.js"> </script>
</head>

<div id="main">
	<div class="statistics_section_title">
		<div style="padding: 10px;">Visite alla tua videoteca</div>
	</div>
	<div class="statistics_section_content">
		<div id="statistics_visits">
			<ul>
				<li>
					Dalla data di creazione della tua videoteca, hai avuto <b>${userPublicInfo.visits}</b> visite.
				</li>
				<li>
					Vuoi sapere chi ti ha visitato? Ecco qui gli <a href="#" onclick="displayElement('statistics_last_visitors'); displayElement('hide_visitors_link'); return false;">ultimi visitatori!</a><a href="#" id="hide_visitors_link" style="display:none; font-size: 11px; margin-left: 5px;" onclick="hideElement('statistics_last_visitors'); hideElement(this.id); return false;"> (Nascondi)</a>		
				</li>
			</ul>
		</div>
		<div id="statistics_last_visitors" style="display: none;">
			<c:forEach var="contact" items="${statistics.lastVisitors}" varStatus="row" >
					<div class="statistics_last_visitors_content">
						<c:choose>
							<c:when test="${not empty contact.imageLink}">
								<div id="user_image_div" style="background-image: url(${contact.imageLink});" >
								</div>
							</c:when>
							<c:otherwise>
								<div id="user_image_div" style="background-image: url(/images/placeholder_user_48.jpg);" >
								</div>
							</c:otherwise>	
						</c:choose>
						<div id="user_profile_info" style="margin-bottom: 10px;">
							<a href="/shelf.html?username=${contact.username}" style="font-size: 14px; color: black; font-weight: bold;">${contact.username}</a>
							<br/>
							<span class="light_text_italic font12">
								<c:if test="${not empty contact.sex}">
									<c:choose>
										<c:when test="${contact.sex == 'M'}">
											Maschio,
										</c:when>
										<c:otherwise>
											Femmina,
										</c:otherwise>
									</c:choose>
								</c:if>
								<c:if test="${not empty contact.age && contact.age != -1}">${contact.age} anni,</c:if> ${contact.address.country}
								<span class="light_text_italic font11"><br/>${contact.totMovies} Film</span>
							</span>
						</div>
						<div class="statistics_latest_movies_added">
							<div class="statistics_last_movie_added_title">
								Ultimi film aggiunti
							</div>
							<c:forEach var="item" items="${contact.lastMovies}" begin="0" end="1">
								<div class="statistics_last_movie_added_item">
									<c:choose>
										<c:when test="${not empty item.localizedTitle}">
											<a href="/socialMovie.html?movie=${item.movie}">${item.localizedTitle}</a>
										</c:when>
										<c:otherwise>
											<a href="/socialMovie.html?movie=${item.movie}">${item.originalTitle}</a>
										</c:otherwise>
									</c:choose>
								</div>
							</c:forEach>
						</div>
					</div>
			</c:forEach>
		</div>
	</div>
	
	<div class="statistics_section_title">
		<div style="padding: 10px;">Rapporto sui film visti</div>
	</div>
	<div class="statistics_section_content">
		<ul style="list-style: none; padding: 0; margin: 0;">
			<li style="border-bottom: 1px dotted #ccc; height: 35px; font-size:13px; font-weight: bold;">
				<div style="width: 100px; clear: both; float:left; padding: 10px;">Anno</div>
				<div style="width: 150px; float:left; padding: 10px;">Numero di film</div>
				<div style="width: 150px; float:left; padding: 10px;">Minuti totali</div>
			</li>
			<c:forEach var="yearReport" items="${statistics.yearReport}">
				<li>
					<div style="width: 100px; clear:both; float:left; padding: 10px;">${yearReport.year}</div>
					<div style="width: 150px; float:left; padding: 10px;">${yearReport.numMovies}</div>
					<div style="width: 150px; float:left; padding: 10px;">${yearReport.totMinutes}</div>
				</li>			
			</c:forEach>
		</ul>
	</div>
	
</div>






<div id="sidebar">
	<div id="user_profile">
		<div id="user_profile_image">	
			<c:choose>
				<c:when test="${not empty userPublicInfo.imageLink}">
					<div id="user_image_div" style="background-image: url(${userPublicInfo.imageLink});" >
					</div>
				</c:when>
				<c:otherwise>
					<div id="user_image_div" style="background-image: url(/images/placeholder_user.jpg);" >
					</div>
				</c:otherwise>
			</c:choose>
			<div id="user_profile_info" style="margin-bottom: 10px;">
				<b>${userPublicInfo.username}</b>
				<br/>
				<span class="light_text_italic font12">${userPublicInfo.totMovies} film</span>
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
					<c:if test="${not empty userPublicInfo.age && userPublicInfo.age != -1}">${userPublicInfo.age} anni,</c:if> ${userPublicInfo.address.country}
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
			</ul>
		</div>
		<c:if test="${not empty username && username != pageContext.request.remoteUser}">
			<div id="option_hint_container">
				<div id="option_hint">Cosa vuoi fare?</div>
			</div>
		</c:if>
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
									<span class="light_text_italic">${shelfDirectorReportItem.numMovies} Film</span>
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
			<c:choose>
				<c:when test="${not empty username && username != pageContext.request.remoteUser}">
					<div style="float:right"><span id="friends_view_all" style="display:none;">vedi tutti </span><a href="/relationship.html?mode=friends&username=${username}" onmouseover="displayElement('friends_view_all')" onmouseout="hideElement('friends_view_all')">(${fn:length(friends)})</a></div>
				</c:when>
				<c:otherwise>
					<div style="float:right"><span id="friends_view_all" style="display:none;">vedi tutti </span><a href="/relationship.html?mode=friends" onmouseover="displayElement('friends_view_all')" onmouseout="hideElement('friends_view_all')">(${fn:length(friends)})</a></div>
				</c:otherwise>
			</c:choose>
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
			<c:choose>
				<c:when test="${not empty username && username != pageContext.request.remoteUser}">
					<div style="float:right"><span id="neighbors_view_all" style="display:none;">vedi tutti </span><a href="/relationship.html?mode=neighborhoods&username=${username}" onmouseover="displayElement('neighbors_view_all')" onmouseout="hideElement('neighbors_view_all')">(${fn:length(neighborhoods)})</a></div>
				</c:when>
				<c:otherwise>
					<div style="float:right"><span id="neighbors_view_all" style="display:none;">vedi tutti </span><a href="/relationship.html?mode=neighborhoods" onmouseover="displayElement('neighbors_view_all')" onmouseout="hideElement('neighbors_view_all')">(${fn:length(neighborhoods)})</a></div>
				</c:otherwise>
			</c:choose>
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
	      new Effect.ScrollTo(title, { duration: 0.5 });
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
			var span_director_numMovies = Builder.node('span', { className: 'light_text_italic' }, str[x].numMovies + ' Film');
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