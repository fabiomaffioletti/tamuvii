<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
    <script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/ShelfManager.js"> </script>
    
    <style>
    	.explore_people_block_sx {
    		width:208px; 
    		float: left; 
    		height: 50px; 
    		padding: 10px; 
    		border:1px dashed #ccc; 
    		margin-right: 20px;
    		margin-bottom: 20px;
    	}
    	.explore_people_block_dx {
    		width:208px; 
    		float: left; 
    		height: 50px; 
    		padding: 10px; 
    		border:1px dashed #ccc; 
    		margin-bottom: 20px;
    	}
    	.explore_people_block_dx a {
    		text-decoration: none;
    	}
    	.explore_people_block_dx a:hover {
    		text-decoration: underline;
    	}
    	.explore_people_block_sx a {
    		text-decoration: none;
    	}
    	.explore_people_block_sx a:hover {
    		text-decoration: underline;
    	}
    	
    </style>
</head>

<div id="main">
	<div class="statistics_section_title">
		<div style="padding: 10px;">Ultimi utenti registrati</div>
	</div>
	<div class="statistics_section_content">
		<c:forEach var="contact" items="${lastSubscribedUsers}" step="2" varStatus="row" >
				<div class="explore_people_block_sx">
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
						<a href="/shelf.html?username=${contact.username}" style="font-size: 14px; color: black; font-weight: bold;">${contact.username}</a>
						<br/>
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
							<span class="light_text_italic font11"><br/>${contact.totMovies} Film</span>
						</span>
					</div>
				</div>
				<c:if test="${fn:length(lastSubscribedUsers) > 1}">
					<div class="explore_people_block_dx">
						<c:choose>
							<c:when test="${not empty lastSubscribedUsers[row.index+1].imageLink}">
								<div id="user_image_div" style="background-image: url(${lastSubscribedUsers[row.index+1].imageLink});" >
								</div>
							</c:when>
							<c:otherwise>
								<div id="user_image_div" style="background-image: url(/images/placeholder_user_48.jpg);" >
								</div>
							</c:otherwise>	
						</c:choose>
						<div id="user_profile_info" style="margin-bottom: 10px;">
							<a href="/shelf.html?username=${lastSubscribedUsers[row.index+1].username}" style="font-size: 14px; color: black; font-weight: bold;">${lastSubscribedUsers[row.index+1].username}</a>
							<br/>
							<span class="light_text_italic font12">
								<c:if test="${not empty lastSubscribedUsers[row.index+1].sex}">
									<c:choose>
										<c:when test="${lastSubscribedUsers[row.index+1].sex == 'M'}">
											Maschio,
										</c:when>
										<c:otherwise>
											Femmina,
										</c:otherwise>
									</c:choose>
								</c:if>
								<c:if test="${not empty lastSubscribedUsers[row.index+1].age && lastSubscribedUsers[row.index+1].age != -1}">${lastSubscribedUsers[row.index+1].age} anni,</c:if> ${lastSubscribedUsers[row.index+1].address.country}
								<span class="light_text_italic font11"><br/>${lastSubscribedUsers[row.index+1].totMovies} Film</span>
							</span>
						</div>
					</div>
				</c:if>
		</c:forEach>
	</div>
	
</div>






<div id="sidebar">
	
</div>