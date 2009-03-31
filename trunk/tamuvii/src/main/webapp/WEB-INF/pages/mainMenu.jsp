<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mainMenu.title"/></title>
    <meta name="heading" content="<fmt:message key='mainMenu.heading'/>"/>
    <meta name="menu" content="MainMenu"/>
</head>

Cerca un film:
<form:form name="searchMovieForm" action="/searchMovie.html">
	<input type="text" name="filter" id="filter" />
	<input type="submit" name="doSearch" id="doSearch" value="Cerca" />
</form:form>