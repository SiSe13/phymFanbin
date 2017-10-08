var SUCCESS = 0;
$(function(){
	$("#logbtn").click(userGGLogin);
	$("#logbtn1").click(userMTLogin);
});


function userGGLogin(){
	//获取用户名
	var name = $("#txtUser").val().trim();
	//获取密码
	var password = $("#Userpwd").val().trim();
	var ok = true;
	if(name ==""){
		ok= false;
		return;
	}
	if(password == ""){
		ok= false;
		return;
	}
	
	if(ok){
		$.ajax({
			url:"user/gglogin.do",
			Type:"post",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(result){
				if(result.status == SUCCESS){
					var user = result.data;
					setCookie("userId",user.user_id);
					setCookie("username",user.user_nickname);
					window.location.href = "advertiser/index.html";														
				}else{
					$(".tishi").show().text(result.msg);
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
				   }
		});
	}
}

function userMTLogin(){
	//获取用户名
	var name = $("#txtUser1").val().trim();
	//获取密码
	var password = $("#Userpwd1").val().trim();
	var ok = true;
	if(name ==""){
		ok= false;
		return;
	}
	if(password == ""){
		ok= false;
		return;
	}
	
	if(ok){
		$.ajax({
			url:"user/mtlogin.do",
			Type:"post",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(result){
				if(result.status == SUCCESS){
					var user = result.data;
					setCookie("userId",user.user_id);
					setCookie("username",user.user_nickname);
					window.location.href = "mediaowner/index.html";										
				}else{
					$(".tishi").show().text(result.msg);
				}
			},
			error:function(result){					
				alert("登录失败");
			}
		});
	}
};



