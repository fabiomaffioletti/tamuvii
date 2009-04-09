<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="be_movieslist.pagetitle"/></title>
    <meta name="heading" content="<fmt:message key='be_movieslist.headingtitle'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<display:table name="movies" cellspacing="0" cellpadding="0" requestURI="" id="movies" pagesize="25" class="table" export="true">
    <display:column property="movie" escapeXml="true" sortable="true" titleKey="movie.movie" />
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="movie.duration" />
    <display:column property="originaltitle" escapeXml="true" sortable="true" titleKey="movie.originaltitle" />
    <display:column property="director" escapeXml="true" sortable="true" titleKey="movie.director" />
    <display:column property="releasedate" format="{0,date,yyyy}" escapeXml="false" sortable="true" titleKey="movie.releasedate" />
</display:table>

<script type="text/javascript">
    highlightTableRows("movies");
</script>
