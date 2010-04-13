<%@ include file="/common/taglibs.jsp"%>

<head>
	<title>Shelf</title>
	<script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/UserManager.js"> </script>
    <script type="text/javascript" src="/dwr/interface/UserMovieManager.js"> </script>
    <script type="text/javascript" src="/dwr/interface/ReviewManager.js"> </script>
</head>

USER INFO: ${userInfo}
<security:authorize ifAnyGranted="ROLE_USER">
	<c:if test="${userInfo.username != pageContext.request.remoteUser}">
		<c:choose>
			<c:when test="${relationship == '1'}">Amico <a href="#" onclick="changeToNearby('${userInfo.username}')">Cambia a vicino</a> <a href="#" onclick="deleteRelationship('${userInfo.username}')">Non seguire più</a></c:when>
			<c:when test="${relationship == '0'}">Vicino <a href="#" onclick="changeToFriend('${userInfo.username}')">Cambia ad amico</a> <a href="#" onclick="deleteRelationship('${userInfo.username}')">Non seguire più</a></c:when>
			<c:otherwise><a href="#" onclick="addFriend('${userInfo.username}')">Aggiungi come amico</a><a href="#" onclick="addNearby('${userInfo.username}')">Aggiungi come vicino</a></c:otherwise>
		</c:choose>
	</c:if>
</security:authorize>
<br/><br/>
FRIENDS ${userInfo.friendsCount} - <a href="#" onclick="getFriends('')">Vedi tutti</a>
<br/>
<c:forEach var="f" items="${userInfo.friends}">
	${f} - <a href="/${f.username}/movies/">${f.username}</a>
	<br/>
</c:forEach>
<br/><br/>
NEARBIES ${userInfo.nearbiesCount} - <a href="#" onclick="getNearbies('')">Vedi tutti</a>
<br/>
<c:forEach var="n" items="${userInfo.nearbies}">
	${n} - <a href="/${n.username}/movies/">${n.username}</a>
	<br/>
</c:forEach>
<br/><br/>
REVIEW COUNT: ${userInfo.reviewCount}

<div id="shelf_content" style="border: 1px solid grey;">

</div>

<script>
var $ = jQuery;

if(jQuery.url.param("movie")) {
	getMovieItem(jQuery.url.param("movie"));
} else if(jQuery.url.segment(1) == 'contacts') {
	getFriends('');
} else {
	getShelf('');
}



/* SHELF */
function getShelfPage(page, filter) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/shelfItems.html',
		data: 'username=${userInfo.username}&filter='+filter+'&page='+page,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function searchShelf() {
	var filter = $('#search_shelf_text').val();
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/shelfItems.html',
		data: 'username=${userInfo.username}&filter='+filter,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getShelf(filter) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/shelfItems.html',
		data: 'username=${userInfo.username}&filter='+filter,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}



/* WISHLIST */
function getWishlist() {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/wishlistItems.html',
		data: 'username=${userInfo.username}',
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getWishlistPage(page, filter) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/wishlistItems.html',
		data: 'username=${userInfo.username}&filter='+filter+'&page='+page,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function searchWishlist() {
	var filter = $('#search_wishlist_text').val();
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/wishlistItems.html',
		data: 'username=${userInfo.username}&filter='+filter,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}


/* GLOBAL SEARCH */
function searchMovie() {
	var filter = $('#search_global_text').val();
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/searchItems.html',
		data: 'filter='+filter,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getSearchPage(page, filter) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/searchItems.html',
		data: 'filter='+filter+'&page='+page,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}



/* MOVIE ITEM */
function getMovieItem(id) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/movieItem.html',
		data: 'id='+id,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getMoviesByDirector(id) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/moviesByDirector.html',
		data: 'id='+id,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getMoviesByDirectorPage(page, id) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/moviesByDirector.html',
		data: 'id='+id+'&page='+page,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getUserMovieUsers(movie) {
	UserManager.getUsersByMovie(movie, 0, 10, {
		callback: function(userInfo) {
			$('#movie_users_container').html('');
			$.each(userInfo, function() {
				$('#movie_users_container').append($('<a>').attr({href:'/'+this.username+'/movies/'}).html(this.username)).append('<br/>');				
			});
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function getUserMovieFriends(movie) {
	UserManager.getFriendsByMovie(movie, null, 0, 10, {
		callback: function(userInfo) {
			$('#movie_users_container').html('');
			$.each(userInfo, function() {
				$('#movie_users_container').append($('<a>').attr({href:'/'+this.username+'/movies/'}).html(this.username)).append('<br/>');				
			});
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function getUserMovieNearbies(movie) {
	UserManager.getNearbiesByMovie(movie, null, 0, 10, {
		callback: function(userInfo) {
			$('#movie_users_container').html('');
			$.each(userInfo, function() {
				$('#movie_users_container').append($('<a>').attr({href:'/'+this.username+'/movies/'}).html(this.username)).append('<br/>');				
			});
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}


/* REVIEW ITEM */
function getReviewItem(movie, username) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/reviewItem.html',
		data: 'movie='+movie+'&username='+username,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function writeOpinion(movie, username) {
	var opinion_text = $('#opinion_text').val();
	ReviewManager.addOpinion(movie, username, opinion_text, {
		callback: function(str) {
			alert("opinion added");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}


/* USER MOVIES */
function addUserMovie(movie, wishlist) {
	UserMovieManager.addUserMovie(movie, null, wishlist, {
		callback: function(str) {
			alert("added to "+wishlist);
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function moveToShelf(movie) {
	UserMovieManager.moveToShelf(movie, {
		callback: function(str) {
			alert("moved to shelf");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function deleteUserMovie(movie) {
	UserMovieManager.deleteUserMovieById(movie, {
		callback: function(str) {
			alert(movie + " deleted from user's table");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}

function getUserMovieItem(id) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/userMovieItem.html',
		data: 'movie='+id,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}


/* RELATIONSHIPS */
function addFriend(username) {
	UserManager.addFriend(username, {
		callback: function(str) {
			alert("added as friend");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function addNearby(username) {
	UserManager.addNearby(username, {
		callback: function(str) {
			alert("added as nearby");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function changeToNearby(username) {
	UserManager.changeToNearby(username, {
		callback: function(str) {
			alert("changed to nearby");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function changeToFriend(username) {
	UserManager.changeToFriend(username, {
		callback: function(str) {
			alert("changed to friend");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function deleteRelationship(username) {
	UserManager.deleteRelationship(username, {
		callback: function(str) {
			alert("relationship deleted");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}

function getFriends(filter) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/friends.html',
		data: 'username=${userInfo.username}&filter='+filter+'&type=f',
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getFriendsPage(page, filter) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/friends.html',
		data: 'username=${userInfo.username}&type=f&filter='+filter+'&page='+page,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function searchFriends() {
	var filter = $('#search_friends_text').val();
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/friends.html',
		data: 'username=${userInfo.username}&filter='+filter+'&type=f',
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function searchNearbies() {
	var filter = $('#search_nearbies_text').val();
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/nearbies.html',
		data: 'username=${userInfo.username}&filter='+filter+'&type=n',
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getNearbies(filter) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/nearbies.html',
		data: 'username=${userInfo.username}&filter='+filter+'&type=n',
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}
function getNearbiesPage(page, filter) {
	$.ajax({
		dataType: 'html',
		type: 'GET',
		url: '/nearbies.html',
		data: 'username=${userInfo.username}&type=n&filter='+filter+'&page='+page,
		success: function(resp) {
			$('#shelf_content').html(resp);
		}
	});
}


/* REVIEWS */
function addPositive(movie, user) {
	ReviewManager.addPositive(movie, user, {
		callback: function(str) {
			alert("positive added");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
function addNegative(movie, user) {
	ReviewManager.addNegative(movie, user, {
		callback: function(str) {
			alert("negative added");
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}
</script>