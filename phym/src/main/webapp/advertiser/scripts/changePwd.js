var SUCCESS=0;
$(function(){
	checkName();
	$("#oldpass").blur(checkOldPass);
	$("#newpass").blur(checkNewPass);
	$("#newpassAgain").blur(checkNewPassAgain);
	$("#submit").click(submit);
});

function checkName(){
	$(".username").text(getCookie("username"));
}

function checkOldPass(){
	$("#oldpassTip").empty();
	if($("#oldpass").val()==""){
		$("#oldpassTip").text("请填写您的旧密码");
		return false;
	}
	return true;
}

function checkNewPass(){
	$("#newpassTip").empty();
	if($("#newpass").val()==""){
		$("#newpassTip").text("请填写新密码");
		return false;
	}
	return true;
}

function checkNewPassAgain(){
	$("#newpassAgainTip").empty();
	if($("#newpassAgain").val()==""||$("#newpassAgain").val()!=$("#newpass").val()){
		$("#newpassAgainTip").text("请重新填写您的新密码,与新密码不匹配");
		return false;
	}
	return true;
}
function submit(){
	var n=checkOldPass()+checkNewPass()+checkNewPassAgain();
	if(n!=3){
		return;
	}
	var url="userCommon/checkpassword.do";
	var data={"user_nickname":$(".username").text(),"user_password":$("#oldpass").val(),"newpass":$("#newpass").val(),"newpassAgain":$("#newpassAgain").val()};
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			console.log(result.data);
			console.log(111111111);
		}else{
			alert(result.msg);
		}
	});
	
}