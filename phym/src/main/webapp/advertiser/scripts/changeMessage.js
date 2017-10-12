var SUCCESS=0;
$(function(){
	inforMation();
	$("#tijiao").click(updateUserInfo);
});
//页面加载显示完善资料信息
function  inforMation(){
	var url ="userInfo/userId.do";
	var data={userId:getCookie("userId")};
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			
			$("#touxiang").attr('src',result.data.headimg==null?"assets/img/user01.png":"http://img.puhuayunmei.com/"+result.data.headimg); 
			$("#iptName").val(result.data.name);
			$("#dizhi").val(result.data.addr);
			$("#zuoji").val(result.data.tel);
			$("#t_Email").val(result.data.email);
			$("#gsMingCheng").val(result.data.company);
			$("#agencyName").text(result.data.agencyName);
			if(null==result.data.agencyName){
				$("#agencyName").text("谱华云媒");
				$(".dailishangmicheng").text("所属代理商 : "+"谱华云媒");
			}else{
				$("#agencyName").text(result.data.agencyName);
				$(".dailishangmicheng").text("所属代理商 : "+result.data.agencyName);
			}
		}else{
			alert(result.msg);
		}
	});
}

//提交修改信息
function updateUserInfo(){
	console.log($("#zuoji").val());
	console.log($("#iptName").val());
	console.log($("#dizhi").val());
	console.log($("#t_Email").val());
	console.log($("#gsMingCheng").val());
	var filePath=getCookie("js");
	var url ="userInfo/updateUserInfo.do";
	var data={userId:getCookie("userId"),headimg:filePath,name:$("#iptName").val(),addr:$("#dizhi").val(),tel:$("#zuoji").val(),
			email:$("#t_Email").val(),company:$("#gsMingCheng").val()};
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			alert("修改成功");
		}else{
			alert(result.msg);
		}
	});
	
}



