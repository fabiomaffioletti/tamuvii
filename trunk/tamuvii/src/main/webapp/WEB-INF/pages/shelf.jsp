<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userList.title"/></title>
    <meta name="heading" content="<fmt:message key='userList.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<display:table name="shelfItems" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="shelfItems" pagesize="25" class="table" export="true">
    <display:column property="movieId" escapeXml="true" sortable="true" titleKey="movieId" />
    <display:column property="originalTitle" escapeXml="true" sortable="true" titleKey="originalTitle" />
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="duration" />
    <display:column property="director" escapeXml="true" sortable="true" titleKey="director" />
    <display:column property="releaseDate" escapeXml="true" sortable="true" titleKey="releaseDate" />
    <display:column property="dateAdded" escapeXml="true" sortable="true" titleKey="dateAdded" />
    <display:column property="dateViewed" escapeXml="true" sortable="true" titleKey="dateViewed" />
    <display:column property="mark" escapeXml="true" sortable="true" titleKey="mark" />
</display:table>

<script type="text/javascript">
    highlightTableRows("shelfItems");
</script>
