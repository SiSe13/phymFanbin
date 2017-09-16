var SUCCESS = 0;

$(function(){
	//点击提交
	$("#btn_part2").click(changePassword);
	//检测手机号
	$("#phone").blur(checkPhone);
	//点击发送验证码
	//$("#verifyYz").click(sendCode);
	
});

//点击发送验证码
function sendCode(){
	var phone = $("#phone").val().trim();
	var url="user/phone.do";
	var data={"phone":phone};
	$.post(url,data,function(result){
			if(result.data != 2){
				onclick = "return fasle";
			}
	});
}

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
	var phone = $("#phone").val().trim();
	$(".name_phone span").empty();
	var url="user/changephone.do";
	var data={"phone":phone};
	$.post(url,data,function(result){
		if(result.state == SUCCESS){
			$(".name_phone").parent().find("label:first").removeClass('hide');
			$('#verifyYz').bind("click",function(){
				var phone = $("#phone").val().trim();
				var url="user/phone.do";
				var data={"phone":phone};
				$.post(url,data,function(result){
						if(result == 2){
							$(".name_verifyNo span").text("发送成功");
							$(".name_verifyNo span").css({"color":"red","height":"34px","line-height":"34px"});
							MysendVerify();
						}else{
							$(".name_verifyNo span").text("网络异常，失败");
							$(".name_verifyNo span").css({"color":"red","height":"34px","line-height":"34px"});
						}
				});
			}); 
		}else{
			$(".name_phone").parent().find("label:first").addClass('hide');
			$(".name_phone span").text(result.message);
			$(".name_phone span").css({"color":"red","height":"34px","line-height":"34px"});
			$("#verifyYz").unbind("click")
		}
	});
}

//修改密码
function changePassword(){
	if(!verifyCheck._click()) return;
	var phone = $("#phone").val().trim();					
	var verifyNo = $("#verifyNo").val().trim();
	var password = $("#password").val().trim();
	var rePassword = $("#rePassword").val().trim();
	
	var url="user/authcode.do";
	var data={"phone":phone,"verifyNo":verifyNo,"password":password,"rePassword":rePassword};
	
	$.post(url,data,function(result){
		if(result==1){
			if(!verifyCheck._click()) return;
			$(".part2").hide();
			$(".part4").show();
	        $(".step li").eq(1).addClass("on");
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
			alert(result.message);
		}		
	});
}