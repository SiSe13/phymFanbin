var SUCCESS = 0;
var timerB=60;
$(function(){
	//点击发送验证码
	//$("#verifyYz").click(sendCode);
	//点击提交
	$("#btn_part2").click(changePassword);
	//检测手机号
	$("#phone").blur(checkPhone);
	//默认选中
	$("#phone").select();
	
});

//点击发送验证码
function sendCode(){
	var phone = $("#phone").val().trim();
	$.ajax({
		url:"/user/send.do",
		type:"post",
		data:{"phone":phone},
		dataType:"json",
		success:function(result){
			if(result.status == SUCCESS){
				$(".name_verifyNo span").text("发送成功");
			}else{
				$(".name_verifyNo span").text(result.msg);
			}
		},
		error:function(){
			alert("发送失败");
		}
	});
};

function MysendVerify() {
	var a = this;
	
	var j;
	$("#verifyYz").text("发送验证码").hide();
	$("#time_box").text("10 s后可重发").show();
	if (timerB === 0) {
		clearTimeout(j);
		timerB = 60;
		var b = /^1([^01269])\d{9}$/;
		if (!b.test($("#phone").val())) {
			$("#time_box").text("发送验证码")
		} else {
			$("#verifyYz").show();
			$("#time_box").hide()
		}
		return
	}
	$("#time_box").text(timerB + " s后可重发");
	timerB--;
	//console.log(timerB)
	j = setTimeout(function() {
		a.MysendVerify()
	}, 1000)
}



//检测手机号
function checkPhone(){
	//console.log(123456);
	var phone = $("#phone").val().trim();
	$(".name_phone span").text("");
	$.ajax({
		url:"/user/checkphone.do",
		type:"post",
		data:{"phone":phone},
		dataTpye:"json",
		success:function(result){
			if(result.status == SUCCESS){
				$(".name_phone").parent().find("label:first").removeClass('hide');
				$('#verifyYz').bind("click",function(){
					var phone = $("#phone").val().trim();
					$.ajax({
						url:"/user/send.do",
						type:"post",
						data:{"phone":phone},
						dataType:"json",
						success:function(result){							
							if(result== 2){								
								$(".name_verifyNo span").text("发送成功");
								$(".name_verifyNo span").css({"color":"red","height":"34px","line-height":"34px"});
								MysendVerify();
							}else{
								
								$(".name_verifyNo span").text("网络异常，失败");
								$(".name_verifyNo span").css({"color":"red","height":"34px","line-height":"34px"});
							}
						},
						error:function(){
							alert("发送失败");
						}
					});
					
				}); 
				
			}else{
				$(".name_phone").parent().find("label:first").addClass('hide');
				$(".name_phone span").text(result.msg);
				$(".name_phone span").css({"color":"red","height":"34px","line-height":"34px"});
				$("#verifyYz").unbind("click");
			}
		},
		error:function(){
			alert("检测失败");
		}
	});
	
	
	
}

//修改密码
function changePassword(){
	if(!verifyCheck._click()) return;
	var phone = $("#phone").val().trim();					
	var auth_code = $("#verifyNo").val().trim();
	var password = $("#password").val().trim();
	var rePassword = $("#rePassword").val().trim();		
		$.ajax({
			url:"/user/authcode.do",
			type:"post",
			data:{"phone":phone,"auth_code":auth_code,"password":password,"rePassword":rePassword},
			dataType:"json",
			success:function(result){
				if(result.status == SUCCESS){
					$(".part2").hide();
					$(".part4").show();
					$(".step li").eq(1).addClass("on");
					countdown({
			             maxTime:10,
			             ing:function(s){
			                 $("#times").text(s);
			             },
			             after:function(){
			                 window.location.href="login.html";      
			             }
			         });
				}else{
					$(".name_verifyNo span").text(result.msg);
					$(".name_verifyNo span").css({"color":"red","height":"34px","line-height":"34px"});
				}
			},
			error:function(){
				alert("修改密码失败");
			}
		});
};