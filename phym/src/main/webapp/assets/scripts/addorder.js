var SUCCESS=0;

$(function(){
	Addindent();
});


function Addindent(){
	var url="outdoor/findoutScreencontent.do";
	
	//console.log(getCookie("s"));
	var data={"outdoorId":getCookie("s")};
	$.post(url,data,function(result){
		if(result.state==SUCCESS){
			var list = result.data;
			$('.tbody').empty();
			for(var i=0;i<list.length;i++ ){
				//console.log(i);
				showOutDoors(list[i],i);
				
			}
		}else{
			alert(result.message);
		}
	});
}


var outDoorsTemplate='<tr style="width: 100%;" id="outdoorId">'+
					'<td style="width: 1%"><input type="checkbox" name="test" class="cartBox"></td>'+
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
					'<td class="am-hide-sm-only-time" style="width: 1%;margin-left: 8px;" onclick=deleteDoors("outdoorId3")>删除</td>'+
					'</tr>';

function showOutDoors(outdoors,i){

var li = outDoorsTemplate.replace('[id]',i+1)
				.replace('[outdoorName]',outdoors.outdoorName)
				.replace('[outdoorAddress]',outdoors.outdoorAddress)
				.replace('[outdoorUnitPrice]',outdoors.outdoorUnitPrice)
				.replace('[outdoorFrequency]',outdoors.outdoorFrequency)
				.replace("outdoorId",outdoors.outdoorId)
				.replace("outdoorId3",outdoors.outdoorId)
				.replace('[outdoorFrequency2]',outdoors.outdoorFrequency*2)
				.replace('[outdoorFrequency3]',outdoors.outdoorFrequency*3)
				.replace('[outdoorFrequency4]',outdoors.outdoorFrequency*4)
				.replace('[outdoorFrequency5]',outdoors.outdoorFrequency*5)
				.replace('[outdoorPlayStartTime]',outdoors.outdoorPlayStartTime)
				.replace('[outdoorPlayEndTime]',outdoors.outdoorPlayEndTime);
	//绑定每个笔记本的ID到li元素上
	$('.tbody').append(li);

}

function deleteDoors(outdoorId3){
	//console.log(11111111);
	$("#"+outdoorId3).remove();
	delCookie(outdoorId3);
	var cook=getCookie("s").split(",");
	var ne="";
	for(var i=0;i<cook.length;i++){
		if(cook[i]==outdoorId3){
		}else{
			ne+=cook[i];
		}
	}
	delCookie("s");
	addCookie("s",ne,2);
	
}