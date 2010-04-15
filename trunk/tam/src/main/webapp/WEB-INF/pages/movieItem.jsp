<%@ include file="/common/taglibs.jsp"%>

<%@ include file="/common/messages.jsp"%>
<security:authorize ifAnyGranted="ROLE_USER">
	<c:choose>
		<c:when test="${movieItem.belonging == 0}">Già in shelf - <a href="#" onclick="deleteUserMovie('${movieItem.movie.id}')">Elimina dalla shelf</a> - <a href="#" onclick="getUserMovieItem('${movieItem.movie.id}')">Modifica</a></c:when>
		<c:when test="${movieItem.belonging == 1}">Già in wishlist - <a href="#" onclick="deleteUserMovie('${movieItem.movie.id}')">Elimina dalla wishlist</a></c:when>
		<c:otherwise>
			<a href="#" onclick="addUserMovie('${movieItem.movie.id}', '0')">+ in shelf</a> - <a href="#" onclick="addUserMovie('${movieItem.movie.id}', '1')">+ in wishlist</a>
		</c:otherwise>
	</c:choose>
</security:authorize>
<br/><br/>
ID: ${movieItem.movie.id}
<br/>
TITOLO: ${movieItem.movie.title}
<br/>
GENERI:
<c:forEach var="g" items="${movieItem.movie.genres}">
	${g}
	<br/>
</c:forEach>
<br/>
TRAMA: ${movieItem.movie.plot}
<br/>
DURATA: ${movieItem.movie.duration}
<br/>
ANNO: ${movieItem.movie.year}
<br/>
REGISTA: <a href="#" onclick="getMoviesByDirector('${movieItem.movie.director}')" >${movieItem.director.name} ${movieItem.director.surname}</a>
<br/>
VOTO MEDIO: ${movieItem.avgMark}
<br/>
USERS: ${movieItem.userCount}
<br/>
REVIEWS: ${movieItem.reviewCount}
<br/>
MARKS:
<br/>
5: ${movieItem.marks['5'].numMarks}
<br/>
4: ${movieItem.marks['4'].numMarks}
<br/>
3: ${movieItem.marks['3'].numMarks}
<br/>
2: ${movieItem.marks['2'].numMarks}
<br/>
1: ${movieItem.marks['1'].numMarks}
<br/>
<br/>
<br/>
<br/>
USERS HAVING THIS MOVIE: <a href="#" onclick="getUserMovieUsers('${movieItem.movie.id}')">${movieItem.usersCount}</a> 
<br/>
<security:authorize ifAnyGranted="ROLE_USER">
	FRIENDS HAVING THIS MOVIE: <a href="#" onclick="getUserMovieFriends('${movieItem.movie.id}')">${movieItem.friendsCount}</a>
	<br/>
	NEARBIES HAVING THIS MOVIE: <a href="#" onclick="getUserMovieNearbies('${movieItem.movie.id}')">${movieItem.nearbiesCount}</a>
</security:authorize>
<div id="movie_users_container">
	<c:forEach var="u" items="${movieItem.users}">
		${u} - <a href="/${u.username}/movies/">${u.username}</a><br/>
	</c:forEach>
</div>
<br/><br/>
REVIEWS:<br/>
<c:forEach var="r" items="${movieItem.reviews}">
	<a href="#" onclick="getReviewItem('${r.review.movie}', '${r.userInfo.username}')">${r}</a> - Positivi: ${r.review.positive} - Negativi: ${r.review.negative} - Opinioni: ${r.opinionCount} 
	<security:authorize ifAnyGranted="ROLE_USER">
		<c:if test="${pageContext.request.remoteUser != r.userInfo.username}">
			<a href="#" onclick="addPositive('${r.review.movie}', '${r.userInfo.username}')">Mi piace</a> - <a href="#" onclick="addNegative('${r.review.movie}', '${r.userInfo.username}')">Non mi piace</a>
		</c:if>
	</security:authorize>
	<br/>
</c:forEach>