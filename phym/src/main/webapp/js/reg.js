var SUCCESS = 0
$(function(){
	$("#btn_part1").click(ButtonPart);
	$("#verifyYz").click(VeriFyz);
	$("#btn_part2").click(ButtonRegister);
	$("#adminNo").blur(checkName);
	$("#phone").blur(checkPhone);
	$("#adminNo").select();
});

function ButtonPart(){
	if(!verifyCheck._click()) return;
	var phone=$("#phone").val();
	$(".c-phone").text(phone);
}

//检测手机号
function checkPhone(){
	var phone=$("#phone").val();
	var url="user/checkphone_r.do";
	var data={phone:phone};
	$(".phonespan span").empty();
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			$(".phonespan").parent().find("label:first").removeClass('hide');
			$("#btn_part1").removeAttr('disabled');
		}else{
			$("#btn_part1").attr("disabled","disabled");
			$(".phonespan").parent().find("label:first").addClass('hide');
			$(".phonespan span").text(result.msg);
			$(".phonespan span").css({"color":"red","height":"34px","line-height":"34px"});
		}
	});
}

//检查用户名
function checkName(){
	var name=$("#adminNo").val();
	var url="user/checkname.do";
	var data={name:name};
	$(".namespan span").empty();
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			$(".namespan").parent().find("label:first").removeClass('hide');
			$("#btn_part1").removeAttr('disabled');
		}else{
			$("#btn_part1").attr("disabled","disabled");
			$(".namespan").parent().find("label:first").addClass('hide');
			$(".namespan span").text(result.msg);
			$(".namespan span").css({"color":"red","height":"34px","line-height":"34px"});
		}
	});
}

function VeriFyz(){
	var phone=$("#phone").val();
	var url="user/send.do";
	var data={phone:phone};
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			$(".errorspan span").text("发送成功");
		}else{
			$(".errorspan span").text(result.msg);
		}
	});
}

//注册
function ButtonRegister(){
		var name=$("#adminNo").val();
		var phone=$("#phone").val();
		var password=$("#password").val();
		var confirm=$("#rePassword").val();
		var type=$('input:radio:checked').val();
		var verifyNo=$("#verifyNo").val();
		
		var url="user/register.do";
		var data={name:name,phone:phone,password:password,confirm:confirm,type:type,verifyNo:verifyNo};
		$(".errorspan span").empty();
		$.post(url,data,function(result){
			if(result.status==SUCCESS){
				$(".part2").hide();
				$(".part3").show();
		        $(".part4").show();	
		        $(".step li").eq(2).addClass("on");
		        countdown({
		            maxTime:10,
		             ing:function(c){
		                 $("#times").text(c);
		             },
		             after:function(){
		                window.location.href="login.html";      
		          }
		         });
			}else{
				if(!verifyCheck._click()) return;
				$(".errorspan span").text(result.msg);
				$(".errorspan span").css({"color":"red","height":"34px","line-height":"34px"});
			}
		});
}