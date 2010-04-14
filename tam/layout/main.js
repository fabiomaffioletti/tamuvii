function goRight(panel) {
	var i = -panel*580;
	$('#panels').animate({marginLeft:i+"px"}, 300);
}
function goLeft(panel) {
	var i = panel*580;
	$('#panels').animate({marginLeft:i+"px"}, 300);
}

/*
$(function() {
	$("#closeBtn").click(function(){
		$("#panel").animate({height: "400px"}, "swing").animate({height: "0px"}, "fast");
		$(".panelBtn").toggle();
		return false;
	});
	$("#search_button").click(function(){
		$("#panel").animate({height: "420px"}, "swing").animate({height: "350px"}, "fast");
		$(".panelBtn").toggle();
		return false;
	});
});*/