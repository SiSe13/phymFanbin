var SUCCESS = 0;

$(function(){
	enquiriesOutDoors();
    $("#search_in").click(search_adv);
});

//搜索
function search_adv(){
	$(".tbody").empty();
	var province = $("#province_div div:first").html();
	var city = $("#city_div div:first").html();
	var area = $("#area_div div:first").html();
	var scrtype = $("#select_screen span:first").html();
	var type = $("#select_type span:first").html();
	var userId=getCookie("userId");
	$.ajax({
		url:"mtout/loadouts.do",
		type:"post",
		data:{"outdoorProvince":province,"outdoorCity":city,"outdoorCountry":area,"outdoorScreenType":scrtype,"outdoorMediasourceType":type,"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status == SUCCESS){
				var list = result.data;
				for(var i=0;i<list.length;i++){
					var screenName = list[i].outdoorName;
					var address = list[i].outdoorAddress;
					var price = list[i].outdoorUnitPrice;
					var remainTime = list[i].remainTime;
					var scrtype = list[i].outdoorScreenType;
					var timeSt = list[i].outdoorPlayStartTime;
					var timeEnd = list[i].outdoorPlayEndTime;
					var createdDate =list[i].outdoorCreatedDate;
					var outDoorId = list[i].outdoorId;
					createTr(i+1,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,createdDate,outDoorId);
				}
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("搜索失败");
		}
	});
};
//加载tr
function createTr(i,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,createdDate,outDoorId){
		var str ="";
		str +=		' <tr style="width: 100%;">';
		str +=		'    <td id="id1">'+i+'</td>';
		str +=		'    <td><a href="javascript:void(0);" title="'+screenName+' " style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 100px;" >'+screenName+'</a></td>';
		str +=		'    <td class="city"><a href="javascript:void(0);"  title='+address+' style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 250px;">'+address+'</a></td>';
		str +=		'    <td class="am-hide-sm-only-danjia">'+price+'</td>';
		str +=		'    <td class="am-hide-sm-only-pinci" >'+remainTime+'</td>';
		str +=		'    	<td class="particulars" >'+scrtype+'</td>';
		str +=		'    <td class="am-hide-sm-only-time"> '+timeSt+':00-'+timeEnd+':00</td>';
		str +=		'  	 <td class="am-hide-sm-only-time1">'+date+' </td> ';
		str +=		'	 <td class="am-hide-sm-only-modification" >';
		str +=		'		<div class="am-btn-toolbar">';
		str +=		'    		<div class="am-btn-group am-btn-group-xs">';
		str +=		'			<a href="javascript:void(0);" onclick=modification("'+outDoorId+'") class="am-icon-copy">修改</a> ';
		str +=		'			</div>';
		str +=		'  		</div>  ';
		str +=		'	</td>';
		str +=		'    <td>';
		str +=		'        <div class="am-btn-toolbar">';
		str +=		'            <div class="am-btn-group am-btn-group-xs">';
		str +=		'                <a href="javascript:void(0);" onclick=details("'+outDoorId+'") class="am-icon-pencil-square-o">详情</a> ';
		str +=		'            </div>';
		str +=		'        </div>';
		str +=		'    </td>';
		str +=		'</tr>';
		
		var $tr = $(str);
		$tr.data("outDoorId",outDoorId);
		$(".tbody").append($tr);
}

//点击户外大屏加载资源
function enquiriesOutDoors(){
	$(".tbody").empty();
	var province = $("#province_div div:first").html();
	var city = $("#city_div div:first").html();
	var area = $("#area_div div:first").html();
	var scrtype = $("#select_screen span:first").html();
	var type = $("#select_type span:first").html();
	var userId=getCookie("userId");
	$.ajax({
		url:"mtout/loadout.do",
		type:"post",
		data:{"outdoorProvince":province,"outdoorCity":city,"outdoorCountry":area,"outdoorScreenType":scrtype,"outdoorMediasourceType":type,"userId":userId},
		dataType:"json",
		success:function(result){
			$(".tbody").empty();
			if(result.status == SUCCESS){
				var list = result.data;
				for(var i=0;i<list.length;i++){
					var screenName = list[i].outdoorName;
					var address = list[i].outdoorAddress;
					var price = list[i].outdoorUnitPrice;
					var remainTime = list[i].remainTime;
					var scrtype = list[i].outdoorScreenType;
					var timeSt = list[i].outdoorPlayStartTime;
					var timeEnd = list[i].outdoorPlayEndTime;
					var createdDate =list[i].outdoorCreatedDate;
					var outDoorId = list[i].outdoorId;
					dataHoutai(list[i].outdoorCreatedDate);
					createTr(i+1,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,createdDate,outDoorId);
				}
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("网络延迟")
		}
	});
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
}

//修改
function modification(outDoorId){
	window.location.href="../advertiser/media-modification.html?outDoorId="+outDoorId;
}

