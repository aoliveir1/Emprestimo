$(function() {

	// altenar telas na página ferramentas

	$("#limpar").click(function() {
		$(".ferramentas-limpar").show("fast");
		$(".ferramentas-usuario").hide("fast");
		$(".ferramentas-material").hide("fast");
	});

	$("#usuario").click(function() {
		$(".ferramentas-usuario").show("fast");
		$(".ferramentas-limpar").hide("fast");
		$(".ferramentas-material").hide("fast");
	});

	$("#material").click(function() {
		$(".ferramentas-material").show("fast");
		$(".ferramentas-limpar").hide("fast");
		$(".ferramentas-usuario").hide("fast");
	});

});