var SUCCESS = 0;

$(function(){
	$("#logbtn").click(userGGLogin);
	$("#Mediabtn").click(userMTLogin);
});

function userGGLogin(){
	//获取用户名
	var name = $("#txtUser").val().trim();
	//获取密码
	var password = $("#Userpwd").val().trim();
	var ok=true;
	if(name ==""){
		ok=false;
		return;
	}
	if(password == ""){
		ok=false;
		return;
	}

	var url="user/login.do";
	var data={"name":name,"password":password};
	if(ok){
		$.post(url,data,function(result){
				if(result.state == SUCCESS){
					window.location.href = "edit.html";
				}else{
					$(".tishi").show().text(result.message);
				}
		});
	}
}

function userMTLogin(){
	//获取用户名
	var name = $("#txtMedia").val().trim();
	//获取密码
	var password = $("#Mediapwd").val().trim();
	var ok=true;
	if(name ==""){
		ok=false;
		return;
	}
	if(password == ""){
		ok=false;
		return;
	}
	var url="user/media.do";
	var data={"name":name,"password":password};
	if(ok){
		$.post(url,data,function(result){
				if(result.state == SUCCESS){
					window.location.href = "log_in.html";
				}else{
					$(".tishi").show().text(result.message);
				}
		});
	}
}



