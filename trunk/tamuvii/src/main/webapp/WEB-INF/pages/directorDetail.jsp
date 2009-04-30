<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="directorDetail.pagetitle"/></title>
    <meta name="heading" content="<fmt:message key='directorDetail.headingtitle'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

${directorDetail.director.name} ${directorDetail.director.surname}

<display:table name="${directorDetail.movies}" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="directorMovie" pagesize="25" class="table" export="true">
    <display:column property="movie" escapeXml="true" sortable="true" titleKey="movie.movie" />
    <display:column escapeXml="false" sortable="true" titleKey="movie.originaltitle">
    	<a href="/socialMovie.html?movie=${directorMovie.movie}">${directorMovie.originaltitle}</a>
    </display:column>
</display:table>