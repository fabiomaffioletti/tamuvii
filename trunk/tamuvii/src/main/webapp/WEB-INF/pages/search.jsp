<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="search.pagetitle"/></title>
    <script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/MovieManager.js"> </script>
    <script type="text/javascript" src="/dwr/interface/UserToMovieManager.js"> </script>
    
    <style>
    	#deploy_shelf {
    		height: 150px; 
    		font-size: 13px; 
    		border: 1px dashed #aaa; 
    		margin-top: 20px; 
    		margin-bottom: 10px; 
    		padding: 10px;
    	}
    	.deploy_message {
    		margin-top: 20px;
    		text-align: center;
    	}
    	#deploy_shelf.deploy_hover {
    		border: 3px dashed #aaa;
    		padding: 8px; 
    	}
    </style>
</head>

<div id="sidebar">
	<span style="font-size:12px;color:#777;font-style:italic;"><fmt:message key="label.search.movie" /></span>
	<input type="text" name="search" id="search" style="width: 185px; border:1px dashed #AAA;"/><img style="vertical-align: middle; margin-left: 5px; cursor: pointer;" src="/images/search.png" onclick="browse(0);" />
	<span id="spin" style="display:none;color:#FF0000"><img src="/images/loader.gif" alt="Attendere..." style="width:15px;vertical-align:middle"/></span>
	<div id="autocomplete_choices" class="autocomplete" style="clear:both;"></div>
	
	<div id="deploy_shelf">
		<div id="deploy_info" class="deploy_message light_text_italic">
			Trascina qui la locandina del film per aggiungerlo alla tua videoteca
		</div>
		<div id="deploy_result" class="deploy_message light_text_italic" style="display:none;">
			<!-- <img src="/images/loader.gif" /> -->
		</div>
	</div>
	<script>
		Droppables.add('deploy_shelf', { 
		    accept: 'movie_image',
		    hoverclass: 'deploy_hover',
		    onHover: function() {
				$('deploy_result').setStyle({
					display: 'none'
				});
			},
		    onDrop: function(dragged, dropped, event) {
		    	var movie = dragged.id.substring(dragged.id.lastIndexOf('_')+1, dragged.id.length);
		    	addMovieToShelf(movie);
		    }
		});

		function addMovieToShelf(movie) {
			loadingAdditionResponse();
			UserToMovieManager.addMovieToShelf(movie, '${pageContext.request.remoteUser}', {
				callback: function() {
					displayAdditionResult('Perfetto, hai aggiunto il film alla tua videoteca!');
				},
				errorHandler:function(errorString, exception) {
					if (exception instanceof UserToMovieAlreadyAddedToShelfException) {
						displayAdditionResult('Hai già questo film nella tua videoteca!');
					} else {
						alert("<fmt:message key='tamuvii.generic.error' />");
					}
				}
			}); 
		}

		function loadingAdditionResponse() {
			$('deploy_result').update('<img src="/images/loader.gif" />');
			new Effect.Appear('deploy_result', {duration: 0.2});
		}
		function displayAdditionResult(message) {
			new Effect.DropOut('deploy_result', {duration: 0.2, afterFinish: function() {
				$('deploy_result').update(message);
				new Effect.Appear('deploy_result', {duration: 0.2});
				$('deploy_shelf').highlight();
			}});
		}
	</script>
</div>

<div id="main">
	<div id="movies_loader" style="display: none; text-align: center;width: 100%;">
		<span style="width:100%;float:left;"><img src="/images/loader.gif"/></span>
	</div>
	
	<div id="movies_loading">
		<c:if test="${fn:length(results.items) > 0}">
			<div id="movies">
				<div style="width: 466px; border: 1px dashed #ccc; padding: 5px; margin: 5px;" id="random">
					Vuoi dare un'occhiata a questi film? 
				</div>
				
				<div id="movies_list_container">
					<ul id="movie_list" class="movie_list">
						<c:forEach var="shelfItem" items="${results.items}">
							
							<li class="movie_image" id="movie_image_${shelfItem.movie}">
								<c:choose>
									<c:when test="${not empty shelfItem.localizedImage}">
										<img src="${shelfItem.localizedImage}" />
									</c:when>
									<c:otherwise>
										<img src="${shelfItem.originalImage}" />
									</c:otherwise>
								</c:choose>
							</li>
							<script>
								new Draggable('movie_image_'+${shelfItem.movie}, { 
								    revert: true,
								    ghosting: true,
								    scroll: window
								});
							</script>
							
							<li class="movie_data">
								<div class="title" id="title_${shelfItem.movie}">
									<c:choose>
							    		<c:when test="${empty shelfItem.localizedTitle}">
								    		<a href="/socialMovie.html?movie=${shelfItem.movie}"><b>${shelfItem.originalTitle}</b></a> 
								    	</c:when>
								    	<c:otherwise>
								    		<a href="/socialMovie.html?movie=${shelfItem.movie}"><b>${shelfItem.localizedTitle}</b></a>
								    	</c:otherwise>
							    	</c:choose>
								</div>
								
								<c:if test="${shelfItem.originalTitle != shelfItem.localizedTitle}">
						    		<div class="localized_title">
						    			<i><fmt:message key="label.original.title" />: ${shelfItem.originalTitle}</i>
						    		</div>
						    	</c:if>
						    	
								<div class="directed_by"><fmt:message key="label.by" /> <a href="/directorDetail.html?director=${shelfItem.directorId}">${shelfItem.director}</a></div>
								
								<div class="light_text_italic font11" style="width: 100%; float:left;">${shelfItem.numUsers}
						    		<c:choose>
						    			<c:when test="${shelfItem.numUsers > 1}">
						    				<fmt:message key="label.users" />
						    			</c:when>
						    			<c:otherwise>
						    				<fmt:message key="label.user" />
						    			</c:otherwise>
						    		</c:choose> 
								</div>
								
								<c:if test="${shelfItem.avgMark > 0}">
							    	<div class="mark">
								    	<c:forEach begin="1" end="${shelfItem.avgMark}">
											<img src="/images/star.gif"/>
								    	</c:forEach>
							    	</div>
						    	</c:if>
							</li>
							
							<li class="movie_actions">
								<div class="action action_title"><fmt:message key="label.options" /></div>
									<c:if test="${not empty shelfItem.originalPlot || not empty shelfItem.localizedPlot}">
										<div class="action"><a href="#" onclick="toggleAndMove('movie_plot_${shelfItem.movie}'); return false;"><fmt:message key="label.plot" /></a></div>
									</c:if>
									
									<c:set var="isInPersonalMovies" value="0" />
						    		<c:set var="isWished" value="0" />
							    	<c:forEach var="personalMovieId" items="${personalMoviesIdsAndWishedFlags}">
							    		<c:if test="${personalMovieId.movie == shelfItem.movie}">
							    			<c:set var="isInPersonalMovies" value="1" />
							    			<c:if test="${personalMovieId.wished == 1}">
							    				<c:set var="isWished" value="1" />
							    			</c:if>
							    		</c:if>
							    	</c:forEach>
							    	<c:choose>
				    					<c:when test="${isInPersonalMovies == 0}">
				    						<div class="action"><a href="/shelfManagement.html?action=add&movie=${shelfItem.movie}"><fmt:message key="label.add.shelf" /></a></div>
				    						<div class="action"><a href="/wishlistManagement.html?action=wish&movie=${shelfItem.movie}"><fmt:message key="label.add.wishlist" /></a></div>
				    					</c:when>
				    					<c:otherwise>
				    						<div class="action"> 
				    							<c:if test="${isWished == 0}"> <fmt:message key="label.present.in.shelf" /></c:if>
								    			<c:if test="${isWished == 1}"> <fmt:message key="label.present.in.wishlist" /></c:if>
				    						</div>
								    	</c:otherwise>
				    				</c:choose>
							</li>
							<li class="movie_plot" id="movie_plot_${shelfItem.movie}" style="display: none;">
								<div class="plot_text">
									 <c:choose>
							    		<c:when test="${empty shelfItem.localizedPlot}">
								    		${shelfItem.originalPlot}
								    	</c:when>
								    	<c:otherwise>
								    		${shelfItem.localizedPlot}
								    	</c:otherwise>
							    	</c:choose>
								</div>
							</li>
							
							
							<li class="separator">
							</li>
						</c:forEach>
					</ul>
					
					 
					<div id="pagination">
						<div id="pagination_links">
							<c:forEach begin="0" end="${results.itemsSize-1}" varStatus="p">
								<c:choose>
									<c:when test="${results.currentPage == p.index}">
										<a href="#" id="${p.index}" style="cursor:default; background-color: #ccc; color: black;">${p.index+1}</a>	
									</c:when>
									<c:otherwise>
										<a href="#" id="${p.index}" onclick="browse('${p.index}');">${p.index+1}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</div>
					
				</div>
			</div>
		</c:if>
	</div>
	 
</div>



<script>
	Event.observe(window, 'load', function(event) {
		if ($('random')) {
	        new Effect.Highlight('random', {startcolor: '#4F8CC9',	restorecolor: true});
	    }
	});

	function toggleAndMove(id) {	
		new Effect.toggle(id, 'appear', { duration: 0.5});
	}

	function browse(page) {
		var filter = $('search').value.replace(",", " ");
		
		new Effect.ScrollTo('header', {duration: 0.5, offset: -100, afterFinish: function() {
			new Effect.BlindUp('movies_loading', {duration: 0.5, afterFinish: function() {
				$('random').setStyle({
					display: 'none'
				});
				new Effect.BlindDown('movies_loader', {duration: 0.2});
				
				MovieManager.searchSocialMovies('${pageContext.request.remoteUser}', filter, false, page, {
					callback: function(str) {
								new Effect.DropOut('movies_loader', {duration: 0.2, afterFinish: function() {
								refreshShelf(str.items);
								refreshPagination(str.itemsSize, str.currentPage);
								new Effect.BlindDown('movies_loading', {duration: 0.5});
							} 
						});
					},
					errorHandler:function(errorString, exception) {
						alert("Errore - Internazionalizzare" + errorString + " " + exception);
					}
				});
			}});
		}});
	}

	function refreshPagination(itemsSize, currentPage) {
		$('pagination_links').remove();
		var div = Builder.node('div', {id: 'pagination_links'});
		for(var j=0; j<itemsSize; j++) {
			if(currentPage == j) {
				var a = Builder.node('a', {id: j, href: '#', style:'cursor:default; background-color: #ccc; color:black;'}, j+1);
			} else {
				var a = Builder.node('a', {id: j, href: '#', style:'cursor: pointer', onclick: 'browse('+j+')'}, j+1);
			}
			$(div).insert(a);
		}
		$('pagination').insert(div);
	}
	function refreshShelf(str) {
		dwr.util.removeAllOptions('movie_list');
		for(var x=0; x<str.length; x++) {
			
			// Costruisco l'immagine giusta
			var movie_image_li = Builder.node('li', {id: 'movie_image_'+str[x].movie, className: 'movie_image' });
			if(str[x].localizedImage != null) { 
				var image = Builder.node('img', { src: str[x].localizedImage });
			} else {
				var image = Builder.node('img', { src: str[x].originalImage });
			}
			movie_image_li.insert(image);
			new Draggable( $(movie_image_li), { 
			    revert: true,
			    ghosting: true,
			    scroll: window
			});

			

			// Costruisco le informazioni sul film
			var movie_data_li = Builder.node('li', { className: 'movie_data' });

			// Titolo
			var title_div = Builder.node('div', {className: 'title', id: 'title_'+str[x].movie });
			if(str[x].localizedTitle == null) { 
				var social_movie_link = Builder.node('a', { href: '/socialMovie.html?movie='+str[x].movie }, str[x].originalTitle);
			} else {
				var social_movie_link = Builder.node('a', { href: '/socialMovie.html?movie='+str[x].movie }, str[x].localizedTitle);
			}
			title_div.insert(social_movie_link);
			movie_data_li.insert(title_div);
			
			// Titolo originale
			var localized_title_div = Builder.node('div', { className: 'localized_title' }, "<fmt:message key='label.original.title' />: " + str[x].originalTitle);
			movie_data_li.insert(localized_title_div);

			// Regista
			var directed_by_div = Builder.node('div', { className: 'directed_by' }, 'di ');
			var directed_by_link = Builder.node('a', {href: '/directorDetail.html?director='+str[x].directorId }, str[x].director);
			directed_by_div.insert(directed_by_link);
			movie_data_li.insert(directed_by_div);
			
			// Voto
			if(str[x].avgMark > 0) {
				var mark_div = Builder.node('div', { className: 'mark'});
				for(var m = 0; m<str[x].avgMark; m++) {
					var img_mark = Builder.node('img', {src: '/images/star.gif'});
					mark_div.insert(img_mark);
				}
			}
			movie_data_li.insert(mark_div);


			//Opzioni
			var option_li = Builder.node('li', { className: 'movie_actions' });
			var action_title_div = Builder.node('div', { className: 'action action_title' }, "<fmt:message key='label.options' />");
			$(option_li).insert(action_title_div);
			
			if(str[x].originalPlot != null || str[x].localizedPlot != null) {
				var plot_action_div = Builder.node('div', { className: 'action' });
				var plot_action_link = Builder.node('a', {href: '#', onclick: "toggleAndMove(\'movie_plot_"+str[x].movie+"\', \'title_"+str[x].movie+"\'); return false;" }, 'Vedi trama' );
				plot_action_div.insert(plot_action_link);
				$(option_li).insert(plot_action_div);
			}
			
	    	var isInPersonalMovies = 0;
	    	var isWished = 0;
	    	
	    	<c:forEach var="personalMovieId" items="${personalMoviesIdsAndWishedFlags}">
	    		if(${personalMovieId.movie} == str[x].movie) { 
	    			isInPersonalMovies = 1;
	    			<c:if test="${personalMovieId.wished == 1}">
	    				isWished = 1;
	    			</c:if>
	    		}
	    	</c:forEach>
	    	
	    	if(isInPersonalMovies == 0) {
				var add_shelf_div = Builder.node('div', { className: 'action' });
				var add_shelf_a = Builder.node('a', { href: '/shelfManagement.html?action=add&movie='+str[x].movie }, "<fmt:message key='label.add.shelf' />");
				add_shelf_div.insert(add_shelf_a);
				var add_wish_div = Builder.node('div', { className: 'action' });
				var add_wish_a = Builder.node('a', { href: '/wishlistManagement.html?action=wish&movie='+str[x].movie }, "<fmt:message key='label.add.wishlist' />");
				add_wish_div.insert(add_wish_a);
				option_li.insert(add_shelf_div);
				option_li.insert(add_wish_div);
		    	
	    	} else {
		    	var presence_div = Builder.node('div', { className: 'action' });
		    	if(isWished == 0) {
			    	presence_div.innerHTML = "<fmt:message key='label.present.in.shelf' />";	
		    	} else {
		    		presence_div.innerHTML = "<fmt:message key='label.present.in.wishlist' />";	
		    	}
		    	option_li.insert(presence_div);
	    	}

			// Trama
			var movie_plot_li = Builder.node('li', { id: 'movie_plot_'+str[x].movie, className: 'movie_plot', style: 'display:none' });
			if(str[x].localizedPlot != null) { 
				var plot_text_div = Builder.node('div', { className: 'plot_text' }, str[x].localizedPlot);
			} else {
				var plot_text_div = Builder.node('div', { className: 'plot_text' }, str[x].originalPlot);
			}
			movie_plot_li.insert(plot_text_div);

			// Separatore
			var sep_li = Builder.node('li', { className: 'separator' });

			$('movie_list').insert(movie_image_li);
			$('movie_list').insert(movie_data_li);
			$('movie_list').insert(option_li);
			$('movie_list').insert(movie_plot_li);
			$('movie_list').insert(sep_li);
		}
	}
</script>

















<script type="text/javascript">
    new Ajax.Autocompleter("search", "autocomplete_choices", "searchAutocomplete.html?ajax=true", {
    		paramName: "searchString", 
    	  	minChars: 2,
    	  	indicator: "spin",
    	  	frequency: 0.5
    	});
</script>

<%--
<script>
	function searchMovie() {
		var searchString = $('search').value.replace(",", " ");
		$('searchIframe').writeAttribute('src', '/searchSocialMovies.html?ajax=true&filter='+searchString);
	}
</script>
--%>


<style type="text/css">
div.autocomplete {
  position:absolute;
  width:250px;
  background-color:white;
  margin:0;
  padding:0;
}
div.autocomplete ul {
  list-style-type:none;
  margin:0;
  padding:0;
}
div.autocomplete ul li.selected { background-color: #ffb;}
div.autocomplete ul li {
  list-style-type:none;
  display:block;
  margin:0;
  padding:2px;
  height:20px;
  cursor:pointer;
  font-size:10px;
  width:300px;
  background-color:white;
  border-bottom:1px solid black;
  border-left:1px solid black;
  border-right:1px solid black;
}
div.autocomplete li.first {
  list-style-type:none;
  display:block;
  margin:0;
  padding:2px;
  height:20px;
  cursor:pointer;
  font-size:10px;
  width:300px;
  background-color:white;
  border:1px solid black;
}

</style>

