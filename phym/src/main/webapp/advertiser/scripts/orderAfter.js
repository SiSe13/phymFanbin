var SUCCESS=0;
$(function(){
	orderForm();
});

//查询所有订单
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

//显示订单
function showdingdang(list){
	var li = dingdan.replace('number',list.number)
					.replace("number1",list.number)
					.replace('videoName1',list.videoName)
					.replace('videoName',list.videoName)
					.replace('startTime',list.startTime)
					.replace('endTime',list.endTime)
					.replace('cost',list.cost)
					.replace('orderType',switchType(list.orderType));
	$(".tbody").append(li);
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


var  dingdan='<tr style="width: 100%;">  '+                                          
				'<td id="id1" >'+'number'+'</td>'+
					'<td ><a href="#" title="'+
					'videoName1'+'" style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 100px;">'+
					'videoName'+'</a></td>'+
					'<td class="am-hide-sm-only-time" >'+
					'startTime'+'~'+'endTime'+'</td>'+
					'<td class="particulars" >'+
					'cost'+'</td>'+
					'<td class="am-hide-sm-only-shenhe"><span>'+
					'orderType'+'</span>'+
					'</td>'+
					'<td>'+
					'<input name="ok" type="button" id="ok" value="暂停" onClick="hao();" style="background-color: #fff;padding:4px 17px;border:1px solid #ddd;">'+
				'</td>'+
				'<td>'+
					'<div class="am-btn-toolbar"><div class="am-btn-group am-btn-group-xs">'+
					'<a href="javascript:void(0);"onclick=details("number1") class="am-icon-pencil-square-o">详情</a> '+
					'</div></div>'+
				'</td>';


function details(number){
    layer.open({
		type: 2,
		title: '详情页',
		shadeClose: true,
		shade: 0.8,
		area: ['1100px', '48%'],
		content: 'order-after-details.html?number='+number //url
		});
}


