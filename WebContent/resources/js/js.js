$(function() {

	$("#limpar").click(function() {
		$(".ferramentas-limpar").show("fast");
		$(".ferramentas-usuario").hide("fast");
	});

	$("#usuario").click(function() {
		$(".ferramentas-usuario").show("fast");
		$(".ferramentas-limpar").hide("fast");
	});

});