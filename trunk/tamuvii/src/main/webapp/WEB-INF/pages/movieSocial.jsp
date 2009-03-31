<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="movieSocial.title"/></title>
    <meta name="heading" content="<fmt:message key='movieSocial.heading'/>"/>
    <meta name="menu" content="MainMenu"/>
</head>

id: ${movie.id}
<br/>
title: ${movie.originalTitle}
<br/>
duration: ${movie.duration}
<br/>
release date: ${movie.releaseDate}
<br/>
reviews:
${movie.review}
