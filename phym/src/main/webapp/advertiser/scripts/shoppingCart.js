var SUCCESS=0;
var page = 1;  
$(function(){
	shopping();
});

function shopping(){
	var url=window.location.href;	  //获取当前页面的url
	var b=url.split("?")[1]; //获取第一个参数以后的内容 
	var c=b.split("&");   //从指定的地方将字符串分割成字符串数组
	var arr=new Array();  //新建一个数组
	for(var i=0;i<c.length;i++){
	 	 var d=c[i].split("=")[1]; //从=处将字符串分割成字符串数组,并选择第2个元素
	         arr.push(decodeURI(d));	 //将获取的元素存入到数组中	
	}
	
	setCookie("bofangshichang",arr[1]);
	
	var url="outdoor/filtrateScreen.do";
	var data={checkshipin:arr[0],shichang:arr[1],outdoorProvince:arr[2],outdoorCity:arr[3],outdoorCountry:arr[4],
			outdoorScreenType:arr[5],outdoorMediasourceType:arr[6],pager:page};
	
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			var list=result.data;
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
		}
	});
}

function createTr(i,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,outDoorId){
	var str ="";
	str +=		' <tr style="width: 100%;">';
	str +=		' <td ><input type="checkbox" class="cartBox" name="test"value="'+outDoorId+'"></td>';
	str +=		'    <td id="id1">'+i+'</td>';
	str +=		'    <td><a href="javascript:void(0);" title="'+screenName+' " style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 100px;" >'+screenName+'</a></td>';
	str +=		'    <td class="city"><a href="javascript:void(0);"  title='+address+' style=" display: block;overflow: hidden;white-space: nowrap;text-overflow:ellipsis;width: 250px;">'+address+'</a></td>';
	str +=		'    <td class="am-hide-sm-only-danjia">'+price+'</td>';
	str +=		'    <td class="am-hide-sm-only-pinci" >'+remainTime+'</td>';
	str +=		'    	<td class="particulars" >'+scrtype+'</td>';
	str +=		'    <td class="am-hide-sm-only-time"> '+timeSt+':00-'+timeEnd+':00</td>';
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

//点击加入购物车
function loadOutDoorAction(){
	var check_in = $(".cartBox").is(":checked");
	if(check_in){
		var obj=document.getElementsByName("test");
		var s="";
		for(var i=0;i<obj.length;i++){
			if(obj[i].checked){
				s+=obj[i].value+',';
			}
		}
		setCookie("gwc",s);
		window.location.href="order.html";
		}else{
			alert("请选择投放资源");
			var cook=getCookie("gwc").split(",");
			var ne="";
			for(var i=0;i<cook.length;i++){
				
			}
			delCookie("gwc");
			addCookie("gwc",ne,2);
		}
};