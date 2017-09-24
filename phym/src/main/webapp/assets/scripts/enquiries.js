/*页面加载时查询*/
function enquiriesOutDoors(){
	var url='outdoor/findoutScreen.do';
	var data={};
	$.post(url, data, function(result){
		if(result.state==SUCCESS){
			
			var list = result.data;
			showOutDoors(list);
		}else{
			alert(result.message);
		}
	});
}

/* 检索查询 */
function search_adv(){
	$(".tbody").empty();
	var url='outdoor/searchOutDoor.do';
	var data={"outdoorProvince":$("#province_div input").val(),"outdoorCity":$("#city_div input").val(),
			"outdoorCountry":$("#area_div input").val(),"outdoorFrequency":$("#select_fre span:first").html(),
			"outdoorMediasourceType":$("#select_type span:first").html()};
	
	$.post(url,data,function(result){
		if(result.state==SUCCESS){
			var list = result.data;
			showOutDoors(list);
		}else{
			alert(result.message);
		}
	});
};

var outDoorsTemplate='<tr style="width: 100%;" >'+
					'<td style="width: 1%"><input type="checkbox" name="test" class="cartBox" value="outdoorId"></td>'+
					'<td id="id1" style="width: 1%">'+
					'[id]' +'</td>'+
					'<td style="width: 15%"><a href="#">'+
					'[outdoorName]'+'</a></td>'+
					'<td class="city" style="width: 25%">'+
					'[outdoorAddress]'+'</td>'+
					'<td class="am-hide-sm-only-danjia" style="width: 5%">'+
					'[outdoorUnitPrice]'+'</td>'+
					'<td class="am-hide-sm-only-pinci" style="width:18%"><span id="pinci">'+
						'[outdoorFrequency]'+'<i id="i">/</i></span><span id="pinci">'+'[outdoorFrequency2]'+'<i id="i">/</i>'+
						'</span><span id="pinci">'+'[outdoorFrequency3]'+'<i id="i">/</i></span><span id="pinci">'+'[outdoorFrequency4]'+'<i id="i">/</i>'+
						'</span><span id="pinci">'+'[outdoorFrequency5]'+'</span>'+
					'</td>'+
					'<td class="am-hide-sm-only-time" style="width: 1%;margin-left: 8px;">'+
					'[outdoorPlayStartTime]'+':00-'+'[outdoorPlayEndTime]'+':00'+'</td>'+
				'</tr>';

function showOutDoors(list){
	 $('.tbody').empty();
	 for(var i=0; i<list.length; i++){
	        var outdoors=list[i];
	        var li = outDoorsTemplate.replace('[id]',i+1)
	        						.replace('[outdoorName]',outdoors.outdoorName)
	        						.replace('[outdoorAddress]',outdoors.outdoorAddress)
	        						.replace('[outdoorUnitPrice]',outdoors.outdoorUnitPrice)
	        						.replace('[outdoorFrequency]',outdoors.outdoorFrequency)
	        						.replace("outdoorId",outdoors.outdoorId)
	        						.replace('[outdoorFrequency2]',outdoors.outdoorFrequency*2)
	        						.replace('[outdoorFrequency3]',outdoors.outdoorFrequency*3)
	        						.replace('[outdoorFrequency4]',outdoors.outdoorFrequency*4)
	        						.replace('[outdoorFrequency5]',outdoors.outdoorFrequency*5)
	        						.replace('[outdoorPlayStartTime]',outdoors.outdoorPlayStartTime)
	        						.replace('[outdoorPlayEndTime]',outdoors.outdoorPlayEndTime);
	        //绑定每个笔记本的ID到li元素上
	        $('.tbody').append(li);
	    }
}



/*加入订单*/
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
		addCookie("s",s,2);
	
		window.location.href="order.html";
	}else{
		/*var cook=getCookie("s").split(",");
		var ne="";
		for(var i=0;i<cook.length;i++){
			if(cook[i]==outdoorId3){
				
			}else{
				ne+=cook[i].value+",";
			}
		}*/
		delCookie("s");
		/*addCookie("s",ne,2);*/
	}
}























function showPagedNotesAction(){
	var li = $(this);
	var id=li.data('notebookId');
	$('#pc_part_2 ul').data('notebookId',id);
	
	nextPageNotesAction(true);
}

function nextPageNotesAction(firstPage){
	console.log('More...');
	
	//获取当前UL上绑定的笔记本ID
	var notebookId=$('#pc_part_2 ul').data('notebookId');
	var page;
	if(firstPage===true){ //true
		page=0;
	}else{
		//当前页号
		page=$('#pc_part_2 ul').data('page');
	}
	//绑定下个页号
	$('#pc_part_2 ul').data('page',page+1);
	console.log(notebookId);
	//ajax 	notebookId	
	var url='note/list2.do';
	var data={notebookId:notebookId,
			page:page};
	console.log(data)
	$.getJSON(url, data, function(result){
		if(result.state==SUCCESS){
			var list=result.data;
			showOutDoors(list, page);
		}else{
			alert(result.message);
		}
	});
}










