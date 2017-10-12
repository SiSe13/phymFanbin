var SUCCESS=0;
var zongjia=0;
var mediasArray=new Array()
$(function(){
	danjian();
	$("#videoname").blur(checkName);
	$("#videoname").select();
	$(".time").html(getCookie("bofangshichang"));
});

// 通过id查询单价和播放周期
function danjian(){
	var url="outdoor/findoutScreencontent.do";
	var data={outDoorId:getCookie("gwc")};
	$.post(url,data,function(result){
		if(result.status == SUCCESS){
			var list=result.data;
			for(var i=0;i<list.length;i++){
				var MediaObject = {'id': list[i].outdoorId,'price': list[i].outdoorUnitPrice,'period':list[i].outdoorFrequency}
				mediasArray[i]=MediaObject;
			}
		}
	});
}


//便利数组，并查询出单价
function jisuanjige(){
	var bofang_time=getCookie("bofangshichang")
	date = new Date(Date.parse($("#J_DepDate").val()));
	data = new Date(Date.parse($("#J_EndDate").val()));
	start_time = date.getTime()/1000;
	end_time = data.getTime()/1000;
	var day=(end_time-start_time)/86400+1;
	
	for(var i=0;i<mediasArray.length;i++){
		if($("#end_time").val()!=""){
			if($("#start_time").val()!=""){
				zongjia+=parseInt(day)*parseInt(mediasArray[i]['period'])*parseInt(mediasArray[i]['price'])*parseInt(bofang_time);
				$(".price").html(zongjia);
			}
		}else{
			$(".price").html("");
		}
	}
}


//检测名称
function checkName(){
	$(".name_span").text("");
	var videoName = $("#videoname").val();
	var str = /^[一-龥a-zA-Z][一-龥a-zA-Z0-9_]*$/;
	if(videoName=="" || !str.test(videoName)){
		$(".name_span").text("请填写您的广告名称");
		$(".name_span").css({"color":"red","height":"34px","line-height":"34px"});
		return false;
	}
	return true;
};

//提交审核
//提交的onclick事件
function refersub(){
	var outDoorId = getCookie("gwc");
	var videoName = $("#videoname").val();
	var startTime = $("#J_DepDate").val();
	var endTime = $("#J_EndDate").val();
	var filePath = getCookie("js");
	var bofang_time=getCookie("bofangshichang")
	var remarks=$("#tremark").text();
	var price=$(".price").text();
	if(filePath==null){
		alert("请上传视频")
		return;
	}
	if(remarks == "请输入需要备注的信息!"){
		remarks = "";
	}
	$.ajax({
		url:"order/uploads.do",
		type:"post",
		data:{"videoName":videoName,"startTime":startTime,"endTime":endTime,"filePath":filePath,
			"duration":bofang_time,"remarks":remarks,"outDoorId":outDoorId,"cost":price,"userId":getCookie("userId")},
		dataType:"json",
		success:function(result){
			if(result.status==SUCCESS){
				var boolean=result.data;
				if(boolean){
					delCookie("gwc");
					window.location.href ="success.html";
				}else{
					alert(result.msg);
				}
			}
		},
		error:function(){
			alert("网络延迟，请重试！");
		}
	});
}