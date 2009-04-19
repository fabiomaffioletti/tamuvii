<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="searchSocialResultMovies.pagetitle"/></title>
    <meta name="heading" content="<fmt:message key='searchSocialResultMovies.headingtitle'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

Hai cercato: ${filter}

<form:form name="searchSocialMovieForm" method="POST">
	<input type="text" name="filter" />
	<input type="submit" name="doSearch" value="Search" />
</form:form>

<display:table name="${resultSocialMovies}" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="resultMovie" pagesize="25" class="table" export="true">
    <display:column property="movie" escapeXml="true" sortable="true" titleKey="movie.movie" />
    <display:column escapeXml="false" sortable="true" titleKey="movie.originaltitle">
    	<a href="/socialMovie.html?movie=${resultMovie.movie}">${resultMovie.originalTitle}</a>
    </display:column>
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="movie.duration" />
    <display:column escapeXml="false" sortable="true" titleKey="director.surname">
    	<a href="/directorDetail.html?director=${resultMovie.directorId}">${resultMovie.director}</a>
    </display:column>
    <display:column property="releaseDate" format="{0,date,yyyy}" escapeXml="false" sortable="true" titleKey="movie.releasedate" />
    <display:column property="numReviews" escapeXml="true" sortable="true" titleKey="movie.numreviews" />
    <display:column property="avgMark" escapeXml="true" sortable="true" titleKey="movie.avgMark" />
</display:table>

<script type="text/javascript">
    highlightTableRows("resultMovie");
</script>