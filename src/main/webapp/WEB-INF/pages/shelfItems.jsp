<%@ include file="/common/taglibs.jsp"%>

<%@ include file="/common/shelf_menu.jsp"%>
<br/>
<%@ include file="/common/messages.jsp"%>
<c:forEach var="s" items="${shelfItems}">
	<a href="#" onclick="getMovieItem('${s.movie.id}')">${s.movie.title}</a>
	<security:authorize ifAnyGranted="ROLE_USER">
		<c:choose>
			<c:when test="${pageContext.request.remoteUser != username}">
				<c:choose>
					<c:when test="${s.belonging == 0}">Già in shelf <a href="#" onclick="getUserMovieItem('${s.movie.id}')">Modifica</a></c:when>
					<c:when test="${s.belonging == 1}">Già in wishlist</c:when>
					<c:otherwise>
						<a href="#" onclick="addUserMovie('${s.movie.id}', '0')">+ in shelf</a> - <a href="#" onclick="addUserMovie('${s.movie.id}', '1')">+ in wishlist</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:when test="${pageContext.request.remoteUser == username}">
				<a href="#" onclick="getUserMovieItem('${s.movie.id}')">Modifica</a>
			</c:when>
		</c:choose>
	</security:authorize>
	<br/>
	<a href="#" onclick="getMoviesByDirector('${s.movie.director}')">${s.director.name} ${s.director.surname}</a>
	<br/>
	DATA VISTO: <fmt:formatDate value="${s.userMovie.dateViewed}" pattern="dd/MM/yyyy" />
	<br/>
	VOTO: ${s.userMovie.mark}
	<br/>
	<c:if test="${not empty s.review}">
		<a href="#">Vedi review</a>
	</c:if>
	<br/>
	<br/>
	<br/>
</c:forEach>

<br/>
<br/>
<br/>

ultima pagina: ${isLast}
<c:if test="${isLast != true}">
	<a href="#" onclick="getShelfPage('${page+1}', '${filter}')">next</a>
</c:if>

<br/>
numero pagina: ${page}
<c:if test="${page - 1  != 0}">
	<a href="#" onclick="getShelfPage('${page-1}', '${filter}')">prev</a>	
</c:if>
<br/>
totale oggetti: ${itemsCount}