var SUCCESS=0;
var b=null;
$(function(){
	var url=window.location.href;	  //获取当前页面的url
	 b=url.split("=")[1]; //获取第一个参数以后的内容 
	findNumber();
});

function findNumber(){
	var url="outdoor/dingdanxiangqing.do";
	var data={number:b};
	$.post(url,data,function(result){
		 if(result.status == SUCCESS){
			for(var i=0;i<result.data.length;i++){
				showLoadingOutdoor(result.data[i])
			}
		 }else{
			 alert(result.msg);
		 }
	});
	
}


function showLoadingOutdoor(list){
	var li=lodaing.replace('outdoorName',list.outdoorName)
					.replace('outdoorAddress',list.outdoorAddress)
					.replace('outdoorMediasourceType',list.outdoorMediasourceType)
					.replace('status',switchType(list.outdoorStatus))
					.replace('outdoorPlayStartTime',list.outdoorPlayStartTime)
					.replace('outdoorPlayEndTime',list.outdoorPlayEndTime)
					.replace('outdoorUserName',list.outdoorUserName)
					.replace('mediaCost',list.demo2);
		
		$("#tbody").append(li);
}


function switchType(n){
	switch(n){
	case 0:
		outdoorStatus="正常";
	  break;
	case 1:
		outdoorStatus="维护";
	  break;
	}
	return outdoorStatus;
}

var lodaing='<tr><td style="height:2px; border-bottom:1px solid #ccc;" colspan=7></td></tr>'+
	  		'<tr>'+
	  			'<td align="center">'+'outdoorName'+'</td>'+
				'<td align="center">'+'outdoorAddress'+'</td>'+
				'<td align="center">'+'outdoorMediasourceType'+'</td>'+
				'<td align="center">'+'status'+'</td>'+
				'<td align="center">'+'outdoorPlayStartTime'+'～'+'outdoorPlayEndTime'+'</td>'+
				'<td align="center">'+'outdoorUserName'+'</td>'+
				'<td align="center">'+'mediaCost'+'</td>'+
			'</tr>';