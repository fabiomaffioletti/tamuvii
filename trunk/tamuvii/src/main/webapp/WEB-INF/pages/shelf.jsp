<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
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
				<a href="#" id="other_info_link" onclick="displayOtherInfo('other_info_container')"><fmt:message key="label.see.other.info" /></a>
			</div>
		</div>
		<div id="other_info_container" style="display: none;">
			<div id="other_info">
				<span class="light_text_italic font12">
					<c:if test="${not empty userPublicInfo.sex}">
						<c:choose>
							<c:when test="${userPublicInfo.sex == 'M'}">
								<fmt:message key="label.male" />,
							</c:when>
							<c:otherwise>
								<fmt:message key="label.female" />,
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${not empty userPublicInfo.age && userPublicInfo.age != -1}">${userPublicInfo.age} anni,</c:if> ${userPublicInfo.address.country}
					<br/>	
				</span>
				<c:if test="${not empty userPublicInfo.website}">
					<span class="font12"><fmt:message key="label.website" />: <a href="${userPublicInfo.website}" target="_blank">${userPublicInfo.websiteTitle}</a></span>
					<br/>
				</c:if>
				<c:if test="${not empty userPublicInfo.quotation}">
					<span class="font12"><fmt:message key="label.quotation" />: </span><span class="light_text_italic font12">${userPublicInfo.quotation}</span>
				</c:if>
			</div>
		</div>
		<div id="user_profile_options">
			<ul>
				<c:if test="${not empty username && username != pageContext.request.remoteUser}">
					<li><a href="#" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('<fmt:message key="label.send.private.message" />')" onclick="chooseOption('send_message')"><img src="/images/message.png" /></a></li>
				</c:if>
				<c:if test="${not empty username && username != pageContext.request.remoteUser}">
				<li><a href="#" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('<fmt:message key="label.relationships" />')" onclick="chooseOption('relationship')"><img src="/images/add_friend.png" /></a></li>
				</c:if>
				<c:if test="${not empty username && username != pageContext.request.remoteUser}">
				<li><a href="#" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('<fmt:message key="label.calc.compatibility" />')" onclick="chooseOption('compatibility')"><img src="/images/calculator.png" /></a></li>
				</c:if>
				<c:if test="${not empty username && username != pageContext.request.remoteUser}">
				<li><a href="/wishlist.html?username=${username}" onmouseout="resetOptionHint()" onmouseover="displayOptionHint('<fmt:message key="label.view.wishlist" />')"><img src="/images/wishlist.png" /></a></li>
				</c:if>
			</ul>
		</div>
		<c:if test="${not empty username && username != pageContext.request.remoteUser}">
			<div id="option_hint_container">
				<div id="option_hint"><fmt:message key="label.what.do.you.want.to.do" /></div>
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
									<li onclick="document.location.href='/relationshipManagement.html?action=moveToNeighborhoods&username=${username}'"><fmt:message key="label.change.to.neighbor" /></li>
									<li onclick="document.location.href='/relationshipManagement.html?action=deleteFriend&username=${username}'"><fmt:message key="label.delete.from.friends" /></li>
								</ul>
							</c:when>
							<c:when test="${areNeighborhoods}">
								<ul>
									<li onclick="document.location.href='/relationshipManagement.html?action=moveToFriends&username=${username}'"><fmt:message key="label.change.to.friend" /></li>
									<li onclick="document.location.href='/relationshipManagement.html?action=deleteNeighborhood&username=${username}'"><fmt:message key="label.delete.from.neighbors" /></li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul>
									<li onclick="document.location.href='/relationshipManagement.html?action=addFriend&username=${username}'"><fmt:message key="label.add.friend" /></li>
									<li onclick="document.location.href='/relationshipManagement.html?action=addNeighborhood&username=${username}'"><fmt:message key="label.add.neighbor" /></li>
								</ul>
							</c:otherwise>
						</c:choose>
					</c:when>
				</c:choose>
				<div style="float: left;"><a href="#" onclick="Effect.Fade('relationship', { duration: 0.4 }); return false;"><fmt:message key="label.close" /></a></div>
			</div>
		</div>
	</div>
	
	<div id="compatibility_area">
		<div id="compatibility_container">
			<div id="compatibility" style="width:100%; display:none;">
				<div id="compatibility_message">
					<div style="font-size: 12px; color: black;">La compatibilit&agrave; con questo utente &egrave;:</div>
					<div id="compatibility_value">94% (demo)</div>
				</div>
				<div style="float: left;"><a href="#" onclick="Effect.Fade('compatibility', { duration: 0.4 }); return false;"><fmt:message key="label.close" /></a></div>
				<div style="float: right;"><a href="#">Dettagli</a></div>
			</div>
		</div>
	</div>

	<div id="message_area">
		<div id="send_message_container">
			<div id="send_message" style="width:100%; display:none;">
				<textarea id="messagetext" name="messagetext" style="width: 98%" rows="5"></textarea>
				<span style="float: right;"><input type="button" name="sendMessage" value="Spedisci" onclick="sendMessage()" /></span>
				<span style="float: left;"><a href="#" onclick="cancelSendingMessage(); return false;"><fmt:message key="label.cancel" /></a></span>
			</div>
		</div>
	</div>

	
	<div id="directors">
		<div class="relationship_title">
			<div style="float:left"><fmt:message key="label.movies.director" /></div>
			<div style="float:right">(${fn:length(shelfDirectorReportList)})</div>
		</div>
		<div id="directors_list_container">
			<div id="loader_sdr" style="height:inherit;display:none;">
				<center>
				<img src="/images/loader.gif" />
				</center>
			</div>
			<div id="directors_list_content">
				<ul class="person_list" id="directors_ul">
					<c:forEach var="shelfDirectorReportItem" items="${shelfDirectorReportList}">
						<li onclick="filterShelf('${userPublicInfo.username}', '${shelfDirectorReportItem.director}'); return false;">
							<div class="person_list_info_container">
								<div class="container">
									<img src="/images/placeholder_user_48.jpg" width="30" height="30" class="major" />
									<img class="minor" src="/images/frame_30.png" alt="">
								</div>
								<div class="person_list_info">
									<span class="bold_text">${shelfDirectorReportItem.name} ${shelfDirectorReportItem.surname}</span>
									<br/>
									<span class="light_text_italic">${shelfDirectorReportItem.numMovies} 
										<c:choose>
											<c:when test="${shelfDirectorReportItem.numMovies > 1}">
												<fmt:message key="label.movies" />
											</c:when>
											<c:otherwise>
												<fmt:message key="label.movie" />
											</c:otherwise>
										</c:choose>
									</span>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="relationship_navigation" style="width:100%;">
			<span style="width: 50px">
				<a href="#" id="upDirectors" style="display:none;float:left;" onclick="indexDirectors = doup(indexDirectors, 1, 'directors_list_content', $('directors_list_container').getHeight(), 'downDirectors', 'upDirectors'); return false;"><img class="relationship_navigation_image" src="/images/bw.png"/></a>
			</span>
			<span>
				<span class="font12"><fmt:message key="label.order" />: </span>
				<a href="#" onclick="orderShelfDirectorReport('surname', '${userPublicInfo.username}'); return false;">a-z</a>
				<a href="#" onclick="orderShelfDirectorReport('null', '${userPublicInfo.username}'); return false;"># Film</a>
			</span>
			<span style="width: 50px">
				<a href="#" id="downDirectors" style="float:right;display:none;" onclick="indexDirectors = dodown(indexDirectors, pagesDirectors, 1, 'directors_list_content', $('directors_list_container').getHeight(), 'downDirectors', 'upDirectors'); return false;"><img class="relationship_navigation_image" src="/images/ff.png"/></a>
			</span>
		</div>
	</div>
	
	
	<div id="friends">
		<div class="relationship_title">
			<div style="float:left"><fmt:message key="label.friends" /></div>
			<c:choose>
				<c:when test="${not empty username && username != pageContext.request.remoteUser}">
					<div style="float:right"><span id="friends_view_all" style="display:none;"><fmt:message key="label.see.all" /> </span><a href="/relationship.html?mode=friends&username=${username}" onmouseover="displayElement('friends_view_all')" onmouseout="hideElement('friends_view_all')">(${fn:length(friends)})</a></div>
				</c:when>
				<c:otherwise>
					<div style="float:right"><span id="friends_view_all" style="display:none;"><fmt:message key="label.see.all" /> </span><a href="/relationship.html?mode=friends" onmouseover="displayElement('friends_view_all')" onmouseout="hideElement('friends_view_all')">(${fn:length(friends)})</a></div>
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
									<c:choose>
										<c:when test="${not empty friend.imageLink}">
											<img src="${friend.imageLink}" width="30" height="30" class="major" />
											<img class="minor" src="/images/frame_30.png" alt="">		
										</c:when>
										<c:otherwise>
											<img src="/images/placeholder_user_48.jpg" width="30" height="30" class="major" />
											<img class="minor" src="/images/frame_30.png" alt="">
										</c:otherwise>
									</c:choose>
								</div>
								<div class="person_list_info">
									<b>${friend.username}</b>
									<br/>
									<span class="light_text_italic">
										<c:if test="${not empty friend.sex}">
											<c:choose>
												<c:when test="${friend.sex == 'M'}">
													<fmt:message key="label.male" />,
												</c:when>
												<c:otherwise>
													<fmt:message key="label.female" />,
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
			<div style="float:left"><fmt:message key="label.neighbors" /></div>
			<c:choose>
				<c:when test="${not empty username && username != pageContext.request.remoteUser}">
					<div style="float:right"><span id="neighbors_view_all" style="display:none;"><fmt:message key="label.see.all" /> </span><a href="/relationship.html?mode=neighborhoods&username=${username}" onmouseover="displayElement('neighbors_view_all')" onmouseout="hideElement('neighbors_view_all')">(${fn:length(neighborhoods)})</a></div>
				</c:when>
				<c:otherwise>
					<div style="float:right"><span id="neighbors_view_all" style="display:none;"><fmt:message key="label.see.all" /> </span><a href="/relationship.html?mode=neighborhoods" onmouseover="displayElement('neighbors_view_all')" onmouseout="hideElement('neighbors_view_all')">(${fn:length(neighborhoods)})</a></div>
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
									<c:choose>
										<c:when test="${not empty neighborhood.imageLink}">
											<img src="${neighborhood.imageLink}" width="30" height="30" class="major" />
											<img class="minor" src="/images/frame_30.png" alt="">		
										</c:when>
										<c:otherwise>
											<img src="/images/placeholder_user_48.jpg" width="30" height="30" class="major" />
											<img class="minor" src="/images/frame_30.png" alt="">
										</c:otherwise>
									</c:choose>
								</div>
								<div class="person_list_info">
									<b>${neighborhood.username}</b>
									<br/>
									<span class="light_text_italic">
										<c:if test="${not empty neighborhood.sex}">
											<c:choose>
												<c:when test="${neighborhood.sex == 'M'}">
													<fmt:message key="label.male" />,
												</c:when>
												<c:otherwise>
													<fmt:message key="label.female" />,
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
			<select id="order" name="order" onchange="orderShelfByFilter('${userPublicInfo.username}'); return false;">
				<option value="1">data visto (dal pi&ugrave; recente)</option>
				<option value="2">data visto (dal pi&ugrave; vecchio)</option>
				<option value="3">giudizio (dal pi&ugrave; alto) </option>
				<option value="4">giudizio (dal pi&ugrave; basso) </option>
			</select>
		</div>
		<div id="search_div">
			<form>
				<input type="text" name="searchbox" id="searchbox_text" value="<fmt:message key='label.search.shelf' />" />
				<input type="image" src="/images/search.png" name="doSearchShelf" id="searchbox_button" />
			</form>
		</div>
	</div>
		
	<div id="movies">
		<div id="movies_list_container">
			<ul id="movie_list" class="movie_list">
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
						    	</c:otherwise>
					    	</c:choose>
						</div>
						
						<c:if test="${shelfItem.originalTitle != shelfItem.localizedTitle}">
				    		<div class="localized_title">
				    			<i><fmt:message key="label.original.title" />: ${shelfItem.originalTitle}</i>
				    		</div>
				    	</c:if>
				    	
						<div class="directed_by"><fmt:message key="label.by" /> <a href="/directorDetail.html?director=${shelfItem.directorId}">${shelfItem.director}</a></div>
						
						<div class="light_text_italic font11" style="width: 100%; float:left;">${shelfItem.numUsers}
				    		<c:choose>
				    			<c:when test="${shelfItem.numUsers > 1}">
				    				<fmt:message key="label.users" />
				    			</c:when>
				    			<c:otherwise>
				    				<fmt:message key="label.user" />
				    			</c:otherwise>
				    		</c:choose> 
						</div>
						
						<c:if test="${not empty shelfItem.dateViewed}">
					    	<div class="date_viewed"><fmt:message key="label.date.viewed" />: <fmt:formatDate pattern="${df}" value="${shelfItem.dateViewed}" /></div> 
					    </c:if>
						
						<c:if test="${shelfItem.mark > 0}">
					    	<div class="mark">
						    	<c:forEach begin="1" end="${shelfItem.mark}">
									<img src="/images/star.gif"/>
						    	</c:forEach>
					    	</div>
				    	</c:if>
	
					</li>
					<li class="movie_actions">
						<div class="action action_title"><fmt:message key="label.options" /></div>
							<c:if test="${not empty shelfItem.originalPlot || not empty shelfItem.localizedPlot}">
								<div class="action"><a href="#" onclick="toggleAndMove('movie_plot_${shelfItem.movie}', 'title_${shelfItem.movie}'); return false;"><fmt:message key="label.plot" /></a></div>
							</c:if>
							<c:if test="${not empty shelfItem.review}">
								<div class="action"><a href="#" onclick="toggleAndMove('movie_review_${shelfItem.movie}', 'title_${shelfItem.movie}'); return false;"><fmt:message key="label.review" /></a></div>
							</c:if>
							<c:choose>
							    <c:when test="${empty username || username == pageContext.request.remoteUser}">
								    <div class="action"><a href="/personalMovie.html?movie=${shelfItem.movie}"><fmt:message key="label.modify" /></a></div>
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
				    						<div class="action"><a href="/shelfManagement.html?action=add&movie=${shelfItem.movie}"><fmt:message key="label.add.shelf" /></a></div>
				    						<div class="action"><a href="/wishlistManagement.html?action=wish&movie=${shelfItem.movie}"><fmt:message key="label.add.wishlist" /></a></div>
				    					</c:when>
				    					<c:otherwise>
				    						<div class="action"> 
				    							<c:if test="${isWished == 0}"> <fmt:message key="label.present.in.shelf" /></c:if>
								    			<c:if test="${isWished == 1}"> <fmt:message key="label.present.in.wishlist" /></c:if>
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
		$('option_hint').innerHTML = "<fmt:message key='label.what.do.you.want.to.do' />";		
		return false;
	}
	function displayOtherInfo() {
		$('other_info_container').appear({ duration: 0.2 });
		$('other_info_link').innerHTML = "<fmt:message key='label.hide.other.info' />";
		$('other_info_link').onclick = hideOtherInfo;
		return false;
	}
	function hideOtherInfo() {
		$('other_info_container').fade({ duration: 0.2 });
		$('other_info_link').innerHTML = "<fmt:message key='label.see.other.info' />";
		$('other_info_link').onclick = displayOtherInfo;
		return false;
	}
	function toggleAndMove(id, title) {	
		new Effect.toggle(id, 'appear', { duration: 0.5});
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
	function orderShelfDirectorReport(orderBy, username) {
		displayElement('loader_sdr');
		ShelfManager.getShelfDirectorReport(username, null, null, orderBy, {
			callback: function(str) {
				dwr.util.removeAllOptions('directors_ul');
				for(var x=0; x<str.length; x++) {
					var li = Builder.node('li', { onclick: "filterShelf('"+username+"', '"+str[x].director+"'); return false;"});

					var person_list_info_container = Builder.node('div', { className: 'person_list_info_container' });
					var container = Builder.node('div', { className: 'container' });
					var director_image = Builder.node('img', {className: 'major', height: '30', width: '30', src: '/images/placeholder_user_48.jpg'});
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
					hideElement('loader_sdr');
				}
			},
			errorHandler:function(errorString, exception) {
				alert("Errore - Internazionalizzare" + errorString + " " + exception);
			}
		});
	}
</script>




<script>
	//////// FUNZIONI DI AGGIORNAMENTO MOVIES ////////
	function orderShelfByFilter(username) {
		var order = $('order').value;
		if(order == 1) {
			ShelfManager.getShelfByFilter(username, null, "date_viewed", "desc", function(str) {
				refreshShelf(str);
			});
		}
		if(order == 2) {
			ShelfManager.getShelfByFilter(username, null, "date_viewed", "asc", function(str) {
				refreshShelf(str);
			});
		}
		if(order == 3) {
			ShelfManager.getShelfByFilter(username, null, "mark", "desc", function(str) {
				refreshShelf(str);
			});
		}
		if(order == 4) {
			ShelfManager.getShelfByFilter(username, null, "mark", "asc", function(str) {
				refreshShelf(str);
			});
		}
	}

	function filterShelf(username, director) {
		ShelfManager.getShelfByFilter(username, director, null, null, function(str) {
			refreshShelf(str);
		});
	}

	// Aggiorna la ul
	function refreshShelf(str) {
		dwr.util.removeAllOptions('movie_list');
		for(var x=0; x<str.length; x++) {
			var displayOriginalTitle = 'n';
			
			// Costruisco l'immagine giusta
			var movie_image_li = Builder.node('li', { className: 'movie_image' });
			if(str[x].localizedImage != null) { 
				var image = Builder.node('img', { src: str[x].localizedImage });
			} else {
				var image = Builder.node('img', { src: str[x].originalImage });
			}
			movie_image_li.insert(image);

			// Costruisco le informazioni sul film
			var movie_data_li = Builder.node('li', { className: 'movie_data' });

			// Titolo
			var title_div = Builder.node('div', {className: 'title', id: 'title_'+str[x].movie });
			if(str[x].localizedTitle == null) { 
				var social_movie_link = Builder.node('a', { href: '/socialMovie.html?movie='+str[x].movie }, str[x].originalTitle);
			} else {
				var social_movie_link = Builder.node('a', { href: '/socialMovie.html?movie='+str[x].movie }, str[x].localizedTitle);
				displayOriginalTitle = 'y';
			}
			title_div.insert(social_movie_link);
			movie_data_li.insert(title_div);
			
			// Titolo originale
			if(displayOriginalTitle == 'y' && str[x].originalTitle != str[x].localizedTitle) {
				var localized_title_div = Builder.node('div', { className: 'localized_title' }, "<fmt:message key='label.original.title' />: " + str[x].originalTitle);
				movie_data_li.insert(localized_title_div);
			}

			// Regista
			var directed_by_div = Builder.node('div', { className: 'directed_by' }, 'di ');
			var directed_by_link = Builder.node('a', {href: '/directorDetail.html?director='+str[x].directorId }, str[x].director);
			directed_by_div.insert(directed_by_link);
			movie_data_li.insert(directed_by_div);
			
			// Data visto
			if(str[x].dateViewed != null) {
				var date_viewed_div = Builder.node('div', {className: 'date_viewed' }, 'Visto il: ' + formatDate(str[x].dateViewed, "${df}") );
			}
			movie_data_li.insert(date_viewed_div);
			
			// Voto
			if(str[x].mark > 0) {
				var mark_div = Builder.node('div', { className: 'mark'});
				for(var m = 0; m<str[x].mark; m++) {
					var img_mark = Builder.node('img', {src: '/images/star.gif'});
					mark_div.insert(img_mark);
				}
			}
			movie_data_li.insert(mark_div);


			//Opzioni
			var option_li = Builder.node('li', { className: 'movie_actions' });
			var action_title_div = Builder.node('div', { className: 'action action_title' }, "<fmt:message key='label.options' />");
			$(option_li).insert(action_title_div);
			
			if(str[x].originalPlot != null || str[x].localizedPlot != null) {
				var plot_action_div = Builder.node('div', { className: 'action' });
				var plot_action_link = Builder.node('a', {href: '#', onclick: "toggleAndMove(\'movie_plot_"+str[x].movie+"\', \'title_"+str[x].movie+"\'); return false;" }, 'Vedi trama' );
				plot_action_div.insert(plot_action_link);
				$(option_li).insert(plot_action_div);
			}
			if(str[x].review != null) {
				var review_action_div = Builder.node('div', { className: 'action' });
				var review_action_link = Builder.node('a', {href: '#', onclick: "toggleAndMove(\'movie_review_"+str[x].movie+"\', \'title_"+str[x].movie+"\'); return false;" }, 'Vedi recensione' );
				review_action_div.insert(review_action_link);
				$(option_li).insert(review_action_div);
			}
			<c:choose>
			    <c:when test="${empty username || username == pageContext.request.remoteUser}">
			    	var modify_action_div = Builder.node('div', { className: 'action' });
			    	var modify_action_link = Builder.node('a', {href: '/personalMovie.html?movie='+str[x].movie}, "<fmt:message key='label.modify' />");
			    	modify_action_div.insert(modify_action_link);
			    	$(option_li).insert(modify_action_div);
			    </c:when>
			    <c:when test="${not empty username && username != pageContext.request.remoteUser}">
			    	var isInPersonalMovies = 0;
			    	var isWished = 0;
			    	
			    	<c:forEach var="personalMovieId" items="${personalMoviesIdsAndWishedFlags}">
			    		if(${personalMovieId.movie} == str[x].movie) { 
			    			isInPersonalMovies = 1;
			    			<c:if test="${personalMovieId.wished == 1}">
			    				isWished = 1;
			    			</c:if>
			    		}
			    	</c:forEach>
			    	
			    	if(isInPersonalMovies == 0) {
						var add_shelf_div = Builder.node('div', { className: 'action' });
						var add_shelf_a = Builder.node('a', { href: '/shelfManagement.html?action=add&movie='+str[x].movie }, "<fmt:message key='label.add.shelf' />");
						add_shelf_div.insert(add_shelf_a);
						var add_wish_div = Builder.node('div', { className: 'action' });
						var add_wish_a = Builder.node('a', { href: '/wishlistManagement.html?action=add&movie='+str[x].movie }, "<fmt:message key='label.add.wishlist' />");
						add_wish_div.insert(add_wish_a);
						option_li.insert(add_shelf_div);
						option_li.insert(add_wish_div);
				    	
			    	} else {
				    	var presence_div = Builder.node('div', { className: 'action' });
				    	if(isWished == 0) {
					    	presence_div.innerHTML = "<fmt:message key='label.present.in.shelf' />";	
				    	} else {
				    		presence_div.innerHTML = "<fmt:message key='label.present.in.wishlist' />";	
				    	}
				    	option_li.insert(presence_div);
			    	}
			    </c:when>
		    </c:choose>

			// Trama
			var movie_plot_li = Builder.node('li', { id: 'movie_plot_'+str[x].movie, className: 'movie_plot', style: 'display:none' });
			if(str[x].localizedPlot != null) { 
				var plot_text_div = Builder.node('div', { className: 'plot_text' }, str[x].localizedPlot);
			} else {
				var plot_text_div = Builder.node('div', { className: 'plot_text' }, str[x].originalPlot);
			}
			movie_plot_li.insert(plot_text_div);

			// Recensione
			var review_li = Builder.node('li', {id: 'movie_review_'+str[x].movie, className: 'movie_review', style: 'display:none' });
			var review_div = Builder.node('div', { className: 'review_text' }, str[x].reviewText);
			review_li.insert(review_div);

			// Separatore
			var sep_li = Builder.node('li', { className: 'separator' });

			$('movie_list').insert(movie_image_li);
			$('movie_list').insert(movie_data_li);
			$('movie_list').insert(option_li);
			$('movie_list').insert(movie_plot_li);
			$('movie_list').insert(review_li);
			$('movie_list').insert(sep_li);
		}
	}
	//////// FINE FUNZIONI DI AGGIORNAMENTO PER IL REPORT DEI REGISTI ////////
</script>