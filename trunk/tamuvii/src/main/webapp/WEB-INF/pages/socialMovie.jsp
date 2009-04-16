<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userList.title"/></title>
    <meta name="heading" content="<fmt:message key='userList.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<display:table name="socialMovie" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="socialMovie" pagesize="25" class="table" export="true">
    <display:column property="movie" escapeXml="true" sortable="true" titleKey="movie" />
    <display:column property="originalTitle" escapeXml="true" sortable="true" titleKey="originalTitle" />
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="duration" />
    <display:column escapeXml="false" sortable="true" titleKey="director">
    	<a href="/directorDetail.html?director=${socialMovie.directorId}">${socialMovie.director}</a>
    </display:column>
    <display:column property="releaseDate" escapeXml="true" sortable="true" titleKey="releaseDate" />
    <display:column escapeXml="false" sortable="true" titleKey="numReviews">
    	<a href="/reviewDiscussion.html?movie=${socialMovie.movie}">${socialMovie.numReviews}</a>
    </display:column>
    <display:column property="avgMark" escapeXml="true" sortable="true" titleKey="avgMark" />
</display:table>

<script type="text/javascript">
    highlightTableRows("socialMovie");
</script>