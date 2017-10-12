var SUCCESS=0;
$(function(){
	var url=window.location.href;	  //获取当前页面的url
	var len=url.length;   //获取url的长度值
	var a=url.indexOf("=");   //获取第一次出现？的位置下标
	var id=url.substr(a+1,len);   //截取问号之后的内容
	url="purpose/findout.do";
	var data={outDoorId:id};
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			var li = result.data;
			showOutDoors(li);
		}else{
			alert(result.message);
		}
	});
});
var outDoorsTemplate='<table id="addCont" width="100%" border="0" cellspacing="0" cellpadding="0">'+
						'<tr>'+
							'<td width="10%" align="center"  class="box_td_left">媒体名称：</td>'+
								'<td width="30%" class="box_td_right">'+      
								'outdoorName'+'</td>'+
								'<td align="center" class="box_td_left">省市区（县）：</td>'+
									'<td width="20%" class="box_td_right">'+ 
									'outdoorProvince'+'outdoorCity'+'市'+'outdoorCountry'+'</td>'+ 
						'</tr>'+
						'<tr>'+
							'<td align="center" valign="top" class="box_td_left">地址：</td>'+
								'<td width="20%" class="box_td_right"  colspan="3">'+      
								'outdoorAddress'+'</td>'+
						'</tr>'+
						'<tr>'+
							'<td width="10%" align="center" valign="top" class="box_td_left" >单价：</td>'+
								'<td width="20%" class="box_td_right">'+
								'outdoorUnitPrice'+'</td>'+   
							'<td align="center" valign="top" class="box_td_left">状态：</td>'+
								'<td width="20%" class="box_td_right">'+      
								'outdoorStatus'+'</td>'+   
						'</tr>'+
						'<tr>'+
							'<td align="center" valign="top" class="box_td_left">屏幕类型：</td>'+
								'<td width="20%" class="box_td_right">'+    
									'outdoorScreenType'+'</td>'+
								'<td width="20%" align="center" valign="top" class="box_td_left">媒体属性：</td>'+
								'<td width="20%" class="box_td_right">'+      
								'outdoorMediasourceType' +'</td>'+
						'</tr>'+
						'<tr>'+
							'<td width="20%" align="center" valign="top" class="box_td_left">分辨率：</td>'+
								'<td width="20%" class="box_td_right">'+     
								'outdoorLength'+' x '+'outdoorHeight' +'</td>'+
							'<td align="center" valign="top" class="box_td_left">播放时间：</td>'+
								'<td width="20%" class="box_td_right">'+     
							'outdoorPlayStartTime'+':00-'+'outdoorPlayEndTime'+':00' +'</td>'+
						'</tr>'+
						'<tr>'+
						'<td align="center" valign="top" class="box_td_left">剩余时间：</td><td width="20%" class="box_td_right">'+     
						'<span>'+'remainTime'+'</span>秒</td>'+
							'<td align="center" valign="top" class="box_td_left">播放周期：</td>'+
							'<td width="20%" class="box_td_right">'+    
							'outdoorPlaybackPeriod' +'</td>'+
						'</tr>'+
						'<tr>'+
							'<td align="center" valign="top" class="box_td_left">优势：</td><td width="20%" class="box_td_right">'+     
						 'outdoorSuperiority' +'</td>'+
							'<td align="center" valign="top" class="box_td_left">所有者：</td><td width="20%" class="box_td_right" >'+      
							'outdoorUserName' +'</td>'+
						'</tr>'+
						   '<tr></tr>'+
						'<tr>'+
							'<td align="center" valign="top" class="box_td_left">备注：</td><td width="20%" class="box_td_right"  colspan="3">'+     
							'outdoorRemark'+'</td>'+
						'</tr>'+
						'<tr>'+
							'<td align="center" valign="top" class="box_td_left" style="padding-top: 45px;">照片：</td><td width="20%" class="box_td_right"  colspan="3">'+      
								'<img src="http://img.puhuayunmei.com/'+
								'outdoorPhotoPath'+'" alt="" style="width:100px;height:100px; float: left;margin-right: 5px"/ >'+
							'</td>'+
						'</tr>'+      
					'</table>';
function showOutDoors(li){
	 var li = outDoorsTemplate.replace('outdoorName',li.outdoorName)
 								.replace('outdoorProvince',li.outdoorProvince)
 								.replace('outdoorCity',li.outdoorCity)
 								.replace('outdoorCountry',li.outdoorCountry)
								.replace('outdoorAddress',li.outdoorAddress)
								.replace('outdoorUnitPrice',li.outdoorUnitPrice)
								.replace('outdoorStatus',li.outdoorStatus==0?'正常':'异常')
								.replace('outdoorScreenType',li.outdoorScreenType)
								.replace('outdoorMediasourceType',li.outdoorMediasourceType)
								.replace('outdoorLength',li.outdoorLength)
								.replace('outdoorHeight',li.outdoorHeight)
								.replace('outdoorPlayStartTime',li.outdoorPlayStartTime)
								.replace('outdoorPlayEndTime',li.outdoorPlayEndTime)
								.replace('remainTime',li.remainTime)
								.replace('outdoorPlaybackPeriod',li.outdoorPlaybackPeriod)
								.replace('outdoorSuperiority',li.outdoorSuperiority)
								.replace('outdoorUserName',li.outdoorUserName)
								.replace('outdoorRemark',li.outdoorRemark)
							    .replace('outdoorPhotoPath',li.outdoorPhotoPath);
//绑定每个笔记本的ID到li元素上
$('.login_box').append(li);
}