var SUCCESS=0;
var arr=new Array(); //新建一个数组

$(function(){
	var url=window.location.href;	  //获取当前页面的url
	var b=url.split("?")[1]; //获取第一个参数以后的内容 
	var c=b.split("&");   //从指定的地方将字符串分割成字符串数组
	for(var i=0;i<c.length;i++){
	 	 var d=c[i].split("=")[1]; //从=处将字符串分割成字符串数组,并选择第2个元素
	         arr.push(decodeURI(d));	 //将获取的元素存入到数组中	
	}
	findOrderDetails();
});

function findOrderDetails(){
	var url="outdoor/rderIndent.do";
	var data={number:arr[0]};
	$.post(url,data,function(result){
		 if(result.status == SUCCESS){
			 showOrderDetails(result.data);
		 }else{
			 alert(result.msg);
		 }
	});
}

function showOrderDetails(list){
	var li=orderDetails.replace('number',list[0])
						.replace('videoName',list[1])
						.replace('createTime',dataHoutai(list[8]))
						.replace('cost',list[11])
						.replace('startTime',list[2])
						.replace('endTime',list[3])
						.replace('duration',list[5])
						.replace('orderType',switchType(list[6]))
						.replace('qtRemark',list[10])
						.replace('auditName',list[14])
						.replace('auditTime',dataHoutai(list[13]))
						.replace('htRemark',list[12]);
	$("#tbody").append(li);
}

function tanchu(){
	window.location.href ="loading-outdoor.html?number="+arr[0];
}

//时间格式化
function dataHoutai(data){
	date = new Date(data);
	Y = date.getFullYear() + '-';
	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	D = date.getDate() + ' ';
	h = date.getHours() + ':';
	m = date.getMinutes() + ':';
	s = date.getSeconds(); 
	date=Y+M+D+h+m+s
	return date;
}

function switchType(n){
	switch(n){
	case 0:
		orderType="审核中";
	  break;
	case 1:
		orderType="审核通过";
	  break;
	case 2:
		orderType="审核已拒绝";
		break;
	case 3:
		orderType="已支付";
		break;
	case 4:
		orderType="未支付";
		break;
	}
	return orderType;
}

var orderDetails='<tr ><td style="height:35px;"><span style="font-weight:bold;font-size: 12px;">下单/投放时间/价格</span></td></tr>'+
				'<tr>'+
					'<td >订单：<span>'+'number'+'</span></td>'+
					'<td >广告名称：<span>'+'videoName'+'</span></td>'+
					'<td style="width: 25%;">价格：<span>'+'cost'+'</span> 元</td>'+
				'</tr><tr></tr>'+
				'<tr>'+
					  '<td style="width: 30%;">下单时间：<span>'+'createTime'+'</span></td>'+
					  '<td style="width: 35%;">投放时间：<span>'+'startTime'+'～'+'endTime'+'</span></td>'+    
				'</tr><tr></tr><tr></tr>'+
				'<tr >'+
					'<td style="height:2px; border-bottom:1px solid #ccc;" colspan=5></td>'+
				'</tr>'+
				'<tr>'+
					'<td style="height:35px;"><span style="font-weight:bold;font-size: 12px;">播放周期/审核状态</span></td>'+
				'</tr>'+
				'<tr>'+
					'<td >播放时长：<span>'+'duration'+' 秒</span></td>'+
					'<td >订单状态：<span>'+'orderType'+'</span></td>'+
				'</tr>'+
				'<tr>'+
					'<td >审核人：<span>'+'auditName'+'</span></td>'+
					'<td >审核时间：<span>'+'auditTime'+'</span></td>'+
				'</tr>'+
				'<tr><td style="height:2px; border-bottom:1px solid #ccc;" colspan=5></td></tr><td style="height:35px;"><span style="font-weight: bold;font-size: 12px;">前台备注</span></td></tr>'+
				'<tr>'+
					'<td colspan=6><span>'+'qtRemark'+'</span></td>'+
				'</tr>'+
				'<tr><td style="height:2px; border-bottom:1px solid #ccc;" colspan=5></td></tr><td style="height:35px;"><span style="font-weight: bold;font-size: 12px;">后台备注</span></td></tr>'+
				'<tr>'+
					'<td colspan=6><span>'+'htRemark'+'</span></td>'+
				'</tr>'+
				'<tr >'+
					'<td style="height:2px; border-bottom:1px solid #ccc;" colspan=5></td>'+
				'</tr>';
