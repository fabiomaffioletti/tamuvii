<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="wishlist.pagetitle"/></title>
    <meta name="heading" content="<fmt:message key='wishlist.headingtitle'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<form:form name="searchSocialMovieForm" action="/searchSocialMovies.html" method="POST">
	<input type="text" name="filter" />
	<input type="submit" name="doSearch" value="Search" />
</form:form>
<br/>
<br/>

<display:table name="wishedItems" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="wishedItem" pagesize="25" class="table" export="true">
    <display:column property="movie" escapeXml="true" sortable="true" titleKey="movie.movie" />
    <display:column escapeXml="false" sortable="true" titleKey="movie.originaltitle">
    	<a href="/socialMovie.html?movie=${wishedItem.movie}">${wishedItem.originalTitle}</a>
    </display:column>
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="movie.duration" />
    <display:column escapeXml="false" sortable="true" titleKey="director.surname">
    	<a href="/directorDetail.html?director=${wishedItem.directorId}">${wishedItem.director}</a>
    </display:column>
    <display:column property="releaseDate" format="{0,date,yyyy}" escapeXml="false" sortable="true" titleKey="movie.releasedate" />
    <display:column property="dateAdded" escapeXml="true" sortable="true" titleKey="movie.dateAdded" />
    <display:column titleKey="actions">
    	<a href="/wishlistManagement.html?action=move&movie=${wishedItem.movie}">Move to shelf</a>
    	<a href="/wishlistManagement.html?action=delete&movie=${wishedItem.movie}">Delete from wishlist</a>
    </display:column>
</display:table>