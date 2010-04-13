<%@ include file="/common/taglibs.jsp"%>

<a href="#" onclick="getMovieItem('${reviewItem.review.movie}')">Torna al film</a>
<br/><br/>
<%@ include file="/common/messages.jsp"%>

TITOLO: ${reviewItem.review.title}
<br/>
TESTO: ${reviewItem.review.text}
<br/>
POSITIVI: ${reviewItem.review.positive}
<br/>
NEGATIVI: ${reviewItem.review.negative}
<br/>
DATA: ${reviewItem.review.dateAdded}
<br/>
OPINIONI COUNT: ${reviewItem.opinionCount}
<br/>
REVIEWER: <a href="/${reviewItem.userInfo.username}/movies/">${reviewItem.userInfo.username}</a>
<br/><br/>
<c:forEach var="o" items="${reviewItem.opinions}">
	${o}<br/>
</c:forEach>

<security:authorize ifAnyGranted="ROLE_USER">
	<form id="new_opinion_form">
		<textarea name="opinion_text" id="opinion_text"></textarea>
		<input type="button" onclick="writeOpinion('${reviewItem.review.movie}', '${reviewItem.review.user}')" value="Ok" />
	</form>
</security:authorize>