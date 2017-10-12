var SUCCESS = 0;
$(function(){
	orderInquiry();
});

//页面加载订单
function orderInquiry(){
	var url="mtout/orderInquiry.do";
	var data={userId:getCookie("userId")};
	$.post(url,data,function(result){
		if(result.status == SUCCESS){
			list= result.data;
			for(var i=0;i<list.length;i++){
				showorderInquiry(list[i]);
			}
			
		}else{
			alert(result.msg);
		}
	});
}

function showorderInquiry(list){
	var li = outDoorsTemplate.replace('number',list.number)
							.replace("number1",list.number)
							.replace("mediaId",list.mediaId)
							.replace('videoName',list.videoName)
							.replace('videoName1',list.videoName)
							.replace('createTime',dataHoutai(list.createTime))
							.replace('mediaCost',list.mediaCost)
							.replace('mediaCost1',list.mediaCost)
							.replace('advertName',list.advertName)
							.replace('orderStatus',switchType(list.orderStatus));
//绑定每个笔记本的ID到li元素上
$('.tbody').append(li);
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
		orderStatus="审核中";
	  break;
	case 1:
		orderStatus="审核通过";
	  break;
	case 2:
		orderStatus="审核已拒绝";
		break;
	case 3:
		orderStatus="已支付";
		break;
	case 4:
		orderStatus="未支付";
		break;
	}
	return orderStatus;
}

//订单详情页
function details(number,mediaId,mediaCost){
	 layer.open({
	  type: 2,
	  title: '详情页',
	  shadeClose: true,
	  shade: 0.8,
	  area: ['900px', '62%'],
	  content: "media-indent-details.html?number="+number+"&mediaId="+mediaId+"&mediaCost="+mediaCost //url
	 });
}

var outDoorsTemplate='<tr style="width: 100%;">'+
    					'<td id="id1" >'+'number'+'</td>'+
    					'<td ><a href="javascript:void(0);" title="'+
    					'videoName'+'" style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 100px;">'+
    					'videoName1'+'</a></td>'+
    					'<td class="am-hide-sm-only-time" >'+
    					'createTime'+'</td>'+
    					'<td class="am-hide-sm-only-time" >'+
    					'mediaCost'+'</td>'+
    					'<td class="am-hide-sm-only-time" >'+
    					'advertName'+'</td>'+
    					'<td class="am-hide-sm-only-shenhe">'+
    						'<span style="display: block;">'+'orderStatus'+'</span>'+
    					'</td>'+
    					'<td>'+
    						'<div class="am-btn-toolbar"><div class="am-btn-group am-btn-group-xs">'+
    							'<a href="javascript:void(0);" onclick=details("number1","mediaId","mediaCost1") class="am-icon-pencil-square-o">详情</a>'+ 
    						'</div>'+
    						'</div>'+
    					'</td>'+
					'</tr>';

