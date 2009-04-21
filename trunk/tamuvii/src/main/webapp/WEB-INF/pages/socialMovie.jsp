<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="socialMovie.title"/></title>
    <meta name="heading" content="<fmt:message key='socialMovie.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

Hai cercato: ${filter}

<form:form name="searchSocialMovieForm" action="/searchSocialMovies.html" method="POST">
	<input type="text" name="filter" />
	<input type="submit" name="doSearch" value="Search" />
</form:form>
<br/>
<br/>

<c:choose>
	<c:when test="${!presentInShelf && !presentInWishlist}">
		<a href="/shelfManagement.html?action=add&movie=${socialMovie.movie}">Add to shelf</a>
		<a href="/shelfManagement.html?action=wish&movie=${socialMovie.movie}">Add to wishlist</a>
	</c:when>
	<c:when test="${!presentInShelf && presentInWishlist}">
		Questo libro è presente nella tua wishlist:
		<a href="/shelfManagement.html?move=add&movie=${socialMovie.movie}">Move to shelf</a>
	</c:when>
	<c:otherwise>
		Questo libro è presente nella tua shelf!
	</c:otherwise>
</c:choose>

<br/>
<br/>
MovieId: ${socialMovie.movie}
<br/>
OriginalTitle: ${socialMovie.originalTitle}
<br/>
Duration: ${socialMovie.duration} min
<br/>
Director: <a href="/directorDetail.html?director=${socialMovie.directorId}">${socialMovie.director}</a>
<br/>
Release date: ${socialMovie.releaseDate}
<br/>
Num. Reviews: ${socialMovie.numReviews}
<br/>
Avg Mark: ${socialMovie.avgMark}
<br/>

<br/>
<br/>

Reviews:
<br/>
<display:table name="${socialMovie.detailedReviews}" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="review" pagesize="25" class="table" export="false">
	<display:column property="review" escapeXml="true" sortable="true" titleKey="review" />
	<display:column property="title" escapeXml="true" sortable="true" titleKey="title" />
	<display:column property="reviewtext" escapeXml="true" sortable="true" titleKey="text" />
	<display:column escapeXml="false" sortable="true" titleKey="username">
		<a href="/shelf.html?username=${review.username}">${review.username}</a>
	</display:column>
	<display:column property="dateinserted" escapeXml="true" sortable="true" titleKey="dateinserted" />
	<display:column escapeXml="false" sortable="false" title="actions">
		<a href="/reviewDiscussion.html?review=${review.review}">${review.numOpinions}</a>
	</display:column>
</display:table>

<br/>
Totale Users:
<c:out value="${fn:length(socialMovie.movieUsers)}" />

<display:table name="${socialMovie.movieUsers}" cellspacing="0" cellpadding="0" id="movieUser" pagesize="25" class="table" export="false">
	<display:column property="movieUser" escapeXml="true" sortable="true" titleKey="id" />
	<display:column escapeXml="false" sortable="false" titleKey="immagine">
		<img src="/images/placeholder_user.jpg" height="20px" width="20px;"/>
	</display:column>
	<display:column escapeXml="false" sortable="true" titleKey="username">
		<a href="/shelf.html?username=${movieUser.username}">${movieUser.username}</a>
	</display:column>
	<display:column property="mark" escapeXml="true" sortable="true" titleKey="mark" />
</display:table>

<script type="text/javascript">
    highlightTableRows("review");
</script>