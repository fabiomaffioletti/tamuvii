<%@ include file="/common/taglibs.jsp"%>

<%@ include file="/common/messages.jsp"%>

${userMovieItem.movie.title}
<br/>
<br/>
<input type="text" name="date_viewed" id="date_viewed" value="<fmt:formatDate value="${userMovieItem.userMovie.dateViewed}" pattern='dd/MM/yyyy'/>" />
<img id="calendar_trigger" style="margin-left: 200px;" src="/images/info.png" />
<div id="calendar_container"></div>
<br/>
<br/>
Voto:
<select id="mark_select" name="mark_select">
	<c:forEach var="x" begin="1" end="5">
		<c:choose>
			<c:when test="${userMovieItem.userMovie.mark == x}">
				<option value="${x}" selected="selected">${x}</option>
			</c:when>
			<c:otherwise>
				<option value="${x}">${x}</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>

<br/><br/>
<input type="text" id="review_title" name="review_title" value="${userMovieItem.review.title}" />
<br/>
<textarea id="review_text" name="review_text">
${userMovieItem.review.text}
</textarea>
<br/><br/>
<input type="button" value="Salva" onclick="updateUserMovieItem()"></input>

<script>
var c = Calendar.setup({
	animation	 : true,
	bottomBar	 : false,
	dateFormat	 : "%d/%m/%Y",
	inputField   : "date_viewed",
	trigger    	 : "calendar_trigger",
    onSelect : function(cal) {
    	this.hide();
	}
});


function updateUserMovieItem() {
	var movie = ${userMovieItem.movie.id}
	var mark = $('#mark_select').val();
	var reviewText = $('#review_text').val();
	var reviewTitle = $('#review_title').val();
	var dateViewed = $('#date_viewed').val();

	UserMovieManager.updateUserMovie(movie, mark, dateViewed, reviewTitle, reviewText, {
		callback: function(str) {
			alert(movie + " updated");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
</script>