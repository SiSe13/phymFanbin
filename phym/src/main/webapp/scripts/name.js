var SUCCESS = 0
$(function(){
	funName();	
	inforMation();
});

//页面加载显示用户名
function funName(){
	$("#userName").text(getCookie("username"));
}

//退出
function dropOut(){
	var url="purpose/exit.do";
	var data={userId:getCookie("userId")};
	$.post(url,data,function(){
		window.location.href = "../login.html";	
	});
	
}

//页面加载显示代理商名称
function  inforMation(){
	var url ="purpose/userId.do";
	var data={userId:getCookie("userId")};
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			if(null==result.data.agencyName){
				$(".dailishangmicheng").text("所属代理商 : "+"谱华云媒");
			}else{
				$(".dailishangmicheng").text("所属代理商 : "+result.data.agencyName);
			}
		}else{
			alert(result.msg);
		}
	});
}