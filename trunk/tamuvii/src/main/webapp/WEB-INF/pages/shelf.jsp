<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.title"/></title>
    <meta name="heading" content="<fmt:message key='shelf'/>"/>
    <meta name="menu" content="Shelf"/>
</head>

<display:table name="myMovies" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="myMovies" pagesize="25" class="table" export="true">
    <display:column property="id" sortable="true" titleKey="id" media="html" />
    <display:column escapeXml="false" sortable="true" titleKey="title" >
    	<a href="/movie.html?action=details&movieId=${myMovies.id}">${myMovies.originalTitle}</a>
    </display:column>
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="duration" />
    <display:column property="releaseDate" sortable="true" titleKey="release_date"/>
    <display:column titleKey="actions">
    	<a href="/movie.html?action=modify&movieId=${myMovies.id}">modify</a>
    	<a href="/movie.html?action=delete&movieId=${myMovies.id}">delete</a>
    </display:column>
</display:table>

<script type="text/javascript">
    highlightTableRows("myMovies");
</script>