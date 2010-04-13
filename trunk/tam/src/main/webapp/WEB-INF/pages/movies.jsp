<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="movies.title" /></title>
</head>

<h2><fmt:message key="movies.title" /></h2>

<%@ include file="/common/messages.jsp"%>

<form name="search_movies" action="/movies.html" method="get">
	Cerca: <input type="text" name="filter" />
	<input type="submit" value="Cerca" />
</form>

<display:table name="movieList" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" class="table" id="m" pagesize="10" export="true">
	 <display:column property="id" escapeXml="true" sortable="true" titleKey="ID" />
	 <display:column escapeXml="false" sortable="true" titleKey="Immagine">
	 	<img src="/movie_images/t/${m.image}" />
	 </display:column>
	 <display:column property="title" escapeXml="true" sortable="true" titleKey="Titolo" url="/movieForm.html?from=list" paramId="id" paramProperty="id"/>
	 <display:column escapeXml="true" sortable="true" titleKey="Trama">
	 	${m.plot}
	 </display:column>
	 <display:column property="duration" escapeXml="true" sortable="true" titleKey="Durata" />
	 <display:column property="year" escapeXml="true" sortable="true" titleKey="Anno" />
	 <display:column property="director" escapeXml="true" sortable="true" titleKey="Regista" />
	 
	 <display:setProperty name="export.excel.filename" value="movies.xls" />
	 <display:setProperty name="export.pdf.filename" value="movies.pdf" />
</display:table>