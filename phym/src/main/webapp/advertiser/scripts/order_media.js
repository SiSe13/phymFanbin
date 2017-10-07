var SUCCESS = 0;

$(function(){
	loadOrder();
});

//加载购物车
function loadOrder(){
	$.ajax({
		url:"outdoor/findoutScreencontent.do",
		type:"post",
		data:{"outDoorId":getCookie("gwc")},
		dataType:"json",
		success:function(result){
			if(result.status == SUCCESS){
				var list = result.data;
				$(".tbody").empty();
				for(var i=0;i<list.length;i++){
					var screenName = list[i].outdoorName;
					var address = list[i].outdoorAddress;
					var price = list[i].outdoorUnitPrice;
					var remainTime = list[i].remainTime;
					var scrtype = list[i].outdoorScreenType;
					var timeSt = list[i].outdoorPlayStartTime;
					var timeEnd = list[i].outdoorPlayEndTime;
					var outDoorId = list[i].outdoorId;
					createTr(i+1,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,outDoorId);
				}
			}else{
				alert("您还没有订单");
				window.location.href='outdoors-resources.html';
			}
		},
		error:function(){
			alert("订单加载失败");
			
		}
	})
};

//提交订单
function submitOrders(){
	var arr=getCookie("gwc").split(",");
	var n="";
	for(var i=0;i<arr.length;i++){
		n+=arr[i];
	}
	addCookie("x",n,2);
	if(getCookie("x")!=""){
		window.location.href='audit.html';
	}else{
		alert("您还没有订单,请先加入订单再来提交");
		window.location.href='outdoors-resources.html';
	}
}

//删除购物车大屏
function deleteDoors(outDoorId){
	$("."+outDoorId).remove();
	delCookie(outDoorId);
	var cook=getCookie("gwc").split(",");
	var ne="";
	for(var i=0;i<cook.length;i++){
		if(cook[i]==outDoorId){
		}else{
			ne+=cook[i]+",";
		}
	}
	delCookie("gwc");
	addCookie("gwc",ne,2);
}

//加载tr
function createTr(i,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,outDoorId){
	var str ="";
	str +=		' <tr style="width: 100%;" class='+outDoorId+'>';
	str +=		'    <td id="id1">'+i+'</td>';
	str +=		'    <td><a href="javascript:void(0);" title="'+screenName+' " style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 100px;" >'+screenName+'</a></td>';
	str +=		'    <td class="city"><a href="javascript:void(0);"  title='+address+' style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 250px;">'+address+'</a></td>';
	str +=		'    <td class="am-hide-sm-only-danjia">'+price+'</td>';
	str +=		'    <td class="am-hide-sm-only-pinci" >'+remainTime+'</td>';
	str +=		'    	<td class="particulars" >'+scrtype+'</td>';
	str +=		'    <td class="am-hide-sm-only-time"> '+timeSt+':00-'+timeEnd+':00</td>';
	str +=		'	 <td class="am-hide-sm-only-delete" >';
	str +=		'		<div class="am-btn-toolbar">';
	str +=		'    		<div class="am-btn-group am-btn-group-xs">';
	str +=		'       		<a href="javascript:void(0);" onclick=deleteDoors("'+outDoorId+'") class="am-icon-trash-o am-text-danger">删除</a> ';
	str +=		' 			</div>';
	str +=		'   	</div>  ';
	str +=		'	 </td>';
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