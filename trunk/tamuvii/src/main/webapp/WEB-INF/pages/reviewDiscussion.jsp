<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="reviewDiscussion.title"/></title>
    <meta name="heading" content="<fmt:message key='reviewDiscussion.heading'/>"/>
</head>

<div id="sx">
	ciao
</div>

<div id="main">
	<div id="review_container">
		<ul>
			<li>
				<div class="review_title_container">
					<div class="review_title">
						<span class="review_title_span">${discussion.review.title}</span>		
					</div>
					<div class="vote_options_container">
						<img src="emotes-ok.png"> <span id="ok_1">5 FIXME</span>
						<img src="emotes-ko.png"> <span id="ko_1">7 FIXME</span>
					</div>
				</div>					
				<div class="review_text">
					${discussion.review.reviewtext}
				</div>
				<div style="margin-top: 5px;">
					<div class="person_list_info_container">
						<div class="container">
							<img src="/images/flickr.jpg" width="30" height="30" class="major" />
							<img class="minor" src="/images/frame_30.png" alt="">
						</div>
						<div class="person_list_info">
							<b>FIXME</b>, <span class="light_text_italic font11">FIXME</span>
							<br/>
							FIMXE<img src="/images/star.gif" />
						</div>
					</div>
					<div style="float: right;">
						<a href="#">FIXME</a>
					</div>
				</div>
			</li>
		</ul>
	</div>
	
	<div id="movie_opinions_container">
		<div class="review_title_container">
			<div class="review_title">
				<span class="review_title_span">Ecco i commenti alla review</span>		
			</div>
		</div>
		<c:forEach var="opinion" items="${discussion.opinions}">
			<ul>
				<li>
					<div class="opinion_user">
						<div class="person_list_info_container">
							<div class="container">
								<img src="/images/flickr.jpg" width="30" height="30" class="major" />
								<img class="minor" src="/images/frame_30.png" alt="">
							</div>
							<div class="person_list_info">
								<b>${opinion.username}</b>
								<br/>
								<span class="light_text_italic font11"><fmt:formatDate pattern="${df}" value="${opinion.dateinserted}" /></span>
							</div>
						</div>
					</div>
					<div class="opinion_text">
						${opinion.opiniontext}
					</div>
				</li>
			</ul>
		</c:forEach>
	</div>
	
</div>


Insert new opinion:
<form:form name="reviewDiscussionForm" commandName="opinion" method="POST">
	<input type="hidden" name="movie" value="${discussion.review.movie}" />
	<form:textarea path="opiniontext"/>
	<br/>

	<input type="submit" name="save" value="salva" />
	<input type="submit" name="cancel" value="annulla" />
</form:form>

