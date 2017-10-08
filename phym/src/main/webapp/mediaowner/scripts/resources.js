var SUCCESS=0;
$(function(){
	$("#t_UserName").select();
	$("#outdoorScreenSize").blur(Authentication);
	$("#outdoorPlaybackPeriod").blur(Authentication);
	$("#outdoorPlayStartTime").blur(Authentication);
	$("#outdoorPlayEndTime").blur(Authentication);
	$("#outdoorLength").blur(Authentication);
	$("#outdoorHeight").blur(Authentication);
	$("#outdoorAddress").blur(Authentication);
	$("#select_type span:first").blur(Authentication);
	$("#province_div div:first").blur(Authentication);
	$("#city_div div:first").blur(Authentication);
	$("#area_div div:first").blur(Authentication);
	$("#select_type span:first").blur(Authentication);
	$("#amendBtn").click(amendBtn);
});


function Authentication(){
	 outdoorName=$("#t_UserName").val();
	 outdoorScreenSize=$("#outdoorScreenSize").val();
	 outdoorPlaybackPeriod=$("#outdoorPlaybackPeriod").val();
	 outdoorPlayStartTime=$("#outdoorPlayStartTime").val();
	 outdoorPlayEndTime=$("#outdoorPlayEndTime").val();
	 outdoorLength=$("#outdoorLength").val();
	 outdoorHeight=$("#outdoorHeight").val();
	 province=$("#province_div div:first").html();
	 city=$("#city_div div:first").html();
	 area=$("#area_div div:first").html();
	 outdoorScreenType=$("#select_screen span:first").html();
	 outdoorMediasourceType=$("#select_type span:first").html();
	 outdoorAddress=$("#outdoorAddress").val();
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
			var url="outdoor/outdoor.do";
			var data={outdoorName:$("#t_UserName").val(),outdoorScreenSize:$("#outdoorScreenSize").val(),outdoorPlaybackPeriod:$("#outdoorPlaybackPeriod").val(),
					outdoorPlayStartTime:$("#outdoorPlayStartTime").val(),outdoorPlayEndTime:$("#outdoorPlayEndTime").val(),outdoorLength:$("#outdoorLength").val(),
					outdoorHeight:$("#outdoorHeight").val(),outdoorScreenType:$("#select_screen span:first").html(),outdoorMediasourceType:$("#select_type span:first").html(),
					outdoorProvince:$("#province_div div:first").html(),outdoorCity:$("#city_div div:first").html(),outdoorCountry:$("#area_div div:first").html(),
					outdoorAddress:$("#outdoorAddress").val(),outdoorSuperiority:$("#outdoorSuperiority").text(),outdoorRemark:$("#outdoorRemark").text(),
					outdoorUserName:getCookie("username"),outdoorPhotoPath:getCookie("js")};
			$.post(url,data,function(result){
				if(result.status == SUCCESS){
					boolean=result.data;
					window.location.href="../mediaowner/media-success.html";
				}else{
					alert(result.msg);
				}
			});
			
			
}