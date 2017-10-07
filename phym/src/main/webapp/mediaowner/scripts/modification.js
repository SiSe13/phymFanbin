var SUCCESS = 0;
$(function(){
	showModification();
	$("#amendBtn").click(amendBtn);
	
});

function showModification(){
	var url=window.location.href;	  //获取当前页面的url
	var len=url.length;   //获取url的长度值
	var a=url.indexOf("=");   //获取第一次出现？的位置下标
	var id=url.substr(a+1,len);   //截取问号之后的内容
	console.log(id);
	url="outdoor/findout.do";
	var data={"outDoorId":id};
	$.post(url,data,function(result){
		if(result.status == SUCCESS){
			var outdoor=result.data;
			console.log(outdoor);
			$("#t_UserName").val(outdoor.outdoorName);
			$("#outdoorScreenSize").val(outdoor.outdoorScreenSize);
			$("#outdoorPlaybackPeriod").val(outdoor.outdoorPlaybackPeriod);
			$("#outdoorPlayStartTime").val(outdoor.outdoorPlayStartTime);
			$("#outdoorPlayEndTime").val(outdoor.outdoorPlayEndTime);
			$("#outdoorLength").val(outdoor.outdoorLength);
			$("#outdoorHeight").val(outdoor.outdoorHeight);
			$("#outdoorAddress").val(outdoor.outdoorAddress);
			$("#outdoorSuperiority").text(outdoor.outdoorSuperiority);
			$("#outdoorRemark").text(outdoor.outdoorRemark);
			
			
			$("#select_screen span:first").html(outdoor.outdoorScreenType);
			
			
			
			$("#province_div div:first").html(outdoor.outdoorProvince);
			$("#city_div div:first").html(outdoor.outdoorCity);
			$("#area_div div:first").html(outdoor.outdoorCountry);
			$("#select_type span:first").html(outdoor.outdoorMediasourceType);
			console.log($("#outdoorScreenSize").val());
		}else{
			alert(result.msg);
		}
	});
}

function amendBtn(){
	console.log($("#form1").serialize());
	
	
	//media-success.html
}



