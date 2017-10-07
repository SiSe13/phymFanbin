var SUCCESS = 0;

$(function(){
	$(".shipinshichang").select();
	$(".shipinshichang").blur(checkshipin);
	$(".bofangshichang").blur(checkshipin);
	$(".btn-finish").click(finishShaiXuan);
});

function checkshipin(){
	$(".shipin_span").hide();
	$(".bofang_span").hide();
	var checkshipin=$(".shipinshichang").val();
	var bofangshichang=$(".bofangshichang").val();
	var reg=/^[0-9]*$/;
	if(!reg.test(checkshipin)||checkshipin==""||checkshipin==0||!reg.test(bofangshichang)||bofangshichang==""||bofangshichang==0||bofangshichang%checkshipin!=0){
		$("#next").attr("disabled","disabled");
	}else{
		$("#next").removeAttr('disabled');
	}
	
	
	if(!reg.test(checkshipin)||checkshipin==""){
		$(".shipin_span").show();
	}else{
		$(".shipin_span").hide();
	}
	if(!reg.test(bofangshichang)||bofangshichang==""||bofangshichang%checkshipin!=0){
		$(".bofang_span").show();
	}else{
		$(".bofang_span").hide();
	}
	
}
function finishShaiXuan(){
	var checkshipin=$(".shipinshichang").val();
	var bofangshichang=$(".bofangshichang").val();
	var outdoorProvince = $("#province_div div:first").html();
	var outdoorCity = $("#city_div div:first").html();
	var outdoorCountry = $("#area_div div:first").html();
	var outdoorScreenType = $("#select_screen option:checked").html();
	var outdoorMediasourceType=$("input[type='radio']:checked").val();
	
	
	window.location.href='shopping-cart.html?checkshipin='+checkshipin+
											'&bofangshichang='+bofangshichang+
											'&outdoorProvince='+outdoorProvince+
											'&outdoorCity='+outdoorCity+
											'&outdoorCountry='+outdoorCountry+
											'&outdoorScreenType='+outdoorScreenType+
											'&outdoorMediasourceType='+outdoorMediasourceType;
}
