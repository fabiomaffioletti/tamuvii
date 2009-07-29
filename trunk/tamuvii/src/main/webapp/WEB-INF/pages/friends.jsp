<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="Amici"/></title>
    <meta name="heading" content="<fmt:message key='friends.heading'/>"/>
</head>

<div id="sidebar">
	
</div>

<div id="main">
	<div id="contacts_container">
		<ul>
			<c:forEach var="contact" items="${friends}" varStatus="row">
				<div class="contacts_spacer">
					<div class="contact_info_sx_alto">
						<li>
							<c:choose>
								<c:when test="${not empty contact.imageLink}">
									<div id="user_image_div" style="background-image: url(${contact.imageLink});" >
									</div>
								</c:when>
								<c:otherwise>
									<div id="user_image_div" style="background-image: url(/images/placeholder_user_48.jpg);" >
									</div>
								</c:otherwise>	
							</c:choose>
							
							<div id="user_profile_info" style="margin-bottom: 10px;">
								<a href="/shelf.html?username=${contact.username}"" style="font-size: 14px; color: black; font-weight: bold;">${contact.username}</a>
								<br/>
								<span class="light_text_italic font11">Amico dal <fmt:formatDate pattern="${df}" value="${contact.dateAdded}" /></span>
								<br/>
								<a href="#" id="viewContactOtherInfoLink_${contact.id}" onclick="viewContactOtherInfo('${contact.id}', this.id)">Vedi altre informazioni</a>
							</div>
						
							<div id="contact_info_container_${contact.id}" class="contact_info_container" style="display:none;">
								<span class="light_text_italic font12">
									<c:if test="${not empty contact.sex}">
										<c:choose>
											<c:when test="${contact.sex == 'M'}">
												Maschio,
											</c:when>
											<c:otherwise>
												Femmina,
											</c:otherwise>
										</c:choose>
									</c:if>
									<c:if test="${not empty contact.age && contact.age != -1}">${contact.age} anni,</c:if> ${contact.address.country}
									<br/>	
								</span>
								<span class="light_text_italic font12">Finora ha visto ${contact.totMovies} film</span>
								<br/>
								<c:if test="${not empty contact.website}">
								<span class="font12">Sito web: <a href="${contact.website}" target="_blank">${contact.websiteTitle}</a></span>
								</c:if>
								<br/>
								<c:if test="${not empty contact.quotation}">
									<span class="font12">Citazione preferita: </span><span class="light_text_italic font12">${contact.quotation}</span>
								</c:if>
							</div>
						</li>
					</div>
					<div class="latest_movies_added">
						<li class="latest_movies_added_li">
							<ul id="contact_latest_movies_ul_${contact.id}" style="display:none;">
								<li class="title">
									Ultimi film aggiunti
								</li>
								<c:forEach var="item" items="${contact.lastMovies}">
									<li class="movie_title">
										<c:choose>
											<c:when test="${not empty item.localizedTitle}">
												<a href="/socialMovie.html?movie=${item.movie}">${item.localizedTitle}</a>
											</c:when>
											<c:otherwise>
												<a href="/socialMovie.html?movie=${item.movie}">${item.originalTitle}</a>
											</c:otherwise>
										</c:choose>
									</li>
								</c:forEach>
							</ul>
						</li>
					</div>
					
				</div>
			</c:forEach>
		</ul>
	</div>
</div>



<script>
	function viewContactOtherInfo(id, link) {
		var id_to_display = 'contact_info_container_' + id;
		var latest_to_display = 'contact_latest_movies_ul_' + id;
		$(id_to_display).appear({ duration: 0.2 });
		$(latest_to_display).appear({ duration: 0.2 });
		$(link).innerHTML = "Nascondi altre informazioni";
		$(link).writeAttribute('onclick', "hideContactOtherInfo('"+id+"', '"+link+"')");
		return false;
	}
	function hideContactOtherInfo(id, link) {
		var id_to_hide = 'contact_info_container_' + id;
		var latest_to_hide = 'contact_latest_movies_ul_' + id;
		$(id_to_hide).fade({ duration: 0.2 });
		$(latest_to_hide).fade({ duration: 0.2 });
		$(link).innerHTML = "Vedi altre informazioni";
		$(link).writeAttribute('onclick', "viewContactOtherInfo('"+id+"', '"+link+"')");
		return false;
	}

	function displayElement(id) {
		$(id).appear({ duration: 0.2 });
		return false;
	}
	function hideElement(id) {
		$(id).fade({ duration: 0.2 });
		return false;
	}
</script>

<script>
	var indexSimils;
	var totSimils;
	var recordsPerRowSimils; 
	var pagesSimils;
	var heightSimils;
	
	Event.observe(window, 'load', function(event) {
		indexSimils = 0;
		totSimils = 20;
		recordsPerPageSimils = 8;
		pagesSimils = Math.ceil(totSimils/recordsPerPageSimils);
		
		
		if(totSimils < recordsPerPageSimils) {
			$('simils_list_container').setStyle({
				height: (totSimils*35 + totSimils*5 + totSimils*1) + "px"
			});
		} else {
			$('simils_list_container').setStyle({
				height: (recordsPerPageSimils*35 + recordsPerPageSimils*5 + recordsPerPageSimils*1) + "px"
			});
		}		
		
		if(pagesSimils > 1) {
    		$('downSimils').setStyle({ display: 'block' });
	    }
	   
	});

	//////// FUNZIONI GENERICHE PER LO SCROLLING //////// 
	function doup(index, step, container, h, down, up) {
		index = index-step;
		if(!$(down).visible()) {
			$(down).setStyle({ display: 'block' });
		}
		if(index == 0) {
			$(up).setStyle({ display: 'none' });
		}
		new Effect.Move($(container),{x: 0, y: step*h, duration: 0.3}); return index;
	}

	function dodown(index, pages, step, container, h, down, up) {
		index = index+step;
		if(!$(up).visible()) {
			$(up).setStyle({ display: 'block' });
		}
		if(index == (pages-1)) {
			$(down).setStyle({ display: 'none' });
		} else {
			$(down).setStyle({ display: 'block' });
		}
		new Effect.Move($(container),{x: 0, y: step*-h, duration: 0.3}); return index;
	}
	//////// FINE FUNZIONI GENERICHE PER LO SCROLLING ////////
	
</script>