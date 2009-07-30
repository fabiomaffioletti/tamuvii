<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="search.pagetitle"/></title>
</head>

<div id="sidebar">
	<span style="font-size:12px;color:#777;font-style:italic;"><fmt:message key="label.search.movie" /></span>
	<input type="text" name="search" id="search" style="width: 185px; border:1px dashed #AAA;"/><img style="vertical-align: middle; margin-left: 5px; cursor: pointer;" src="/images/search.png" onclick="searchMovie();" />
	<span id="spin" style="display:none;color:#FF0000"><img src="/images/loader.gif" alt="Attendere..." style="width:15px;vertical-align:middle"/></span>
	<div id="autocomplete_choices" class="autocomplete" style="clear:both;"></div>
</div>

<div id="main">
	<div id="searchFrameContainer">
		<iframe id="searchIframe" frameborder="0" scrolling="no" width="100%" height="580px"></iframe>
	</div>
</div>

<script type="text/javascript">
    new Ajax.Autocompleter("search", "autocomplete_choices", "searchAutocomplete.html?ajax=true", {
    		paramName: "searchString", 
    	  	minChars: 2,
    	  	indicator: "spin",
    	  	frequency: 0.5
    	});
</script>

<script>
	function searchMovie() {
		var searchString = $('search').value.replace(",", " ");
		$('searchIframe').writeAttribute('src', '/searchSocialMovies.html?ajax=true&filter='+searchString);
	}
</script>


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

