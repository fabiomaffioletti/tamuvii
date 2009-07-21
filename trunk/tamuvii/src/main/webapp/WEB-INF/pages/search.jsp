<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="search.pagetitle"/></title>

</head>



	<div id="sidebar">
		<input type="text" name="search" id="search"/><span id="spin" style="display:none;color:#FF0000"><img src="/images/loader.gif" alt="Attendere..." style="width:20px;vertical-align:bottom"/></span>
		<div id="autocomplete_choices" class="autocomplete"></div>
	</div>


<script type="text/javascript">
    new Ajax.Autocompleter("search", "autocomplete_choices", "searchAutocomplete.html?ajax=true", {
    		paramName: "searchString", 
    	  	minChars: 2,
    	  	indicator: "spin"
    	});
</script>

<style type="text/css">
div.autocomplete {
  position:absolute;
  width:250px;
  background-color:white;
  border:1px solid #888;
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
}
</style>

