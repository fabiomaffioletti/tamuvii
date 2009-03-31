<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="movieList.title"/></title>
    <meta name="heading" content="<fmt:message key='movieList'/>"/>
    <meta name="menu" content="MovieMenu"/>
</head>

<display:table name="movieList" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="movieList" pagesize="25" class="table" export="true">
    <display:column property="id" sortable="true" titleKey="id" media="html"/>
    <display:column property="originalTitle" escapeXml="true" sortable="true" titleKey="title" url="/movie.html?action=details&movieId=${movieList.id}" />
    <display:column property="director.surname" escapeXml="true" sortable="true" titleKey="director" />
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="duration" />
    <display:column property="releaseDate" sortable="true" titleKey="release_date"/>
    <display:column titleKey="actions">
    	<a href="/movie.html?action=add&movieId=${movieList.id}">add</a>
    </display:column>
</display:table>

<script type="text/javascript">
    highlightTableRows("movieList");
</script>