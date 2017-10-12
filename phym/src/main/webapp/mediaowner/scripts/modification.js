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
	url="mtout/findout.do";
	var data={"outDoorId":id};
	$.post(url,data,function(result){
		if(result.status == SUCCESS){
			var outdoor=result.data;
			$("#name").val(outdoor.outdoorName);
			$("#outdoorScreenSize").val(outdoor.outdoorScreenSize);
			$("#outdoorPlaybackPeriod").val(outdoor.outdoorPlaybackPeriod);
			$("#outdoorPlayStartTime").val(outdoor.outdoorPlayStartTime);
			$("#outdoorPlayEndTime").val(outdoor.outdoorPlayEndTime);
			$("#outdoorLength").val(outdoor.outdoorLength);
			$("#outdoorHeight").val(outdoor.outdoorHeight);
			$("#address").val(outdoor.outdoorAddress);
			$("#outdoorSuperiority").text(outdoor.outdoorSuperiority);
			$("#outdoorRemark").text(outdoor.outdoorRemark);
			$("#province_div div:first").html(outdoor.outdoorProvince);
			$("#city_div div:first").html(outdoor.outdoorCity);
			$("#area_div div:first").html(outdoor.outdoorCountry);
			
		}else{
			alert(result.msg);
		}
	});
}

function screen(){
	var n=$("#screen").val();
	return n;
}
function type(){
	var s=$("#type").val();
	return s;
}

//提交修改信息
function amendBtn(){
	outdoorScreenType=screen();
	outdoorMediasourceType=type();
	var url="mtout/modifyout.do";
	var data={outdoorName:$("#name").val(),outdoorScreenSize:$("#outdoorScreenSize").val(),outdoorPlaybackPeriod:$("#outdoorPlaybackPeriod").val(),
			outdoorPlayStartTime:$("#outdoorPlayStartTime").val(),outdoorPlayEndTime:$("#outdoorPlayEndTime").val(),outdoorLength:$("#outdoorLength").val(),
			outdoorHeight:$("#outdoorHeight").val(),outdoorScreenType:outdoorScreenType,outdoorMediasourceType:outdoorMediasourceType,
			outdoorProvince:$("#province_div div:first").html(),outdoorCity:$("#city_div div:first").html(),outdoorCountry:$("#area_div div:first").html(),
			outdoorAddress:$("#address").val(),outdoorSuperiority:$("#outdoorSuperiority").text(),outdoorRemark:$("#outdoorRemark").text(),
			outdoorId:id,outdoorPhotoPath:getCookie("js")};
	$.post(url,data,function(result){
		if(result.status == SUCCESS){
			window.location.href="../mediaowner/media-modification-success.html";
		}else{
			alert(result.msg);
		}
	});
}


