var SUCCESS=0;
$(function(){
	$("#name").select();
	$("#outdoorScreenSize").blur(Authentication);
	$("#outdoorPlaybackPeriod").blur(Authentication);
	$("#outdoorPlayStartTime").blur(Authentication);
	$("#outdoorPlayEndTime").blur(Authentication);
	$("#outdoorLength").blur(Authentication);
	$("#outdoorHeight").blur(Authentication);
	$("#address").blur(Authentication);
	$("#select_type span:first").blur(Authentication);
	$("#province_div div:first").blur(Authentication);
	$("#city_div div:first").blur(Authentication);
	$("#area_div div:first").blur(Authentication);
	$("#select_type span:first").blur(Authentication);
	$("#amendBtn").click(amendBtn);
});

function screen(){
	var n=$("#screen").val();
	return n;
}
function type(){
	var s=$("#type").val();
	return s;
}

function Authentication(){
	 outdoorName=$("#name").val();
	 outdoorAddress=$("#address").val();
	 province=$("#province_div div:first").html();
	 city=$("#city_div div:first").html();
	 area=$("#area_div div:first").html();
	 outdoorScreenSize=$("#outdoorScreenSize").val();
	 outdoorPlaybackPeriod=$("#outdoorPlaybackPeriod").val();
	 outdoorPlayStartTime=$("#outdoorPlayStartTime").val();
	 outdoorPlayEndTime=$("#outdoorPlayEndTime").val();
	 outdoorLength=$("#outdoorLength").val();
	 outdoorHeight=$("#outdoorHeight").val();
	 outdoorScreenType=screen();
	 outdoorMediasourceType=type();
	 outdoorPhotoPath=getCookie("js");
	 
	var reg=/^[0-9]*$/;
	if(outdoorName==""||!reg.test(outdoorScreenSize)||outdoorScreenSize==""||outdoorScreenSize==0||!reg.test(outdoorPlaybackPeriod)||outdoorPlaybackPeriod==""||outdoorPlaybackPeriod==0||
			!reg.test(outdoorPlayStartTime)||outdoorPlayStartTime==""||outdoorPlayStartTime==0||
			!reg.test(outdoorPlayEndTime)||outdoorPlayEndTime==""||outdoorPlayEndTime==0||
			!reg.test(outdoorLength)||outdoorLength==""||outdoorLength==0||
			!reg.test(outdoorHeight)||outdoorHeight==""||outdoorHeight==0){
		$("#amendBtn").attr("disabled","disabled");
	}else{
		$("#amendBtn").removeAttr('disabled');
	}
	
}

function amendBtn(){
		outdoorScreenType=screen();
		outdoorMediasourceType=type();
			var url="mtout/outdoor.do";
			var data={outdoorName:$("#name").val(),outdoorScreenSize:$("#outdoorScreenSize").val(),outdoorPlaybackPeriod:$("#outdoorPlaybackPeriod").val(),
					outdoorPlayStartTime:$("#outdoorPlayStartTime").val(),outdoorPlayEndTime:$("#outdoorPlayEndTime").val(),outdoorLength:$("#outdoorLength").val(),
					outdoorHeight:$("#outdoorHeight").val(),outdoorScreenType:outdoorScreenType,outdoorMediasourceType:outdoorMediasourceType,
					outdoorProvince:$("#province_div div:first").html(),outdoorCity:$("#city_div div:first").html(),outdoorCountry:$("#area_div div:first").html(),
					outdoorAddress:$("#address").val(),outdoorSuperiority:$("#outdoorSuperiority").text(),outdoorRemark:$("#outdoorRemark").text(),
					outdoorUserName:getCookie("username"),outdoorPhotoPath:getCookie("js")};
			$.post(url,data,function(result){
				if(result.status == SUCCESS){
					window.location.href="../mediaowner/media-success.html";
				}else{
					alert(result.msg);
				}
			});
			
			
}