<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="reviewDiscussion.title"/></title>
    <meta name="heading" content="<fmt:message key='reviewDiscussion.heading'/>"/>
</head>

<div id="sidebar">
	<div id="social_movie_options">
		<a href="/socialMovie.html?movie=${socialMovie.movie}">Torna alla pagina del film</a>
		<br/>
		<br/>
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
			<li class="title">${socialMovie.localizedTitle}</li>
			<li><span class="light_text_italic">Titolo originale: ${socialMovie.originalTitle}</span></li>
			<li>di <a href="/directorDetail.html?director=${socialMovie.directorId}">${socialMovie.director}</a></li>
			<li>Durata: ${socialMovie.duration} min</li>
			<li>Data di rilascio: <fmt:formatDate pattern="${df}" value="${socialMovie.releaseDate}" /></li>
		</ul>
	</div>
	<div id="social_movie_details_container">
		<div id="social_movie_details">
			<ul>
				<li>Totale recensioni: ${socialMovie.numReviews}</li>
				<li>Totale voti: ${socialMovie.numMarks}</li>
				<li>Voto medio: ${socialMovie.avgMark}</li>
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
	<div id="review_container">
		<ul>
			<li>
				<div class="review_title_container">
					<div class="review_title">
						<span class="review_title_span">${discussion.detailedReview.title}</span>		
					</div>
					<div class="vote_options_container">
						<img src="/images/emotes-ok.png"> <span id="ok_1">${discussion.detailedReview.ok}</span>
						<img src="/images/emotes-ko.png"> <span id="ko_1">${discussion.detailedReview.ko}</span>
					</div>
				</div>					
				<div class="review_text">
					${discussion.detailedReview.reviewtext}
				</div>
				<div style="margin-top: 5px;">
					<div class="person_list_info_container">
						<div class="container">
							<img src="${discussion.detailedReview.image}" width="30" height="30" class="major" />
							<img class="minor" src="/images/frame_30.png" alt="">
						</div>
						<div class="person_list_info">
							<b>${discussion.detailedReview.username}</b>, <span class="light_text_italic font11"><fmt:formatDate pattern="${df}" value="${discussion.detailedReview.dateinserted}" /></span>
							<br/>
							<c:forEach begin="1" end="${discussion.detailedReview.mark}">
								<img src="/images/star.gif" />
							</c:forEach>
						</div>
					</div>
					<div style="float: right;">
						<a href="/reviewDiscussion.html?review=${discussion.detailedReview.review}">${discussion.detailedReview.numOpinions} commenti</a>
					</div>
				</div>
			</li>
		</ul>
	</div>
	
	<div id="movie_opinions_container">
		<div class="review_title_container">
			<div class="review_title">
				<span class="review_title_span">Ecco i commenti alla review</span>		
			</div>
		</div>
		<c:forEach var="opinion" items="${discussion.detailedOpinions}">
			<ul>
				<li>
					<div class="opinion_user">
						<div class="person_list_info_container">
							<div class="container">
								<img src="${opinion.image}" width="30" height="30" class="major" />
								<img class="minor" src="/images/frame_30.png" alt="">
							</div>
							<div class="person_list_info">
								<b><a style="color: black;" href="/shelf.html?username=${opinion.username}">${opinion.username}</a></b>
								<br/>
								<span class="light_text_italic font11"><fmt:formatDate pattern="${df}" value="${opinion.dateinserted}" /></span>
							</div>
						</div>
					</div>
					<div class="opinion_text">
						${opinion.opiniontext}
					</div>
				</li>
			</ul>
		</c:forEach>
	</div>
	
</div>




<%-- 
Insert new opinion:
<form:form name="reviewDiscussionForm" commandName="opinion" method="POST">
	<input type="hidden" name="movie" value="${discussion.review.movie}" />
	<form:textarea path="opiniontext"/>
	<br/>

	<input type="submit" name="save" value="salva" />
	<input type="submit" name="cancel" value="annulla" />
</form:form>
 --%>

