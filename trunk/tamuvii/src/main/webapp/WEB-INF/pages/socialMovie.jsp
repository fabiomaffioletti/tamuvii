<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="socialMovie.title"/></title>
</head>

<div id="sidebar">
	<div id="social_movie_options">
		<c:choose>
			<c:when test="${!presentInShelf && !presentInWishlist}">
				<span class="bold_text">Non hai questo film, se vuoi puoi:</span>
				<ul id="social_movie_options_list">
					<li><a href="/shelfManagement.html?action=add&movie=${socialMovie.movie}">Aggiungerlo alla tua videoteca</a></li>
					<li><span class="light_text_italic">oppure</span></li>
					<li><a href="/wishlistManagement.html?action=wish&movie=${socialMovie.movie}">Aggiungerlo alla tua wishlist</a></li>
				</ul>
			</c:when>
			<c:when test="${!presentInShelf && presentInWishlist}">
				<span class="bold_text">Questo film è nella tua wishlist, puoi:</span>
				<ul id="social_movie_options_list">
					<li><a href="/shelfManagement.html?action=move&movie=${socialMovie.movie}">Spostarlo nella tua videoteca</a></li>
					<li><span class="light_text_italic">oppure</span></li>
					<li><a href="/shelfManagement.html?action=delete&movie=${socialMovie.movie}">Eliminarlo dalla tua wishlist (verificare!)</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<span class="bold_text">Questo film è nella tua videoteca</span>
				<ul id="social_movie_options_list">
					<li><a href="/shelfManagement.html?action=delete&movie=${socialMovie.movie}">Eliminalo</a></li>
					<li><span class="light_text_italic">oppure</span></li>
					<li><a href="/personalMovie.html?movie=${socialMovie.movie}">Modifica la scheda</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
	
		

	<div id="movie_details">
		<ul>
			<li>
				<c:choose>
					<c:when test="${not empty socialMovie.localizedImage}">
						<img class="movie_details_image" src="${socialMovie.localizedImage}" />
					</c:when>
					<c:otherwise>
						<img class="movie_details_image" src="${socialMovie.originalImage}" />
					</c:otherwise>
				</c:choose>
			</li>
			<li class="title">
				<c:choose>
					<c:when test="${not empty socialMovie.localizedTitle}">
						${socialMovie.localizedTitle}
					</c:when>
					<c:otherwise>
						${socialMovie.originalTitle}
					</c:otherwise>
				</c:choose>
			</li>
			<li><span class="light_text_italic font12">Titolo originale: ${socialMovie.originalTitle}</span></li>
			<li>di <a href="/directorDetail.html?director=${socialMovie.directorId}">${socialMovie.director}</a></li>
			<li>
				<c:choose>
					<c:when test="${not empty socialMovie.localizedCountry}">
						Paese: ${socialMovie.localizedCountry}
					</c:when>
					<c:otherwise>
						Paese: ${socialMovie.originalCountry}					
					</c:otherwise>
				</c:choose>
			</li>
			<li>Durata: ${socialMovie.duration} min</li>
			<li>Anno: <fmt:formatDate pattern="yyyy" value="${socialMovie.releaseDate}" /></li>
		</ul>
	</div>
	<div id="social_movie_details_container">
		<div id="social_movie_details">
			<ul>
				<li>Totale recensioni: ${socialMovie.numReviews}</li>
				<li>Totale voti: ${socialMovie.numMarks}</li>
				<li>Voto medio: ${socialMovie.avgMark}</li>
				<li><span class="light_text_italic">Totale utenti: ${socialMovie.numUsers}</span></li>
			</ul>
		</div>
	</div>
	
	<div id="movie_users">
		<div class="relationship_title">
			<div style="float:left">Utenti</div>
			<div style="float:right"><span id="movie_users_view_all" style="display:none;">vedi tutti </span><a href="#" onmouseover="displayElement('movie_users_view_all')" onmouseout="hideElement('movie_users_view_all')">(${fn:length(socialMovie.movieUsers)})</a></div>
		</div>
		<div id="movie_users_list_container">
			<div id="movie_users_list_content">
				<ul class="person_list">
					<c:forEach var="movieUser" items="${socialMovie.movieUsers}">
						<li onclick="document.location.href='/shelf.html?username=${movieUser.username}'">
							<div class="person_list_info_container">
								<div class="container">
									<img src="${movieUser.imageLink}" width="30" height="30" class="major" />
									<img class="minor" src="/images/frame_30.png" alt="">
								</div>
								<div class="person_list_info">
									<b>${movieUser.username}</b>
									<br/>
									<c:if test="${movieUser.mark > 0}">
										<span class="first_mark_image">
									    	<c:forEach begin="1" end="${movieUser.mark}">
												<img src="/images/star.gif"/>	    		
									    	</c:forEach>
								    	</span>
							    	</c:if>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="relationship_navigation" style="width:100%;">
			<a href="#" id="upMovieUsers" style="display:none;float:left;" onclick="indexMovieUsers = doup(indexMovieUsers, 1, 'movie_users_list_content', $('movie_users_list_container').getHeight(), 'downMovieUsers', 'upMovieUsers'); return false;"><img class="relationship_navigation_image" src="/images/bw.png"/></a>
			<div style="float:left; margin-left: 47px;">
				<span class="light_text_italic font12">Ordina: </span>
				<select>
					<option value="1">A-Z</option>
					<option value="2"># Film</option>
				</select>
			</div>
			<a href="#" id="downMovieUsers" style="float:right;display:none;" onclick="indexMovieUsers = dodown(indexMovieUsers, pagesMovieUsers, 1, 'movie_users_list_content', $('movie_users_list_container').getHeight(), 'downMovieUsers', 'upMovieUsers'); return false;"><img class="relationship_navigation_image" src="/images/ff.png"/></a>
		</div>
	</div>
</div>


<div id="main">
	<div style="margin-bottom: 30px;">
		<c:choose>
			<c:when test="${not empty socialMovie.localizedTrailer}">
				<video id="v1" width="100%" src="${socialMovie.localizedTrailer}" controls />
			</c:when>
			<c:otherwise>
				<video id="v1" width="100%" src="${socialMovie.originalTrailer}" controls />
			</c:otherwise>
		</c:choose>
	</div>
	
	<div id="review_container">
		<ul>
			<c:forEach var="review" items="${socialMovie.detailedReviews}">
				<li>
					<div class="review_title_container">
						<div class="review_title">
							<span class="review_title_span">${review.title}</span>		
						</div>
						<div class="vote_options_container">
							<img src="/images/emotes-ok.png" onclick="voteOk('${review.review}')"> <span id="ok_${review.review}">${review.ok} </span>
							<img src="/images/emotes-ko.png" onclick="voteKo('${review.review}')"> <span id="ko_${review.review}">${review.ko} </span>
						</div>
					</div>
					<div class="vote_error_message_container">
						<div id="message_${review.review}" class="vote_error_message" style="display:none;">
						</div>
					</div>
					<div class="review_text">
						${review.reviewtext}
					</div>
					<div style="margin-top: 5px;">
						<div class="person_list_info_container">
							<div class="container">
								<img src="${review.image}" width="30" height="30" class="major" />
								<img class="minor" src="/images/frame_30.png" alt="">
							</div>
							<div class="person_list_info" id="abc">
								<b><a style="color:black;" href="/shelf.html?username=${review.username}">${review.username}</a></b>, <span class="light_text_italic font11"><fmt:formatDate pattern="${df}" value="${review.dateinserted}" /></span>
								<br/>
								<c:if test="${review.mark > 0}">
									<span class="first_mark_image">
								    	<c:forEach begin="1" end="${review.mark}">
											<img src="/images/star.gif"/>	    		
								    	</c:forEach>
							    	</span>
						    	</c:if>
							</div>
						</div>
						<div style="float: right;">
							<a href="/reviewDiscussion.html?review=${review.review}">Vedi tutti i commenti (${review.numOpinions})</a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>


<script>
	function voteOk(review) {
		new Ajax.Request('/voteReview.html?ajax=true&type=ok&review='+review, {
			  method: 'post',
			  onSuccess: function(response) {
			  if(response.responseText == -1) {
				var message = $('message_'+review);
				message.innerHTML = "<img src='/images/error.png' style='margin-right:10px' /><fmt:message key='user.review.already.voted' />";
				$(message).appear();
				new Effect.Highlight(message, {startcolor: '#FFB98C', restorecolor: true});
				
			  } else if(response.responseText == -2) {
				var message = $('message_'+review);
				message.innerHTML = "<img src='/images/error.png' style='margin-right:10px' /><fmt:message key='user.review.vote.own' />";
				$(message).appear();
				new Effect.Highlight(message, {startcolor: '#FFB98C', restorecolor: true});
			  } else {
			    var oks = $('ok_'+review);
			    oks.innerHTML = response.responseText;
			  }
			}
		});
	}

	function voteKo(review) {
		new Ajax.Request('/voteReview.html?ajax=true&type=ko&review='+review, {
			  method: 'post',
			  onSuccess: function(response) {
			  if(response.responseText == -1) {
				var message = $('message_'+review);
				message.innerHTML = "<img src='/images/error.png' style='margin-right:10px' /><fmt:message key='user.review.already.voted' />";
				$(message).appear();
				new Effect.Highlight(message, {startcolor: '#FFB98C', restorecolor: true});
				
			  } else if(response.responseText == -2) {
				var message = $('message_'+review);
				message.innerHTML = "<img src='/images/error.png' style='margin-right:10px' /><fmt:message key='user.review.vote.own' />";
				$(message).appear();
				new Effect.Highlight(message, {startcolor: '#FFB98C', restorecolor: true});
				
			  } else {
			    var kos = $('ko_'+review);
			    kos.innerHTML = response.responseText;
			  }
			}
		});
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
</script>

<script>
	var indexMovieUsers;
	var totMovieUsers;
	var recordsPerRowMovieUsers; 
	var pagesMovieUsers;
	var heightMovieUsers;
	
	Event.observe(window, 'load', function(event) {
		indexMovieUsers = 0;
		totMovieUsers = ${fn:length(socialMovie.movieUsers)};
		recordsPerPageMovieUsers = 5;
		pagesMovieUsers = Math.ceil(totMovieUsers/recordsPerPageMovieUsers);
		
		if(totMovieUsers < recordsPerPageMovieUsers) {
			$('movie_users_list_container').setStyle({
				height: (totMovieUsers*35 + totMovieUsers*5 + totMovieUsers*1) + "px"
			});
		} else {
			$('movie_users_list_container').setStyle({
				height: (recordsPerPageMovieUsers*35 + recordsPerPageMovieUsers*5 + recordsPerPageMovieUsers*1) + "px"
			});
		}
		
		if(pagesMovieUsers > 1) {
    		$('downMovieUsers').setStyle({ display: 'block' });
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