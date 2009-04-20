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
	    		<c:set var="found" value="0" />
		    	<c:forEach var="personalMovieId" items="${personalMoviesIds}">
		    		<c:if test="${personalMovieId == shelfItems.movie}">
		    			<c:set var="found" value="1" />
		    		</c:if>
		    	</c:forEach>
		    	<c:if test="${found == 0}">
		    		<a href="/shelfManagement.html?action=add&movie=${shelfItems.movie}">add</a>
		    	</c:if>
	    	</display:column>
	    </c:when>
    </c:choose>
    
    
</display:table>

<script type="text/javascript">
    highlightTableRows("shelfItems");
</script>