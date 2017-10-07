var SUCCESS = 0;
var pageSize = 10;    //每页显示的记录条数
var len;            //总行数
var page = 1;            //总页数

$(function(){
	        //获取大屏数据总数
			loadCounts();
			//点击户外大屏加载资源
			enquiriesOutDoors();
    		//搜索
    		$("#search_in").click(function(){
    			loadCounts();
    		}); 
    	});

//搜索
function search_adv(page,flag){
	var pager = page*pageSize-pageSize;
	$(".tbody").empty();
	var province = $("#province_div div:first").html();
	var city = $("#city_div div:first").html();
	var area = $("#area_div div:first").html();
	var scrtype = $("#select_screen span:first").html();
	var type = $("#select_type span:first").html();
	$.ajax({
		url:"outdoor/searchOutDoor.do",
		type:"post",
		data:{"outdoorProvince":province,"outdoorCity":city,"outdoorCountry":area,"outdoorScreenType":scrtype,"outdoorMediasourceType":type,"pager":pager},
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
					var outDoorId = list[i].outdoorId;
					createTr(i,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,outDoorId);
				}
				
				var ss = list.length;
				if(flag==1){
					displaypage();
				}else{
					displaypage();
				}
			}
		},
		error:function(){
			alert("搜索失败");
		}
	});
};
//加载tr
function createTr(i,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,outDoorId){
		var str ="";
		str +=		' <tr style="width: 100%;">';
		str +=		'    <td id="id1">'+(i+(page-1)*pageSize+1)+'</td>';
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
		
};

//根据数据库记录数计算页数
function displaypage(){
	allpage=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
	var sst ="";
	for(var i =1;i<=allpage;i++){
		if(page == i){
			sst += '<li class="am-active"><a href="javascript:void(0)">'+i+'</a></li>';
		}else{
			sst += '<li><a href="javascript:void(0)"  onclick="pageTurning('+i+')">'+i+'</a></li>';
		}
	}
	$(".am-pagination").html(sst);
}
//点击翻页
function pageTurning(i){
    page = i
	search_adv(i,0);
};
//查询数据库记录数
function loadCounts(){
	var province = $("#province_div div:first").html();
	var city = $("#city_div div:first").html();
	var area = $("#area_div div:first").html();
	var scrtype = $("#select_screen span:first").html();
	var type = $("#select_type span:first").html();
	$.ajax({
		url:"outdoor/loadCounts.do",
		type:"post",
		data:{"outdoorProvince":province,"outdoorCity":city,"outdoorCountry":area,"outdoorScreenType":scrtype,"outdoorMediasourceType":type},
		dataType:"json",
		success:function(result){
			if(result.status==SUCCESS){
				len = result.data;
				page = 1;
    			search_adv(1,1);
			}
		},
		error:function(){
			alert("网络延迟");
		}
	});
};

//点击户外大屏加载资源
function enquiriesOutDoors(){
	var province = $("#province_div div:first").html();
	var city = $("#city_div div:first").html();
	var area = $("#area_div div:first").html();
	var scrtype = $("#select_screen span:first").html();
	var type = $("#select_type span:first").html();
	var pager = 0;
	$.ajax({
		url:"outdoor/findoutScreen.do",
		type:"post",
		data:{"outdoorProvince":province,"outdoorCity":city,"outdoorCountry":area,"outdoorScreenType":scrtype,"outdoorMediasourceType":type,"pager":pager},
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
					var outDoorId = list[i].outdoorId;
					
					createTr(i,screenName,address,price,remainTime,scrtype,timeSt,timeEnd,outDoorId);
				}
				displaypage();
			}
		},
		error:function(){
			alert("网络延迟")
		}
	});
};
