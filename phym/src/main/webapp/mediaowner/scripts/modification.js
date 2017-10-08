var SUCCESS = 0;
$(function(){
	showModification();
	$("#amendBtn").click(amendBtn);
	
});
var url=window.location.href;	  //获取当前页面的url
var len=url.length;   //获取url的长度值
var a=url.indexOf("=");   //获取第一次出现？的位置下标
var id=url.substr(a+1,len);   //截取问号之后的内容

//修改大屏信息
function showModification(){
	url="outdoor/findout.do";
	var data={"outDoorId":id};
	$.post(url,data,function(result){
		if(result.status == SUCCESS){
			var outdoor=result.data;
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
		}else{
			alert(result.msg);
		}
	});
}

//提交修改信息
function amendBtn(){
	var url="outdoor/modifyout.do";
	var data={outdoorId:id,outdoorName:$("#t_UserName").val(),outdoorScreenSize:$("#outdoorScreenSize").val(),outdoorPlaybackPeriod:$("#outdoorPlaybackPeriod").val(),
			outdoorPlayStartTime:$("#outdoorPlayStartTime").val(),outdoorPlayEndTime:$("#outdoorPlayEndTime").val(),outdoorLength:$("#outdoorLength").val(),
			outdoorHeight:$("#outdoorHeight").val(),outdoorScreenType:$("#select_screen span:first").html(),outdoorMediasourceType:$("#select_type span:first").html(),
			outdoorProvince:$("#province_div div:first").html(),outdoorCity:$("#city_div div:first").html(),outdoorCountry:$("#area_div div:first").html(),
			outdoorAddress:$("#outdoorAddress").val(),outdoorSuperiority:$("#outdoorSuperiority").text(),outdoorRemark:$("#outdoorRemark").text(),
			outdoorUserName:getCookie("username"),outdoorPhotoPath:getCookie("js")};
	$.post(url,data,function(result){
		if(result.status == SUCCESS){
			window.location.href="../mediaowner/media-modification-success.html";
		}else{
			alert(result.msg);
		}
	});
	
	

}


