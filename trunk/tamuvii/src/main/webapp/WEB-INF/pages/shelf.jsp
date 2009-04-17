<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
    <meta name="heading" content="<fmt:message key='shelf.headingtitle'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

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
    
    <c:if test="${empty username || username == pageContext.request.remoteUser}">
	    <display:column title="modify">
	    	<a href="/personalMovie.html?movie=${shelfItems.movie}">modify</a>
	    </display:column>
    </c:if>
</display:table>

<script type="text/javascript">
    highlightTableRows("shelfItems");
</script>

