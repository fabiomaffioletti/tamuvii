<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="movieSocial.title"/></title>
    <meta name="heading" content="<fmt:message key='movieSocial.heading'/>"/>
    <meta name="menu" content="MainMenu"/>
</head>

<b>Dati sul film:</b>
<br/>
id: ${movie.id}
<br/>
title: ${movie.originalTitle}
<br/>
duration: ${movie.duration}
<br/>
release date: ${movie.releaseDate}
<br/>
<br/>
<b>Reviews:</b>
<br/>
<display:table name="${movie.review}" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="review" pagesize="25" class="table" export="false">
	<display:column property="title" sortable="true" titleKey="title" />
	<display:column property="reviewText" sortable="true" titleKey="text" />
	<display:column property="user.username" sortable="true" titleKey="user" />
</display:table>