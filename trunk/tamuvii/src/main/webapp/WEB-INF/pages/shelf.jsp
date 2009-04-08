<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
    <meta name="heading" content="<fmt:message key='shelf.headingtitle'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<display:table name="shelfItems" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="shelfItems" pagesize="25" class="table" export="true">
    <display:column property="movieId" escapeXml="true" sortable="true" titleKey="movie.movie" />
    <display:column property="originalTitle" escapeXml="true" sortable="true" titleKey="movie.originaltitle" />
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="movie.duration" />
    <display:column property="director" escapeXml="true" sortable="true" titleKey="director.surname" />
    <display:column property="releaseDate" escapeXml="true" sortable="true" titleKey="movie.releasedate" />
    <display:column property="dateAdded" escapeXml="true" sortable="true" titleKey="movie.dateAdded" />
    <display:column property="dateViewed" escapeXml="true" sortable="true" titleKey="movie.dateViewed" />
    <display:column property="mark" escapeXml="true" sortable="true" titleKey="movie.mark" />
</display:table>

<script type="text/javascript">
    highlightTableRows("shelfItems");
</script>
