<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
    <meta name="heading" content="<fmt:message key='shelf.headingtitle'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<form:form name="searchSocialMovieForm" action="/searchSocialMovies.html" method="POST">
	<input type="text" name="filter" />
	<input type="submit" name="doSearch" value="Search" />
</form:form>
<br/>
<br/>

<c:choose>
	<c:when test="${not empty username && username != pageContext.request.remoteUser}">
		<c:choose>
			<c:when test="${areFriends}">
				è un tuo amico<br/>
				<a href="/relationshipManagement.html?action=moveToNeighborhoods&username=${username}">Cambia a vicino</a>
				<br/>
				<a href="/relationshipManagement.html?action=deleteFriend&username=${username}">Cancella come amico</a>
				<br/>
				<br/>
			</c:when>
			<c:when test="${areNeighborhoods}">
				è un tuo vicino<br/>
				<a href="/relationshipManagement.html?action=moveToFriends&username=${username}">Cambia a amico</a> <br/>
				<a href="/relationshipManagement.html?action=deleteNeighborhood&username=${username}">Cancella come vicino</a> <br/>
			</c:when>
			<c:otherwise>
				<a href="/relationshipManagement.html?action=addFriend&username=${username}">Aggiungi come amico</a> <br/>
				<a href="/relationshipManagement.html?action=addNeighborhood&username=${username}">Aggiungi come vicino</a> <br/>
			</c:otherwise>
		</c:choose>
		
		<a href="/relationship.html?mode=friends&username=${username}">Vedi i suoi amici</a>
		<a href="/relationship.html?mode=neighborhoods&username=${username}">Vedi i suoi vicini</a>
	</c:when>
</c:choose>


<display:table name="shelfItems" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="shelfItems" pagesize="25" class="table" export="true">
    <display:column property="movie" escapeXml="true" sortable="true" titleKey="movie.movie" />
    <display:column escapeXml="false" sortable="true" titleKey="movie.originaltitle">
    	<a href="/socialMovie.html?movie=${shelfItems.movie}">${shelfItems.originalTitle}</a>
    </display:column>
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="movie.duration" />
    <display:column escapeXml="false" sortable="true" titleKey="director.surname">
    	<a href="/directorDetail.html?director=${shelfItems.directorId}">${shelfItems.director}</a>
    </display:column>
    <display:column property="releaseDate" format="{0,date,yyyy}" escapeXml="false" sortable="true" titleKey="movie.releasedate" />
    <display:column property="dateAdded" escapeXml="true" sortable="true" titleKey="movie.dateAdded" />
    <display:column property="dateViewed" escapeXml="true" sortable="true" titleKey="movie.dateViewed" />
    <display:column property="mark" escapeXml="true" sortable="true" titleKey="movie.mark" />
    
    <c:choose>
	    <c:when test="${empty username || username == pageContext.request.remoteUser}">
		    <display:column title="modify">
		    	<a href="/personalMovie.html?movie=${shelfItems.movie}">modify</a>
		    </display:column>
	    </c:when>
	    <c:when test="${not empty username && username != pageContext.request.remoteUser}">
	    	<display:column title="actions">
	    		<c:set var="isInPersonalMovies" value="0" />
	    		<c:set var="isWished" value="0" />
		    	<c:forEach var="personalMovieId" items="${personalMoviesIdsAndWishedFlags}">
		    		<c:if test="${personalMovieId.movie == shelfItems.movie}">
		    			<c:set var="isInPersonalMovies" value="1" />
		    			<c:if test="${personalMovieId.wished == 1}">
		    				<c:set var="isWished" value="1" />
		    			</c:if>
		    		</c:if>
		    	</c:forEach>
		    	
		    	<c:choose>
			    	<c:when test="${isInPersonalMovies == 0}">
			    		<a href="/shelfManagement.html?action=add&movie=${shelfItems.movie}">add</a>
			    		<a href="/wishlistManagement.html?action=wish&movie=${shelfItems.movie}">wish</a>
			    	</c:when>
			    	<c:otherwise>
			    		Film gi&agrave; presente in
			    		<c:if test="${isWished == 0}"> libreria </c:if>
			    		<c:if test="${isWished == 1}"> wishlist </c:if>
			    	</c:otherwise>
		    	</c:choose>
		    	
	    	</display:column>
	    </c:when>
    </c:choose>
    
    
</display:table>

<script type="text/javascript">
    highlightTableRows("shelfItems");
</script>