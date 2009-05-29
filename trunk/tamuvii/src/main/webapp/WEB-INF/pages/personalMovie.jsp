<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userList.title"/></title>
</head>

<div id="sx">
<center>
	<c:choose>
		<c:when test="${not empty personalMovie.localizedImage}">
			<img src="${personalMovie.localizedImage}" width="150px;" style="border: 1px dotted #ccc;">
		</c:when>
		<c:otherwise>
			<img src="${personalMovie.originalImage}" width="150px;">		
		</c:otherwise>
	</c:choose>
</center>
Localized Title: ${personalMovie.localizedTitle}
<br/>
Original Title: ${personalMovie.originalTitle}
<br/>
Duration: ${personalMovie.duration} min
<br/>
Director: <a href="/directorDetail.html?director=${personalMovie.directorId}">${personalMovie.director}</a>
<br/>
Release date: ${personalMovie.releaseDate}


</div>

<div id="cont">
	<div id="searchBar">
		<form:form name="searchpersonalMovieForm" action="/searchSocialMovies.html" method="POST">
			<input type="text" name="filter" />
			<input type="submit" name="doSearch" value="Search" />
		</form:form>
		<br/>
	</div>
	
	<form:form name="personalMovieForm" commandName="personalMovie" method="POST">
	
		voto: 	<form:select path="mark">
					<form:option value="0">0</form:option>
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
				</form:select> 
		<br/>
		
		review title: <form:input path="review.title"/>
		<br/>
		
		review text: <form:input path="review.reviewtext"/>
		<br/>

		anno: <br/> Occhio che questa cosa non funziona ancora...	
		<select name="year_viewed">
			<c:forEach var="year" items="${years}">
				<c:choose>
					<c:when test="${fn:substring(dateViewed,0,fn:indexOf(dateViewed, '-'))}">
						<option value="${year}" selected="selected">${year}</option>				
					</c:when>
					<c:otherwise>
						<option value="${year}">${year}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		
		
		<br/><br/><br/>
		<input type="submit" name="update" value="salva" />
		<input type="submit" name="cancel" value="annulla" />
		<input type="submit" name="delete" value="elimina" />
		
	</form:form>
</div>

