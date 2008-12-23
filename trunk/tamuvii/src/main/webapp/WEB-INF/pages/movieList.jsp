<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userList.title"/></title>
    <meta name="heading" content="<fmt:message key='userList.heading'/>"/>
    <meta name="menu" content="MovieMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/userform.html?method=Add&from=list"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="movies" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="movies" pagesize="25" class="table" export="true">
    <display:column property="director.surname" escapeXml="true" sortable="true" titleKey="user.username" style="width: 25%"
        url="/userform.html?from=list" paramId="id" paramProperty="id"/>
    <display:column property="duration" escapeXml="true" sortable="true" titleKey="activeUsers.fullName" style="width: 34%"/>
    <display:column property="plot" sortable="true" titleKey="user.email" style="width: 25%" autolink="true" media="html"/>
    <display:column property="date" titleKey="user.email" media="csv xml excel pdf"/>

    <display:column property="enabled" titleKey="user.enabled" media="csv xml excel pdf"/>

    <display:setProperty name="paging.banner.item_name" value="user"/>
    <display:setProperty name="paging.banner.items_name" value="users"/>

    <display:setProperty name="export.excel.filename" value="User List.xls"/>
    <display:setProperty name="export.csv.filename" value="User List.csv"/>
    <display:setProperty name="export.pdf.filename" value="User List.pdf"/>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("movies");
</script>
