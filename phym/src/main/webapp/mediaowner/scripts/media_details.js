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
	
	RderIndent();
	MediaDetails();
});

//通过订单编号查询
function RderIndent(){
	 url="mtout/rderIndent.do";
	 var data={number:arr[0]};
	 $.post(url,data,function(result){
		 if(result.status == SUCCESS){
			
			showorderIndent(result.data)
		 }else{
			 alert(result.msg);
		 }
	 });
}

//通过大屏id查询
function MediaDetails(){
	 url="mtout/findout.do";
	 var data={outDoorId:arr[1]};
	 $.post(url,data,function(result){
		 if(result.status == SUCCESS){
			showmediaDetails(result.data)
		 }else{
			 alert(result.msg);
		 }
	 });
}


function showmediaDetails(list){
	var li = mediaDetails.replace('outdoorName',list.outdoorName)
						.replace('outdoorAddress',list.outdoorAddress)
						.replace('outdoorMediasourceType',list.outdoorMediasourceType)
						.replace('outdoorScreenType',list.outdoorScreenType)
						.replace('mediaCost',arr[2])
						
		$('.tbody').append(li);
}


function showorderIndent(list){
	var li = orderIndent.replace('number',list[0])
						.replace('videoName',list[1])
						.replace('mediaCost',arr[2])
						.replace('userName',list[9])
						.replace('startTime',list[2])
						.replace('endTime',list[3])
						.replace('duration',list[5])
						.replace('orderType',switchType(list[6]))
						.replace('videoType',list[4]);
	$('#tbody').append(li);
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

var mediaDetails= '<tr><td style="height:35px;background-color: #ccc;" colspan=9><span style="font-weight: bold;font-size: 12px;">大屏信息</span></td>'+
	  			  '</tr>'+
	  			  '<tr>'+
	  			  	'<th style="width:10%;">大屏名称：</th>'+
	  			  	'<th style="width:10%;">大屏地址：</th>'+
	  			  	'<th style="width:10%;">投放方式：</th>'+
	  			  	'<th style="width:10%;">屏幕类型：</th>'+
	  			  	'<th style="width:10%;">收入：</th>'+
	  			  '</tr>'+
	  			  '<tr>'+
	  			  	'<td style="height:2px; border-bottom:1px solid #ccc;" colspan=5></td>'+
	  			  '</tr>'+
	  			  '<tr>'+
	  			  	'<td align="center">'+'outdoorName'+'</td>'+
	  			  	'<td align="center">'+'outdoorAddress'+'</td>'+
	  			  	'<td align="center">'+'outdoorMediasourceType'+'</td>'+
	  			  	'<td align="center">'+'outdoorScreenType'+'</td>'+
	  			  	'<td align="center">'+'mediaCost'+'元</td>'+
	  			  '</tr>';
	
 var orderIndent='<tr ><td style="height:35px;"><span style="font-weight: bold;font-size: 12px;">广告名称/所属广告主/总收入/投放时间</span></td>'+
 				'</tr>'+
 				'<tr>'+
 					'<td>订单编号：<span>'+'number'+'</span></td>'+
 					'<td >广告名称：<span>'+'videoName'+'</span></td>'+
 					'<td >总收入(元)：<span>'+'mediaCost'+'</span></td>'+
 					'<td >所属广告主：<span>'+'userName'+'</span></td>'+
 				'</tr>'+
 				'<tr>'+
 					'<td>投放时间：<span>'+'startTime'+'～'+'endTime'+'</span></td>'+
 				'</tr>'+
 				'<tr></tr>'+
 				'<tr>'+
 					'<td style="height:2px; border-bottom:1px solid #ccc;" colspan=5></td>'+
 				'</tr>'+
 					'<td style="height:35px;"><span style="font-weight: bold;font-size: 12px;">播放周期/审核状态</span></td>'+
 				'<tr>'+
 					'<td >播放时长：<span>'+'duration'+'秒</span></td>'+
 					'<td >订单状态：<span>'+'orderType'+'</span></td>'+
 				'</tr>'+
 				'<tr><td style="height:2px; border-bottom:1px solid #ccc;" colspan=5></td></tr>'+
 					'<td style="height:35px;"><span style="font-weight: bold;font-size: 12px;">下载视频</span></td>'+
 				'<tr>'+
 					'<td>下载：<a href="'+
 					'videoType'+'" style="padding:4px 15px;background-color:#337ab7;border-radius: 5px;color:#fff;text-decoration: none;">下载视频</a></td>'+
 					'<td></td>'+
 				'</tr>'+
 				'<tr>'+
 					'<td style="height:2px; border-bottom:1px solid #ccc;" colspan=5></td>'+
 				'</tr>';      
	    
	   
	      
	  

