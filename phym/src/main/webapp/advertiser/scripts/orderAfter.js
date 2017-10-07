var SUCCESS=0;
var date=null;
$(function(){
	orderForm();
});

function orderForm(){
	var url="order/orderForm.do";
	var data={userId:getCookie("userId")}
	$.post(url,data,function(result){
		$(".tbody").empty();
		if(result.status==SUCCESS){
			var list=result.data;
			for(var i=0;i<list.length;i++){
				showdingdang(list[i])
			}
		}
	});
}

function showdingdang(list){
	var li = dingdan.replace('number',list.number)
					.replace('videoName1',list.videoName)
					.replace('videoName',list.videoName)
					.replace('startTime',list.startTime)
					.replace('endTime',list.endTime)
					.replace('cost',list.cost)
					.replace('orderType',switchType('orderType',list.orderType));
	$(".tbody").append(li);
}

function switchType(orderType,n){
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
}



function dataHoutai(data){
	date = new Date(data);
	Y = date.getFullYear() + '-';
	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	D = date.getDate() + ' ';
	h = date.getHours() + ':';
	m = date.getMinutes() + ':';
	s = date.getSeconds(); 
	date=Y+M+D+h+m+s
}

var  dingdan='<tr style="width: 100%;">  '+                                          
'<td id="id1" >'+'number'+'</td>'+
	'<td ><a href="#" title="'+
	'videoName1'+'" style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 100px;">'+
	'videoName'+'</a></td>'+
	'<td class="am-hide-sm-only-time" >'+
	'startTime'+'~'+'endTime'+'</td>'+
	'<td class="particulars" >'+
	'cost'+'</td>'+
	'<td class="am-hide-sm-only-shenhe"><span style="display: none;">'+
	'orderType'+'</span>'+
	'</td>'+
	'<td>'+
	'<input name="ok" type="button" id="ok" value="暂停" onClick="hao();" style="background-color: #fff;padding:4px 17px;border:1px solid #ddd;">'+
'</td>'+
'<td>'+
	'<div class="am-btn-toolbar"><div class="am-btn-group am-btn-group-xs">'+
	'<a href="javascript:void(0);"  class="am-icon-pencil-square-o">详情</a> '+
	'</div></div>'+
'</td>';



