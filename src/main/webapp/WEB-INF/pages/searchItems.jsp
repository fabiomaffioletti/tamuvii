<%@ include file="/common/taglibs.jsp"%>

<%@ include file="/common/search_menu.jsp"%>
<br/>
<%@ include file="/common/messages.jsp"%>
<c:forEach var="md" items="${movieItems}">
	<a href="#" onclick="getMovieItem('${md.movie.id}')">${md.movie.title}</a>
	<security:authorize ifAnyGranted="ROLE_USER">
		<c:if test="${pageContext.request.remoteUser != username}">
			<c:choose>
				<c:when test="${md.belonging == 0}">Già in shelf</c:when>
				<c:when test="${md.belonging == 1}">Già in wishlist</c:when>
				<c:otherwise>
					<a href="#" onclick="addUserMovie('${md.movie.id}', '0')">+ in shelf</a> - <a href="#" onclick="addUserMovie('${md.movie.id}', '1')">+ in wishlist</a>
				</c:otherwise>
			</c:choose>
		</c:if>
	</security:authorize>
	<br/>
	REGISTA: <a href="#" onclick="getMoviesByDirector('${md.movie.director}')">${md.director.name} ${md.director.surname}</a>
	<br/>
	VOTO MEDIO: ${md.avgMark}
	<br/>
	USERS: ${md.userCount}
	<br/>
	REVIEWS: ${md.reviewCount}
	<br/>
	<br/>
</c:forEach>

<br/>
<br/>
<br/>

ultima pagina: ${isLast}
<c:if test="${isLast != true}">
	<a href="#" onclick="getSearchPage('${page+1}', '${filter}')">next</a>
</c:if>

<br/>
numero pagina: ${page}
<c:if test="${page - 1 != 0}">
	<a href="#" onclick="getSearchPage('${page-1}', '${filter}')">prev</a>	
</c:if>
<br/>
totale oggetti: ${itemsCount}