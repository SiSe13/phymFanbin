$(function(){

	funName();	
	
});

//页面加载显示用户名
function funName(){
	$("#userName").text(getCookie("username"));
}

//退出
function dropOut(){
	window.location.href = "../login.html";	
}