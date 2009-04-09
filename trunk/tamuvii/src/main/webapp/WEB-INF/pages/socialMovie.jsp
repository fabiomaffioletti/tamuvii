<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userList.title"/></title>
    <meta name="heading" content="<fmt:message key='userList.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<display:table name="socialMovie" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="socialMovie" pagesize="25" class="table" export="true">
    <display:column property="movieId" escapeXml="true" sortable="true" titleKey="movieId" />
    <display:column property="originalTitle" escapeXml="true" sortable="true" titleKey="originalTitle" />
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="duration" />
    <display:column property="director" escapeXml="true" sortable="true" titleKey="director" />
    <display:column property="releaseDate" escapeXml="true" sortable="true" titleKey="releaseDate" />
    <display:column property="numReviews" escapeXml="true" sortable="true" titleKey="numReviews" />
</display:table>

<script type="text/javascript">
    highlightTableRows("socialMovie");
</script>