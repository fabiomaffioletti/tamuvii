<%@ include file="/common/taglibs.jsp"%>

<%@ include file="/common/wishlist_menu.jsp"%>
<br/>
<c:forEach var="w" items="${wishlistItems}">
	<a href="#" onclick="getMovieItem('${w.movie.id}')">${w.movie.title}</a>
	<security:authorize ifAnyGranted="ROLE_USER">
		<c:choose>
			<c:when test="${pageContext.request.remoteUser == username}">
				<a href="#" onclick="moveToShelf('${w.movie.id}')">Sposta in shelf</a> - <a href="#" onclick="deleteUserMovie('${w.movie.id}')">Elimina</a> 
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${w.belonging == 0}">Già in shelf</c:when>
					<c:when test="${w.belonging == 1}">Già in wishlist</c:when>
					<c:otherwise>
						<a href="#" onclick="addUserMovie('${w.movie.id}', '0')">+ in shelf</a> - <a href="#" onclick="addUserMovie('${w.movie.id}', '1')">+ in wishlist</a>
					</c:otherwise>
				</c:choose>	
			</c:otherwise>
		</c:choose>
		
		<c:if test="${pageContext.request.remoteUser != username}">
			
		</c:if>
	</security:authorize>
	<br/>
	<a href="#" onclick="getMoviesByDirector('${w.movie.director}')">${w.director.name} ${w.director.surname}</a>
	<br/>
	<br/>
	<br/>
</c:forEach>

<br/>
<br/>
<br/>

ultima pagina: ${isLast}
<c:if test="${isLast != true}">
	<a href="#" onclick="getWishlistPage('${page+1}', '${filter}')">next</a>
</c:if>

<br/>
numero pagina: ${page}
<c:if test="${page - 1 != 0}">
	<a href="#" onclick="getWishlistPage('${page-1}', '${filter}')">prev</a>	
</c:if>
<br/>
totale oggetti: ${itemsCount}