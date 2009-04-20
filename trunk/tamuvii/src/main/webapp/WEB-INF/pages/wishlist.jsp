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

<display:table name="wishedItems" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="wishedItems" pagesize="25" class="table" export="true">
    <display:column property="movie" escapeXml="true" sortable="true" titleKey="movie.movie" />
    <display:column escapeXml="false" sortable="true" titleKey="movie.originaltitle">
    	<a href="/socialMovie.html?movie=${wishedItems.movie}">${wishedItems.originalTitle}</a>
    </display:column>
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="movie.duration" />
    <display:column escapeXml="false" sortable="true" titleKey="director.surname">
    	<a href="/directorDetail.html?director=${wishedItems.directorId}">${wishedItems.director}</a>
    </display:column>
    <display:column property="releaseDate" format="{0,date,yyyy}" escapeXml="false" sortable="true" titleKey="movie.releasedate" />
    <display:column property="dateAdded" escapeXml="true" sortable="true" titleKey="movie.dateAdded" />
    <display:column titleKey="actions">
    	<a href="#">move_to_shelf(da implementare)</a>
    	<a href="#">delete_from_wishlist(da implementare)</a>
    </display:column>
</display:table>

<script type="text/javascript">
    highlightTableRows("wishedItems");
</script>